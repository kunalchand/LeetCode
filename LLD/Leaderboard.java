// https://www.lowleveldesign.io/LLD/GameDesign/Scoreboard

public class Leaderboard {

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static class Player {
        private Integer playerId;
        private Integer score;

        public Player(Integer playerId, Integer score) {
            this.playerId = playerId;
            this.score = score;
        }

        public Integer getPlayerId() {
            return playerId;
        }

        public void setPlayerId(Integer playerId) {
            this.playerId = playerId;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }

    public static void reset(int playerId) {

    }

    public static int top(int K) {

    }

    public static void addScore(int playerId, int score) {

    }

    public static void main(String[] args) {
    }
}
