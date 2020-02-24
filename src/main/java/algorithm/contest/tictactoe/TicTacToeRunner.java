package algorithm.contest.tictactoe;

import algorithm.contest.Algorithm;
import algorithm.contest.ContestAction;

import static algorithm.contest.tictactoe.TicTacToeGame.*;

public class TicTacToeRunner {
    private final Algorithm algorithm1;
    private final Algorithm algorithm2;
    TicTacToeMap map = new TicTacToeMap();

    public TicTacToeRunner(Algorithm algorithm1, Algorithm algorithm2) {
        this.algorithm1 = algorithm1;
        this.algorithm2 = algorithm2;
    }

    public void run() throws Exception {

        // new game
        algorithm1.nextAction(new NewGame(Mark.CROSS));
        algorithm2.nextAction(new NewGame(Mark.NOUGHT));

        ContestAction action = algorithm1.nextAction(new FirstTurn(map));

        if (!(action instanceof MoveAction)) {
            end(new Loss(), new Win());
            return;
        }

        Move move = ((MoveAction) action).getMove();
        if (map.contains(move)) {
            end(new Loss(), new Win());
            return;
        }

        map = map.move(move);

        while (true) {
            action = algorithm1.nextAction(new NextTurn(move, map));

        }

    }

    private void end(ContestAction action1, ContestAction action2) throws Exception {
        algorithm1.nextAction(action1);
        algorithm2.nextAction(action2);
    }

    private static class TicTacToeMap implements Map {

        private final Mark[][] marks;

        TicTacToeMap() {
            this(emptyMarks());
        }

        TicTacToeMap(Mark[][] marks) {
            this.marks = marks;
        }

        @Override
        public Mark getMark(int row, int column) {
            return marks[row][column];
        }

        boolean contains(Move move) {
            return marks[move.getRow()][move.getColumn()] != Mark.EMPTY;
        }

        TicTacToeMap move(Move move) {
            Mark[][] copy = marks.clone();
            copy[move.getRow()][move.getColumn()] = move.getMark();
            return new TicTacToeMap(copy);
        }

        private static final Mark[][] emptyMarks() {
            Mark[][] marks = new Mark[3][3];
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    marks[row][column] = Mark.EMPTY;
                }
            }
            return marks;
        }
    }
}
