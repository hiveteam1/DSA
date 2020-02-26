class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
      HashMap<Integer,Set<Integer>> hsh1 = constructGraph(n,red_edges);
      HashMap<Integer,Set<Integer>> hsh2 = constructGraph(n,blue_edges);
        
      
        
        int result[] = new int[n];
    Arrays.fill(result,-1);
     bfs(hsh1,hsh2,n,result, true);
     bfs(hsh1,hsh2, n,result, false);
        
      return result;
    }
    
    
    private void bfs(HashMap<Integer,Set<Integer>> hshR, HashMap<Integer,Set<Integer>> hshB,int n,
                  int result[],boolean isBlue  )
    {
        
        boolean[] isUsedR=new boolean[n];
        boolean[] isUsedB=new boolean[n];
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        
        if(isBlue){
            isUsedR[0]=true;
        }else{
            isUsedB[0]=true;
        }
        
        
     
        
        int layer =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int x= queue.poll();
                if(result[x]==-1)result[x]=layer;
                else 
                    result[x]= Math.min(layer, result[x]);
                
                   HashMap<Integer,Set<Integer>> map = isBlue?hshB:hshR;
        boolean[] visited = isBlue?isUsedB:isUsedR;
                Set<Integer> st = map.get(x);
                if(st==null)continue;
                for(int val : st){
                                if(visited[val]) continue;

                    visited[val]=true;
                    queue.offer(val);
                }
            }
            layer++;
            isBlue = !isBlue;
        }
    }
    
    private HashMap<Integer,Set<Integer>> constructGraph(int n, int[][] red_edges){
        HashMap<Integer,Set<Integer>> hsh1  = new HashMap<>();
        for(int i =0;i<n;i++){
            hsh1.put(i,new HashSet<Integer>());
        }
        for(int edge[]:red_edges){
            hsh1.putIfAbsent(edge[0],new HashSet<Integer>());
            hsh1.get(edge[0]).add(edge[1]);
        }
        
        return hsh1;
    }
}
