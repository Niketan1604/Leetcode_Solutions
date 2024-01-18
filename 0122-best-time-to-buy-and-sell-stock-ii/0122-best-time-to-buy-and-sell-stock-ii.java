class Solution {
    public int maxProfit(int[] prices) {
        // if(prices.length == 0) return 0;
        // int buy = 0;
        // int profit = 0;
        // while(buy < prices.length - 1){
        //     boolean flag = false;
        //     for(int i=buy+1; i<prices.length; i++){
        //         if(prices[i]<prices[i-1] && prices[i-1]>prices[buy]){
        //             profit += prices[i-1] - prices[buy];
        //             buy = i;
        //             flag = true;
        //             break;
        //         }
        //         if(prices[i] < prices[buy]){
        //             buy = i;
        //             flag = true;
        //             break;
        //         }
        //         if(i==prices.length - 1 && prices[i]>prices[buy]){ //last day
        //             profit += prices[i] - prices[buy];
        //             buy = i;
        //         }
        //     }
        //     if(!flag) buy++;
            
        // }
        // return profit;



        int sum=0;
        int n=prices.length;
        for(int i=1;i<n;i++){
            if(prices[i]>prices[i-1]){
                sum+=prices[i]-prices[i-1];
            }
        }
        return sum;
    }
}