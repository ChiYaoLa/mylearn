class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxprofit = 0
        for i in range(len(prices)):
            profit = self.dp(prices[:i]) + self.dp(prices[i:])
            if profit>maxprofit:
                maxprofit = profit
        return maxprofit

    def dp(self,prices):
        minprice = 633333333
        maxprofit = 0
        for i in range(len(prices)):
            if prices[i] < minprice:
                minprice = prices[i]
            if  prices[i] - minprice > maxprofit:
                maxprofit = prices[i] - minprice
        return maxprofit
