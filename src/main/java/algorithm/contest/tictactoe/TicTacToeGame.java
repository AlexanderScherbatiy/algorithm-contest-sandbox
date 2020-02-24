package algorithm.contest.tictactoe;

import algorithm.contest.ContestAction;

/**
 * Data structures for Tic-tac-toe game
 * Input action -> output action:
 * - New Game (map) -> Idle
 * - First Turn (map) -> MoveAction(Move(mark, row, column)
 * - Next Turn (Move(mark, row, column), map)
 * - Win/Loss
 * - Idle
 */
public class TicTacToeGame {

    enum Mark {
        EMPTY,
        NOUGHT,
        CROSS,
    }

    public interface Map {
        Mark getMark(int row, int column);
    }

    public static class Move {
        private final Mark mark;
        private final int row;
        private final int column;

        public Move(Mark mark, int row, int column) {
            this.mark = mark;
            this.row = row;
            this.column = column;
        }

        public Mark getMark() {
            return mark;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }

    public static class NewGame implements ContestAction {
        private final Mark mark;

        public NewGame(Mark mark) {
            this.mark = mark;
        }

        public Mark getMark() {
            return mark;
        }
    }

    public static class FirstTurn implements ContestAction {
        private final Map map;

        public FirstTurn(Map map) {
            this.map = map;
        }

        public Map getMap() {
            return map;
        }
    }

    public static class NextTurn implements ContestAction {
        private final Move move;
        private final Map map;

        public NextTurn(Move move, Map map) {
            this.move = move;
            this.map = map;
        }

        public Move getMove() {
            return move;
        }

        public Map getMap() {
            return map;
        }
    }

    public static class Idle implements ContestAction {
    }

    public static class MoveAction implements ContestAction {
        private final Move move;

        public MoveAction(Move move) {
            this.move = move;
        }

        public Move getMove() {
            return move;
        }
    }

    public static class Win implements ContestAction {
    }

    public static class Loss implements ContestAction {
    }

    public static class TicTacToeException extends Exception {
        public TicTacToeException(String format, Object... args) {
            super(String.format(format, args));
        }
    }
}
