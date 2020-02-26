    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
    
    
    //Anonther solution.
    
    
    class Solution {
    public int maxProfit(int[] prices) {
               int n = prices.length;

        //7 1 5 3 6 4
        if(prices==null || n==0) return 0;
        int max =0;
        int prev =prices[0];
        int curmax=0;
        for(int i=1;i<n;i++){
            curmax+= prices[i]-prices[i-1];
            if(curmax<0) //less than zero reset to zero.
             curmax= 0;
            max= Math.max(curmax,max);
        }
        
        return max;
    }
}
