
public class Leaderboard {
    // https://www.lowleveldesign.io/LLD/GameDesign/Scoreboard
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

    public void reset(int playerId) {

    }

    public int top(int K) {
        return 0;
    }

    public void addScore(int playerId, int score) {

    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();

        leaderboard.addScore(1, 73); // leaderboard = [[1,73]];
        leaderboard.addScore(2, 56); // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3, 39); // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4, 51); // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5, 4); // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        print(leaderboard.top(1)); // returns 73;
        leaderboard.reset(1); // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2); // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2, 51); // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        print(leaderboard.top(3)); // returns 141 = 51 + 51 + 39;
    }
}
