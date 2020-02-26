

Temp variable Returns improve speed
====================================

      private int  dfs(int grid[][], int i, int j,int count,boolean[][] visited){
              int r = grid.length;
              int c = grid[0].length;
              if(i<0 || j<0 || i>=r || j>=c|| visited[i][j] || grid[i][j]==0){
                  return  count;
              }



              //count1 for return down and count for base case return.
              visited[i][j]=true;
              count++;
             count=dfs(grid,i+1,j,count,visited);
             count=dfs(grid,i-1,j,count,visited);
              count=dfs(grid,i,j-1,count,visited);
              count=dfs(grid,i,j+1,count,visited);
             // visited[i][j]=false; //should not be added.

              return count;
          }
    
    
    
Temporary variable do to return function returns and use param to return base class:
====================================================================================

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
