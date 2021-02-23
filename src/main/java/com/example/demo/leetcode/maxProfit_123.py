class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxprofit = self.dpfunc(prices)
        return maxprofit


    # 其实就是 转成二维数组而已，dp[i][j]
    # i  一般对应着prices数组的index  j一般对应这状态  状态可以离散化分为5种
    def dpfunc(self,prices):
#         maxprofit = [[0 for i in range(len(prices))] for _ in range(5)]
        maxprofit = [[0 for i in range(5) ] for _ in  range(len(prices))]
        # 第一行初始化
        maxprofit[0][0] = 0
        maxprofit[0][1] = -prices[0]
        maxprofit[0][2] = 0
        maxprofit[0][3] = -prices[0]
        maxprofit[0][4] = 0

        # 每一行的数字走一遍
        for i in range(1,len(prices)):
            maxprofit[i][0] = maxprofit[i-1][0]   # 这个数组不叫dp 干脆跟跟返回数组对应好就叫 maxprofit
            maxprofit[i][1] = max(maxprofit[i-1][0] - prices[i], maxprofit[i-1][1]  ) #买入一次, 扣掉费率
            maxprofit[i][2] = max( maxprofit[i-1][1] + prices[i],maxprofit[i-1][2] )  #在第i天 卖出一次 获利
            maxprofit[i][3] = max( maxprofit[i-1][2] - prices[i],maxprofit[i-1][3]) #
            maxprofit[i][4] = max( maxprofit[i-1][3] + prices[i], maxprofit[i-1][4])

        last_index = len(prices)-1
        return max( maxprofit[last_index][0],maxprofit[last_index][1],maxprofit[last_index][2],maxprofit[last_index][3],maxprofit[last_index][4] )

