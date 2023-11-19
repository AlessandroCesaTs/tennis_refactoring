
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;


    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1==m_score2)
        {
            return sameScore();
        }
        else if (m_score1>=4 || m_score2>=4)
        {
           return advantage();
        }
        else
        {
            return different_score();
        }
    }

    private String getScoreString(int tempScore) {
        String score="";
        switch(tempScore)
        {
            case 0:
                score +="Love";
                break;
            case 1:
                score +="Fifteen";
                break;
            case 2:
                score +="Thirty";
                break;
            case 3:
                score +="Forty";
                break;
        }
        return score;
    }

    private String different_score() {
        String score;
        score = getScoreString(m_score1);
        score+="-";
        score += getScoreString(m_score2);
        return score;
    }


    private String sameScore() {
        String score;
        if (m_score1==3 || m_score1==4){
            score="Deuce";
        }else{
            score= getScoreString(m_score1);
            score+="-All";
        }
        return score;
    }

    private String advantage() {
        String score;
        int minusResult = m_score1-m_score2;
        if (minusResult==1) score ="Advantage "+player1Name;
        else if (minusResult ==-1) score ="Advantage "+player2Name;
        else if (minusResult>=2) score = "Win for "+player1Name;
        else score ="Win for "+player2Name;
        return score;
    }
}
