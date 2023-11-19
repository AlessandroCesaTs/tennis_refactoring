
public class TennisGame1 implements TennisGame {
    
    private int score1 = 0; //points of player 1
    private int score2 = 0; //points of player 2
    private final String player1Name;
    private final String player2Name;


    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        //add a point to the score of a player
        if (playerName.equals(player1Name))
            score1 += 1;
        else
            score2 += 1;
    }

    public String getScore() {
        //get the score of the game
        if (score1 == score2) //players have same score
        {
            return sameScore();
        }
        else if (score1 >=4 || score2 >=4) //one player has scored more than 3 times, advantage situation
        {
           return advantage();
        }
        else //players have different scores without advantage
        {
            return different_score();
        }
    }

    private String sameScore() {
        //get the score in case the players have same scores
        String score;
        if (score1 ==3 || score1 ==4){ //"deuce" situation
            score="Deuce";
        }else{
            score= getScoreString(score1);
            score+="-All";
        }
        return score;
    }

    private String advantage() {
        //get the score in case of advantage
        String score;
        int minusResult = score1 - score2;
        if (minusResult==1) score ="Advantage "+player1Name;
        else if (minusResult ==-1) score ="Advantage "+player2Name;
        else if (minusResult>=2) score = "Win for "+player1Name;
        else score ="Win for "+player2Name;
        return score;
    }

    private String different_score() {
        //get the score in case the players have different scores
        String score;
        score = getScoreString(score1);
        score+="-";
        score += getScoreString(score2);
        return score;
    }

    private String getScoreString(int scoreInt) {
        //given the number of points made, get the string of the score
        String scoreString="";
        switch(scoreInt)
        {
            case 0:
                scoreString +="Love";
                break;
            case 1:
                scoreString +="Fifteen";
                break;
            case 2:
                scoreString +="Thirty";
                break;
            case 3:
                scoreString +="Forty";
                break;
        }
        return scoreString;
    }
}
