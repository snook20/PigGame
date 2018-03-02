package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState state;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        this.state = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (playerIdx == state.getCurrentPlayerID()) {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof PigHoldAction){
            //todo fuck my life
            state.endTurn(true);
            Log.i(TAG, "bob: ");
            return true;

        }
        else if (action instanceof PigRollAction) {
            if (state.roll() == 1) {
                state.endTurn(false);
                return true;
            }
        }
        return false;

    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new PigGameState(state));

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {

        if (state.getScore(0) >= 50 ) {
            String winner = playerNames[0];
            return winner+": "+state.getScore(0);
        }
        else if (state.getScore(1) >= 50){
            String winner = playerNames[1];
            return winner+": "+state.getScore(1);
        }
        return null;
    }

}// class PigLocalGame
