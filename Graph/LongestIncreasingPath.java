class LongestIncreasingPath{
    private int [][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean validate(int row, int col, int [][] matrix){
        if(row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length){
            return true;
        }
        return false;
    }
    private class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int longestIncreasingPath(int[][] matrix) {
        LinkedList<Pair> q = new LinkedList<>();
        int [][] inDegree = new int[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                for(int [] d : dir){
                    int nr = i + d[0];
                    int nc = j + d[1];
                    if(validate(nr, nc, matrix)){
                        if(matrix[nr][nc] < matrix[i][j]){
                            inDegree[i][j]++;
                        }
                    }
                }
            }
        }

        for(int i = 0; i <matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                if(inDegree[i][j] == 0){
                    q.addLast(new Pair(i, j));
                }
            }
        }

        int level = 0;
        while(q.size() != 0){
            int size = q.size();
            while(size-- != 0){
                Pair rem = q.removeFirst();
                for(int [] d: dir){
                    int nr = rem.x + d[0];
                    int nc = rem.y + d[1];
                    if(validate(nr, nc, matrix)){
                        if(matrix[nr][nc] > matrix[rem.x][rem.y]){
                            if(--inDegree[nr][nc] == 0){
                                q.addLast(new Pair(nr, nc));
                            }
                        }
                    }
                }
            }
            level++;
        }

        return level;                               
    }
}