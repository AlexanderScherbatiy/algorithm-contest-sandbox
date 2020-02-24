package algorithm.contest.tictactoe;

import algorithm.contest.ContestAction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

import static algorithm.contest.tictactoe.TicTacToeGame.*;

public class TicTacToeAlgorithmTest {

    @Test
    public void testNewGame() throws Exception {

        TicTacToeRandomAlgorithm randomAlgorithm = new TicTacToeRandomAlgorithm();

        ContestAction action = randomAlgorithm.nextAction(new NewGame(Mark.CROSS));
        Assert.assertTrue(action instanceof Idle);
    }

    @Test
    public void testFirstTurn() throws Exception {

        TicTacToeRandomAlgorithm randomAlgorithm = new TicTacToeRandomAlgorithm();

        randomAlgorithm.nextAction(new NewGame(Mark.CROSS));

        ContestAction action = randomAlgorithm.nextAction(new FirstTurn(new TestMap()));
        Assert.assertTrue(action instanceof MoveAction);

        Move move = ((MoveAction) action).getMove();
        Assert.assertEquals(Mark.CROSS, move.getMark());
    }


    private static class TestCell {
        final int row;
        final int column;
        final Mark mark;


        public TestCell(int row, int column, Mark mark) {
            this.row = row;
            this.column = column;
            this.mark = mark;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() == obj.getClass()) {
                TestCell that = (TestCell) obj;
                return this.row == that.row
                        && this.column == that.column
                        && this.mark.equals(that.mark);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column, mark);
        }
    }

    private static class TestMap implements Map {

        private final TestCell[] cells;

        TestMap(TestCell... cells) {
            this.cells = cells;
        }

        @Override
        public Mark getMark(int row, int column) {
            for (TestCell cell : cells) {
                if (cell.row == row && cell.column == column) {
                    return cell.mark;
                }
            }
            return Mark.EMPTY;
        }
    }
}
