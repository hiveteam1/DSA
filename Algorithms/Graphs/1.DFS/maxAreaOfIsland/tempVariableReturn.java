//Runtime: 2 ms, faster than 99.63% of Java online submissions for Max Area of Island.
//Memory Usage: 38.8 MB, less than 96.30% of Java online submissions for Max Area of Island.

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      int r = grid.length;
        int c = grid[0].length;
        
        
        boolean  visited[][] = new boolean[r][c];
        int maxArea = 0;

         for(int i =0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1 ){
                   int count = dfs(grid,i,j,0,visited);
                    maxArea = Math.max(count,maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int  dfs(int grid[][], int i, int j,int count,boolean[][] visited){
        int r = grid.length;
        int c = grid[0].length;
        if(i<0 || j<0 || i>=r || j>=c|| visited[i][j] || grid[i][j]==0){
            return  count;
        }

        
        
        //count1 for return down and count for base case return.
        int count1 = count;
        visited[i][j]=true;
        count1++;
       count1+=dfs(grid,i+1,j,count,visited);
       count1+=dfs(grid,i-1,j,count,visited);
        count1+=dfs(grid,i,j-1,count,visited);
        count1+=dfs(grid,i,j+1,count,visited);
       // visited[i][j]=false; //should not be added.
        
        return count1;
    }
}
