// This is a Java program to find the maximum profit from stock prices
// using a single transaction. The algorithm iterates through the prices    
// and calculates the maximum profit by comparing the current price with the minimum price seen so far.
// The time complexity is O(n) and the space complexity is O(1).
class Solution {
    public int maximumProfit(int prices[])
    {
    if(prices==null || prices.length==0)return 0;
    
    int mini=prices[0];
    int maxProfit=0;
    int n=prices.length;
    
    for(int i=1;i<n;i++)
    {
    int cost =prices[i]-mini;
    maxProfit=Math.max(maxProfit, cost);
    mini= Math.min(mini,prices[i]);
        
    }
    return maxProfit;
    }
}