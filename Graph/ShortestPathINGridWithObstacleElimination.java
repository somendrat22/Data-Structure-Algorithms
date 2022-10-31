import java.util.LinkedList;

public class ShortestPathINGridWithObstacleElimination{
    private class Pair{
        int row;
        int col;
        int leftK;
        Pair(int row, int col, int leftK){
            this.row = row;
            this.col = col;
            this.leftK = leftK;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        boolean [][][] vis = new boolean[grid.length][grid[0].length][k + 1];
        int [][] dir = {{-1,0}, {0, 1}, {1,0}, {0, -1}};
        LinkedList<Pair> q = new LinkedList<>();
        q.addLast(new Pair(0, 0, k));
        int steps  = 0;
        while(q.size() != 0){
            int size = q.size();
            while(size-- != 0){
                Pair rem = q.removeFirst();
                if(vis[rem.row][rem.col][rem.leftK]){
                    continue;
                }
                if(rem.row == grid.length - 1 && rem.col == grid[0].length -1){
                    return steps;
                }
                vis[rem.row][rem.col][rem.leftK] = true;
                for(int [] d : dir){
                    int nr = rem.row + d[0];
                    int nc = rem.col + d[1];
                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length){
                        if(grid[nr][nc] == 1 && rem.leftK - 1 >= 0){
                            q.addLast(new Pair(nr, nc, rem.leftK - 1));
                        }else if(grid[nr][nc] == 0){
                            q.addLast(new Pair(nr, nc, rem.leftK));
                        }else{
                            continue;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}