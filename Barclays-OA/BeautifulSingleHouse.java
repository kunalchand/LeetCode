import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BeautifulSingleHouse {
    public static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void generatePlot(int[][] plot, int[][] grid, int N, int M) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                plot[i][j] = grid[i - 1][j - 1];
            }
        }
    }

    public static void generateHouseList(int N, int M, int[][] plot, ArrayList<Coordinate> houseList) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (plot[i][j] == 1) {
                    houseList.add(new Coordinate(i, j));
                }
            }
        }
    }

    public static void dfs(int x, int y, int[][] plot, int[][] visited, ArrayList<Coordinate> singleHouse) {
        if (plot[x][y] == 0) {
            return;
        } else if (plot[x][y] == 1 && visited[x][y] == 1) {
            return;
        } else if (plot[x][y] == 1 && visited[x][y] == 0) {
            visited[x][y] = 1;
            singleHouse.add(new Coordinate(x, y));

            // up
            dfs(x - 1, y, plot, visited, singleHouse);
            // down
            dfs(x + 1, y, plot, visited, singleHouse);
            // left
            dfs(x, y - 1, plot, visited, singleHouse);
            // right
            dfs(x, y + 1, plot, visited, singleHouse);
        }
    }

    public static boolean checkPartOfHouse(int x, int y, HashMap<Integer, HashSet<Integer>> singleHouseMap) {
        if (!singleHouseMap.containsKey(x))
            return false;
        else if (!singleHouseMap.get(x).contains(y))
            return false;
        else
            return true;
    }

    public static boolean isBeautifulHouse(int[][] plot, ArrayList<Coordinate> singleHouse) {
        HashMap<Integer, HashSet<Integer>> singleHouseMap = new HashMap<>();
        for (Coordinate coordinate : singleHouse) {
            Integer x = coordinate.x;
            Integer y = coordinate.y;
            if (!singleHouseMap.containsKey(x)) {
                singleHouseMap.put(x, new HashSet<>());
            }
            singleHouseMap.get(x).add(y);
        }

        for (Coordinate coordinate : singleHouse) {
            int x = coordinate.x;
            int y = coordinate.y;
            // top-left diagonal
            if (plot[x - 1][y - 1] == 1 && !checkPartOfHouse(x - 1, y - 1, singleHouseMap)) {
                // System.out.println("top-left" + (x-1) + " " + (y-1));
                return false;
            }
            // top-right diagonal
            if (plot[x - 1][y + 1] == 1 && !checkPartOfHouse(x - 1, y + 1, singleHouseMap)) {
                // System.out.println("top-right" + (x-1) + " " + (y+1));
                return false;
            }
            // bottom-left diagonal
            if (plot[x + 1][y - 1] == 1 && !checkPartOfHouse(x + 1, y - 1, singleHouseMap)) {
                // System.out.println("bottom-left" + (x+1) + " " + (y-1));
                return false;
            }
            // bottom-right diagonal
            if (plot[x + 1][y + 1] == 1 && !checkPartOfHouse(x + 1, y + 1, singleHouseMap)) {
                // System.out.println("bottom-right" + (x+1) + " " + (y+1));
                return false;
            }
        }
        return true;
    }

    public static void printSingleHouseBeauty(ArrayList<Coordinate> singleHouse, Boolean beauty) {
        for (Coordinate coordinate : singleHouse) {
            System.out.println((coordinate.x - 1) + " " + (coordinate.y - 1));
        }
        System.out.println(beauty);
        System.out.println();
    }

    public static int solution(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;

        int[][] plot = new int[N + 2][M + 2];
        int[][] visited = new int[N + 2][M + 2];
        ArrayList<Coordinate> houseList = new ArrayList<>();

        generatePlot(plot, grid, N, M);
        generateHouseList(N, M, plot, houseList);

        int count = 0;
        for (int i = 0; i < houseList.size(); i++) {
            int x = houseList.get(i).x;
            int y = houseList.get(i).y;

            ArrayList<Coordinate> singleHouse = new ArrayList<>();
            // perform dfs and create a single house
            dfs(x, y, plot, visited, singleHouse);

            // check beauty of single house
            if (singleHouse.size() > 0) {
                if (isBeautifulHouse(plot, singleHouse)) {
                    // single house is beautiful
                    count++;
                    // printSingleHouseBeauty(singleHouse, true);
                } else {
                    // single house is not beautiful
                    // printSingleHouseBeauty(singleHouse, false);
                }
            }

            // Clear singleHouse
            singleHouse.clear();
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 0, 1, 1 },
                { 0, 0, 1, 0 },
                { 1, 0, 1, 1 },
                { 1, 0, 1, 0 }
        };

        System.out.println("Total number of beautiful single houses for grid1: " + solution(grid) + "\n");

        int[][] grid2 = {
                { 1, 0, 0, 0, 0, 1, 1 },
                { 0, 1, 0, 0, 0, 1, 0 },
                { 0, 0, 1, 0, 0, 1, 1 },
                { 1, 0, 0, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0 }
        };

        System.out.println("Total number of beautiful single houses for grid2: " + solution(grid2) + "\n");

        int[][] grid3 = {
                { 0, 0, 0, 0, 0, 1, 1 },
                { 0, 1, 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0 }
        };

        System.out.println("Total number of beautiful single houses for grid3: " + solution(grid3) + "\n");

        int[][] grid4 = {
                { 1, 1, 0, 0 },
                { 0, 1, 0, 0 },
                { 0, 0, 1, 1 },
                { 0, 0, 1, 1 }
        };

        System.out.println("Total number of beautiful single houses for grid4: " + solution(grid4) + "\n");
    }

}
