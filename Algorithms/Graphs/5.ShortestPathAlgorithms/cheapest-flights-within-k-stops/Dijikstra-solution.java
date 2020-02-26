class Solution {

    //Runtime: 14 ms, faster than 61.00% of Java online submissions for Cheapest Flights Within K Stops.
    //Memory Usage: 38.8 MB, less than 74.07% of Java online submissions for Cheapest Flights Within K Stops.

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int len = flights.length;
        Map<Integer,Map<Integer,Integer>> adjMap = new HashMap<>();
         for(int i=0;i<len;i++){
             adjMap.put(flights[i][0],new HashMap<>());
        }
        //[[0,1,100],[1,2,100],[0,2,500]]
        // city1 - city2 (cost)
        //src = 0, dst = 2, k = 1
        for(int flight[]: flights){
            int city1 = flight[0];
            int city2 = flight[1];
            int cost = flight[2];
            adjMap.get(city1).put(city2,cost);

        }
        
       PriorityQueue<Node> pq = new PriorityQueue<Node>(n/2, new Comparator<Node>(){
          public int compare(Node node1, Node node2){
              return node1.cost - node2.cost;
          } 
       });
        
        //since from 0-1 and 1-2 considered as 1 i.e since first boarding city will not be considered
        pq.offer(new Node(0,src,K+1));
        
        HashSet<Integer> visited= new HashSet<Integer>();
        while(!pq.isEmpty())
        {
            Node node = pq.poll();
            int dest = node.dest;
            int cost = node.cost;
            int stops = node.stops;
            
            if(dest == dst) return cost;
            Map<Integer,Integer> map = adjMap.get(dest);
           
            if(map ==null)continue;
            //since stops limitation given.
            if(stops >0){
                for(int city : map.keySet()){
                    pq.offer(new Node(cost+ map.get(city) , city, stops-1));
                }
            }
            
       }
        return -1;
    }
    
    class Node{
        int dest;
        int cost;
        int stops;
        Node(int cost, int dest,int stops){
            this.dest = dest;
            this.cost = cost;
            this.stops = stops;
        }
        
    }
}
