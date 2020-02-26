//Runtime: 2 ms, faster than 99.63% of Java online submissions for Max Area of Island.
//Memory Usage: 45.3 MB, less than 25.93% of Java online submissions for Max Area of Island.

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      int r = grid.length;
        int c = grid[0].length;
        
        
        boolean  visited[][] = new boolean[r][c];
        int maxArea = 0;

         for(int i =0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1  ){
                    
                   int count = dfs(grid,i,j,0);
                    maxArea = Math.max(count,maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int  dfs(int grid[][], int i, int j,int count){
        int r = grid.length;
        int c = grid[0].length;
        if(i<0 || j<0 || i>=r || j>=c|| grid[i][j]==0){
            return  count;
        }

        
        
grid[i][j]=0;
        count++;
       count= dfs(grid,i+1,j,count);
       count= dfs(grid,i-1,j,count);
        count=dfs(grid,i,j-1,count);
        count= dfs(grid,i,j+1,count);
        
        return count;
    }
}
