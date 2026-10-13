// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        int n = prices.size();

        // get max value from back
        // maxFromBack[i]: max value from prices[i]~prices[n-1]
        vector<int> maxFromBack(n, 0);

        maxFromBack[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; --i)
        {
            if (prices[i] > maxFromBack[i + 1])
            {
                maxFromBack[i] = prices[i];
            }
            else
            {
                maxFromBack[i] = maxFromBack[i + 1];
            }
        }

        // calculate max profit
        int maxProfit = 0;
        for (int i = 0; i <= n - 2; ++i)
        {
            int buy = prices[i];
            int maxSell = maxFromBack[i + 1];
            if (buy < maxSell)
            {
                maxProfit = max(maxProfit, maxSell - buy);
            }
        }
        return maxProfit;
    }
};