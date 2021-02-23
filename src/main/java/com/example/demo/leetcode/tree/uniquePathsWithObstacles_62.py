class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        # 一般这种题目，很多bug：1 m n为1的情况  2。初始化的取之  3。低颓势 的条件
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])


        dp = [[0 for _ in range(n)] for _ in range(m)]  #因为一旦障碍物在边缘册，那么之后的位置就全是0 所以不妨改成干脆用0 初始化
        for i in range(m):  #第一列
            if  obstacleGrid[i][0] == 1: # 遇到障碍物就立即退出循环
                break
            if obstacleGrid[i][0] == 0:
                dp[i][0] = 1
        for j in range(n):
            if  obstacleGrid[0][j] == 1: # 遇到障碍物就立即退出循环
                break
            if obstacleGrid[0][j] == 0:
                dp[0][j] = 1
#         print(dp)
#         for i in range(m):  # 在外面写会被后面的覆盖掉的
#             for j in range(n):
#                 if obstacleGrid[i][j] == 1:
#                     dp[i][j] = 0


        for i in range(1,m):
            for j in range(1,n):
                if obstacleGrid[i][j] == 1:
                    dp[i][j] = 0
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]
        print(dp)
        return dp[m-1][n-1]