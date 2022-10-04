import java.util.ArrayList;
import java.util.List;

class PacificAtlanticOcean {
    private boolean [][] vis;
    private Character [][] waterFlow;
    private class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private int [][] dir = {{-1, 0}, {0, 1}, {1,0}, {0,-1}};
    private boolean validate(int nr, int nc, int [][] heights){
        if(nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length){
            return true;
        }
        return false;
    }
    private List<Pair> getAllPeakElements(int [][] heights){
        List<Pair> peakElements = new ArrayList<>();
        for(int i = 0; i<heights.length; i++){
            for(int j = 0; j<heights[0].length; j++){
                int count = 0;
                for(int [] d : dir){
                    int nr = i + d[0];
                    int nc = j + d[1];
                    if(isGreater(i, j, nr, nc, heights)){
                        count++;
                    }
                }
                if(count == 4){
                    peakElements.add(new Pair(i, j));
                }
            }
        }
        return peakElements;
    }
    private boolean isGreater(int x1, int y1, int x2, int y2, int [][] heights){
        if(validate(x2, y2, heights) && heights[x2][y2] > heights[x1][y1]){
            return false;
        }
        return true;
    }
    private boolean isPacific(Character c1, Character c2, Character c3, Character c4){
        if(c1 == 'P' || c2 == 'P' || c3 == 'P' || c4 == 'P'){
            return true;
        }
        return false;
    }
    private boolean isAtlantic(Character c1, Character c2, Character c3, Character c4){
        if(c1 == 'A' || c2 == 'A' || c3 == 'A' || c4 == 'A'){
            return true;
        }
        return false;
    }
    private boolean isBoth(Character c1, Character c2, Character c3, Character c4){
        if(c1 == 'M' || c2 == 'M' || c3 == 'M' || c4 == 'M'){
            return true;
        }
        return false;
    }
    private Character dfs(int i, int j, int [][] heights){
        if(vis[i][j]){
            return 'X';
        }
        if(waterFlow[i][j] != null){
            return waterFlow[i][j];
        }
        vis[i][j] = true;
        Character c1 = 'X';
        Character c2 = 'X';
        Character c3 = 'X';
        Character c4 = 'X';
        if(i > 0){
            if(heights[i-1][j] < heights[i][j])
            c1 = dfs(i -1, j, heights);
        }else{
            c1 = 'P';
        }
        if(j > 0){
            if(heights[i][j-1] < heights[i][j])
            c4 = dfs(i, j - 1, heights);
        }else{
            c4 = 'P';
        }
        if(i < heights.length-1){
            if(heights[i+1][j] < heights[i][j])
            c3 = dfs(i+1, j, heights);
  i      }else{
            c3 = 'A';
        }
        if(j < heights[0].length-1){
            if(heights[i][j+1] < heights[i][j])
            c2 = dfs(i, j+1, heights);
        }else{
            c2 = 'A';
        }
        
        if((isPacific(c1, c2, c3, c4) && isAtlantic(c1, c2, c3, c4)) || isBoth(c1, c2, c3, c4)){
            waterFlow[i][j] = 'M';
        }else if(isPacific(c1, c2, c3, c4)){
            waterFlow[i][j] = 'P';
        }else if(isAtlantic(c1, c2, c3, c4)){
            waterFlow[i][j] = 'A';
        }else{
            waterFlow[i][j] = 'X';
        }
        vis[i][j] = false;
        return waterFlow[i][j];
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        vis = new boolean[n][m];
        waterFlow = new Character[n][m];
        List<Pair> peakElements = getAllPeakElements(heights);
        for(int i = 0; i<peakElements.size(); i++){
            Pair p = peakElements.get(i);
            //if(waterFlow[p.x][p.y] == null){
                
                Character res = dfs(p.x, p.y, heights);
                if(res == 'M'){
                    List<Integer> li = new ArrayList<>();
                    li.add(p.x);
                    li.add(p.y);
                    ans.add(li);
                }
            //}
        }
        return ans;
    }
}
