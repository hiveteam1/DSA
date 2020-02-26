//Runtime: 2 ms, faster than 99.63% of Java online submissions for Max Area of Island.
//Memory Usage: 43.6 MB, less than 59.26% of Java online submissions for Max Area of Island.

class Solution {
    int count =0;
    public int maxAreaOfIsland(int[][] grid) {
      int r = grid.length;
        int c = grid[0].length;
        
        
        boolean  visited[][] = new boolean[r][c];
        int maxArea = 0;

         for(int i =0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1 ){
                    dfs(grid,i,j,visited);
                    maxArea = Math.max(count,maxArea);
                }
                count=0;
            }
        }
        
        return maxArea;
    }
    
    private void  dfs(int grid[][], int i, int j,boolean[][] visited){
        int r = grid.length;
        int c = grid[0].length;
        if(i<0 || j<0 || i>=r || j>=c|| visited[i][j] || grid[i][j]==0){
            return ;
        }

        
        
        visited[i][j]=true;
        count++;
       dfs(grid,i+1,j,visited);
       dfs(grid,i-1,j,visited);
        dfs(grid,i,j-1,visited);
        dfs(grid,i,j+1,visited);
       // visited[i][j]=false; //should not be added.
        
    }
}
