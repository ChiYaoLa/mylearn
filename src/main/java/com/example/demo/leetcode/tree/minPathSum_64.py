class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m = len(grid)
        n = len(grid[0])


        dp = [ [0 for _ in range(n)] for _ in range(m) ] # m在外面！！！
        dp[0][0] = grid[0][0]
        for i in range(1,m):
            dp[i][0] = dp[i-1][0] + grid[i][0]
        for j in range(1,n):
            dp[0][j] = dp[0][j-1] + grid[0][j]
        print(dp)

        for i in range(1,m): # 起点是1 到 m，别写错了
            for j in range(1,n):
                dp[i][j] = min(dp[i-1][j] , dp[i][j-1])+grid[i][j]
        print(dp)
        return dp[m-1][n-1]