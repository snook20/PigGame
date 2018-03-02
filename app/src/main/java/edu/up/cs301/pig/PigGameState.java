package edu.up.cs301.pig;

        import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by snook20 on 3/1/2018.
 */

public class PigGameState extends GameState{
    private int currentPlayerID;
    private int playerOneScore;
    private int playerTwoScore;
    private int runningTotal;
    private int currentDieVal;

    public PigGameState(){
        currentPlayerID= 0;
        playerOneScore= 0;
        playerTwoScore= 0;
        runningTotal= 0;
        currentDieVal= 1;
    }

    public PigGameState(PigGameState copy){
        currentPlayerID= copy.currentPlayerID;
        playerOneScore= copy.playerOneScore;
        playerTwoScore= copy.playerTwoScore;
        runningTotal= copy.runningTotal;
        currentDieVal= copy.currentDieVal;
    }

    public int getCurrentPlayerID() {
        return currentPlayerID;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public int getCurrentDieVal() {
        return currentDieVal;
    }



    //when player ends turn, adds running total to player's score
    public void endTurn (boolean hold) {
        if (!hold) runningTotal = 0;

        if (currentPlayerID == 0) {
            playerOneScore += runningTotal;
            currentPlayerID = 1;
        }
        else if (currentPlayerID == 1) {
            playerTwoScore += runningTotal;
            currentPlayerID = 0;
        }
        runningTotal = 0;
    }

    //adding roll value to running total
    public int roll (){
        currentDieVal = (int)(Math.random()*6+1);
        runningTotal += currentDieVal;
        return runningTotal;
    }
    public int getScore( int playerID){
        if(playerID == 0 ) return playerOneScore;
        if(playerID == 1 ) return playerTwoScore;
        else return -1;
    }
}
