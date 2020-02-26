class Solution {
    public int shortestBridge(int[][] A) {
        
        int r = A.length;
        int c = A[0].length;
        LinkedList<Node> queue = new LinkedList<Node>();
        boolean found = false;
                boolean[][] visited = new boolean[r][c];

        for(int i =0;i<r;i++){
            if(found) break;
            for(int j=0;j<c;j++){
                if(A[i][j]==1){
                    dfs(queue,A,i,j,visited);//exit when 1 island finished.
                    found = true;
                    break;
                }
            }
        }
        
        
        //do bfs to find the distance to the next island 
        
       int res =  bfs(queue,A,visited);
        
        return res;
    }
    
    //queue has (0,1)
    private int bfs(LinkedList<Node> queue,int[][] A,boolean visited[][] ){
        int dirs[][] = {{-1,0},{1,0},{0,1},{0,-1}};

        int r = A.length;
        int c = A[0].length;
    
        //0 1 0
        //0 0 0
        //0 0 1
        
        //iterate over the queue in level by level to find the 
        //nearest 1 i.e next island B.
        //           (0,1)    -                layer0
        //           / \  \ 
        //    (0,0)  (0,2)   (1,1)             layer1
        //                    /  \  \    \
        //             (0,1)(1,0) (1,2) (2,1)  - layer2
        //                              /
        //                            (1,1)(2,0),(2,2) -found so 2 distance (0,1) -(2,2)
         
        System.out.println(queue.size());
        int level =0;  
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++)
            {
                Node temp = queue.poll();
                int x = temp.x;
                int y = temp.y;
                for(int dir[]: dirs){
                    int x1  = x+ dir[0];
                    int y1  = y+ dir[1];
                    System.out.println("x:"+x1 +"y:"+y1);

                    if(x1<0 || y1<0||x1>=r || y1>=c ||visited[x1][y1] ){
                        continue;
                    }
                    
                    if(A[x1][y1]==1)return level;
                    visited[x1][y1]=true;
                    queue.offer(new Node(x1,y1));
                }
            }
            System.out.println("----");
            level ++;
        }
        
        return -1;
        
    }
    
    
    //dfs to check the end of first island . 
    //if no 1 found in left,right ,top, bottom then exit to indicate the island 1 completed.
    private void dfs(LinkedList<Node> queue,int[][] A, int i, int j,boolean visited[][] ){
        
        int r = A.length;
        int c = A[0].length;
        
        if(i<0 || j<0||i>=r || j>=c ||visited[i][j] || A[i][j]==0){
            return;
        }
        
        //0 1 0
        //0 0 0
        //0 0 1
        
        // top item recursion return
        //(0) [1]  (0)
        //0   (0)   0   //right,left,top,bottom return since it has zero only.
        //0    0    1
        
        // 0    1   0
        //(0)  [0] (0) 
        //0    (0)  1
        
        // 0 1  0
        //0  (0)  0
        //(0) [0] (1)
        //  since no down index exist
        
        //only (1,0) is populated since other than that 
        //dfs below is 0 no 1 in neighbor present.
        visited[i][j]=true;
        queue.offer(new Node(i,j));
        dfs(queue,A,i+1,j,visited);
        dfs(queue,A,i-1,j,visited);
        dfs(queue,A,i,j-1,visited);
        dfs(queue,A,i,j+1,visited);
    }
}


class Node{
    int x,y;
    Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}
