public class Main {
    /**
     * Metodo para devolver la puntuacion de tenis
     */
    public static String getScore(int pointsPlayer1, int PointsPlayer2) {

        if (isTie(pointsPlayer1, PointsPlayer2)) {
            return getTieScore(pointsPlayer1);
        }
        else if (isAdvantage(pointsPlayer1, PointsPlayer2))
        {
            String score = "";
            return getAdvantage(pointsPlayer1, PointsPlayer2);
        }

        else if (isWin(pointsPlayer1, PointsPlayer2))
        {
            String score = "";
            return getWinScore(pointsPlayer1, PointsPlayer2);
        }
        else
        {
            return getPuntuacionSinVentajaoEmpate(pointsPlayer1, PointsPlayer2);

        }
    }

    private static String getWinScore(int pointsPlayer1, int PointsPlayer2) {

        String score;
        int minusResult = pointsPlayer1 - PointsPlayer2;
        if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static boolean isWin(int pointsPlayer1, int PointsPlayer2) {
        return pointsPlayer1 >= 4 || PointsPlayer2 >= 4;
    }

    private static String getAdvantage(int pointsPlayer1, int PointsPlayer2) {
        String score;
        int minusResult = pointsPlayer1 - PointsPlayer2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static boolean isAdvantage(int pointsPlayer1, int PointsPlayer2) {
        return (pointsPlayer1 >= 4 || PointsPlayer2 >= 4) && (pointsPlayer1 - PointsPlayer2 == 1 || pointsPlayer1 - PointsPlayer2 == -1);
    }

    private static String getPuntuacionSinVentajaoEmpate(int pointsPlayer1, int pointsPlayer2 ) {
        String score = "";
        score = getRegularScores(pointsPlayer1, score);
        score +="-";
        pointsPlayer1 = pointsPlayer2;
        score = getRegularScores(pointsPlayer1, score);
        return score;
    }


    private static String getRegularScores(int pointsPlayer1, String score ) {

        switch(pointsPlayer1)
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


    private static String getTieScore(int pointsPlayers) {
        String []tieScores ={
                "Love-All", "Fifteen-All", "Thirty-All", "Forty-All", "Deuce"
        };
        return pointsPlayers >= 4 ? "Deuce" : tieScores[pointsPlayers];

    }

    private static boolean isTie(int pointsPlayer1, int PointsPlayer2) {
        return pointsPlayer1 == PointsPlayer2;
    }



}