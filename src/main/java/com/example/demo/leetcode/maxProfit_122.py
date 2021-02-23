class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxdp = [[0 for i in range(2)] for _ in range(len(prices))]
        maxdp[0][0] = -prices[0]
        maxdp[0][1] = 0

        for i in range(1,len(prices)):
            maxdp[i][0] = max( maxdp[i-1][0], maxdp[i-1][1]-prices[i])  # dp[i][0]  表示持有
            maxdp[i][1] = max( maxdp[i-1][1] ,maxdp[i-1][0]+prices[i] ) # dp[i][1] 表示卖出
        last_index = len(prices)-1
        return max( maxdp[last_index][0],maxdp[last_index][1])