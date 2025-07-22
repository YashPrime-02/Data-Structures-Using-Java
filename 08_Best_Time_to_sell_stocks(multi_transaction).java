// This is a Java solution for the problem of calculating the maximum profit from multiple stock transactions.
// The solution iterates through the stock prices and sums up the profit from every upward price movement
// to maximize the total profit. This approach allows for multiple transactions, buying and selling on every increase.
// The time complexity is O(n) and the space complexity is O(1).    
class Solution {
    public int maximumProfit(int prices[]) {
        if(prices== null || prices.length==0) return 0;
    
    int maxProfit=0;
    
    for(int i=1;i<prices.length;i++)
    {
    if(prices[i]>prices[i-1]) 
    {
    maxProfit+= prices[i]-prices[i-1];    
    }
    }
    return maxProfit;    
        
    }
}