 class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
           //Map<Integer, Set<Integer>> grah = new HashMap<>(); //At first, I used this which led TLE.
            List<Integer>[] grah = new LinkedList[n];
            for (int i = 0; i < n; i++) grah[i] = new LinkedList<>();
            for (List<Integer> e : connections) {
                int from = e.get(0);
                int to = e.get(1);
                grah[from].add(to);
                grah[to].add(from);
            }
            int[] low = new int[n];
            int[] dfn = new int[n];
            List<List<Integer>> res = new ArrayList<>();
            dfs(dfn, low, 0, -1, grah, res);
            return res;
        }

        int seq = 0;
        void dfs(int[] dfn, int[] low, int cur, int parent, List<Integer>[] graph, List<List<Integer>> res) {
            if (dfn[cur] > 0) return;
            dfn[cur] = ++seq;
            low[cur] = seq;
            for (int neighbour : graph[cur]) {
                if (neighbour == parent) continue;
                if (dfn[neighbour] == 0) dfs(dfn, low, neighbour, cur, graph, res);
                low[cur] = Math.min(low[cur], low[neighbour]);
            }
            if (cur != 0 && low[cur] > dfn[parent]) {
                res.add(Arrays.asList(parent, cur));
            }
        }
}
