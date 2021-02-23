class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxdp = [[0 for i in range(3)] for _ in range(len(prices))]
        # 分成三种状态 0 1 2 对应着 持有  卖出  冻结 三种状态
        maxdp[0][0] = -prices[0]
        maxdp[0][1] = 0
        maxdp[0][2] = 0


        for i in range(1,len(prices)):
            maxdp[i][0] = max( maxdp[i-1][0] ,maxdp[i-1][1]-prices[i] )
            maxdp[i][1] = max( maxdp[i-1][1] ,maxdp[i-1][0]+prices[i] )
            maxdp[i][2] = max( maxdp[i-1][2] ,maxdp[i-1][1] )

        last_index = len(prices)-1
        return max( maxdp[last_index][0],maxdp[last_index][1] ,maxdp[last_index][2])
