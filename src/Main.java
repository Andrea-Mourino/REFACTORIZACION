public class Main {
    /**
     * metodo para devolver la puntuacion de tenis
     */
    public static String getScore( int pointsPlayer1, int pointsPlayer2) {
        String score = "";
        int tempScore=0;

        if (isTie(pointsPlayer1, pointsPlayer2)) {
            score = getTieScores(pointsPlayer1);
        } else if (isAdvantageOrWin(pointsPlayer1, pointsPlayer2)) {
            score = getAdvantageOrWinScores(pointsPlayer1, pointsPlayer2);
        } else {
            score = getRegularScores(pointsPlayer1, pointsPlayer2, score);
        }

    return score;
    }

    private static String getRegularScores(int pointsPlayer1, int pointsPlayer2, String score) {
        int tempScore;
        for (int i = 1; i<3; i++) {
            if (i==1)
                tempScore = pointsPlayer1;
            else {
                score +="-";
                tempScore = pointsPlayer2;
            }
            switch(tempScore) {
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
        }
        return score;
    }

    private static String getAdvantageOrWinScores(int pointsPlayer1, int pointsPlayer2) {
        String score;
        int minusResult = pointsPlayer1 - pointsPlayer2;
        if (minusResult==1) {
            score ="Advantage player1";
        } else if (minusResult ==-1) {
            score ="Advantage player2";
        } else if (minusResult>=2) {
            score = "Win for player1";
        } else {
            score ="Win for player2";
        }
        return score;
    }

    private static boolean isAdvantageOrWin(int pointsPlayer1, int pointsPlayer2) {
        return pointsPlayer1 >= 4 || pointsPlayer2 >= 4;
    }

    private static String getTieScores(int pointsPlayer1) {
        String score;
        switch (pointsPlayer1)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private static boolean isTie(int pointsPlayer1, int pointsPlayer2) {
        return pointsPlayer1 == pointsPlayer2;
    }
}