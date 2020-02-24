package algorithm.contest.tictactoe;

import algorithm.contest.Algorithm;
import algorithm.contest.ContestAction;

import static algorithm.contest.tictactoe.TicTacToeGame.*;

public class TicTacToeRandomAlgorithm implements Algorithm {

    private Mark mark;

    @Override
    public ContestAction nextAction(ContestAction action) throws TicTacToeException {

        if (action instanceof NewGame) {
            this.mark = ((NewGame) action).getMark();
            return new Idle();
        } else if (action instanceof FirstTurn) {
            return new MoveAction(new Move(mark, 0, 0));
        }

        throw new TicTacToeException("Unknown action: %s", action);
    }
}
