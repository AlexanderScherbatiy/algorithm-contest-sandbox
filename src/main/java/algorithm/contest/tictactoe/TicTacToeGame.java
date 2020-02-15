package algorithm.contest.tictactoe;

import algorithm.contest.ContestAction;

/**
 * Data structures for Tic-tac-toe game
 * Actions:
 * - New Game (map)
 * - First Turn (map)
 * - Next Turn (Move(map, row, column), map)
 * - Win/Loss
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
        private final Map map;
        private final Move move;

        public NextTurn(Map map, Move move) {
            this.map = map;
            this.move = move;
        }

        public Map getMap() {
            return map;
        }

        public Move getMove() {
            return move;
        }
    }

    public static class Win implements ContestAction {
    }

    public static class Loss implements ContestAction {
    }
}
