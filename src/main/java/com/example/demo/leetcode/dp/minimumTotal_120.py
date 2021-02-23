class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if len(triangle)==1:
            return triangle[0][0]
        if len(triangle) == 2:
            return min( triangle[1][0],triangle[1][1] )+triangle[0][0]
        # 感觉此类求最值的题目 都是dp 最好的战场
        dp = [ [0 for j in range(len(triangle[i]))] for i in range(len(triangle)) ]

        # 注意了两侧都是要初始化的
        dp[0][0] = triangle[0][0]
        for  i in range(1,len(triangle)):
            print(i,len(triangle[i])-1)
            dp[i][0] = dp[i-1][0]+ triangle[i][0]
            dp[i][len(triangle[i])-1] = dp[i-1][len(triangle[i-1])-1] + triangle[i][len(triangle[i])-1]

        print(dp)

        for i in range(2,len(triangle)):
            for j in range(1,len(triangle[i])-1):
                print(i,j)
                dp[i][j] = min(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j]

        last_layer = len(triangle)-1

        return min([ dp[last_layer][j] for j in range(len(triangle[last_layer])) ])
