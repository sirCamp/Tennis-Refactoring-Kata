import java.util.HashMap;
import java.util.Map;

/**
 * Created by stefano on 09/06/16.
 */
public class TennisGame4 implements TennisGame {


    private HashMap<String,Integer> scores = new HashMap<String, Integer>();
    static private HashMap<Integer,String> wonscores = new HashMap<Integer, String>(){{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};

    private String player1Name;
    private String player2Name;

    public TennisGame4(String player1Name, String player2Name) {

        this.player1Name = player1Name;
        this.player2Name = player2Name;
        scores.put(player1Name,0);
        scores.put(player2Name,0);
    }

    public void wonPoint(String playerName) {
       scores.put(playerName,scores.get(playerName)+1);
    }

    public String getScore() {

        int scorePlayer1 = scores.get(player1Name);
        int scorePlayer2 = scores.get(player2Name);
        int scoreDifference = scorePlayer1 - scorePlayer2;
        String topPlayer = scoreDifference < 0 ? player2Name : player1Name;

        boolean samescore = (scorePlayer1 == scorePlayer2);

        String score = "";

        if(samescore){

            score = scorePlayer1 < 3? wonscores.get(scorePlayer1)+"-All": "Deuce";
        }
        else if (scorePlayer1>=4 || scorePlayer2>=4){

            score = "Advantage ";
            if(Math.abs(scoreDifference) > 1){
                score = "Win for ";
            }

            score += topPlayer;

        }
        else{


            score = wonscores.get(scorePlayer1)+"-"+wonscores.get(scorePlayer2);
        }

        return score;
    }
}
