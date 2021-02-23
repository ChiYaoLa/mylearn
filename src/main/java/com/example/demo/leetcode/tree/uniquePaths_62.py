class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if m==1 or n==1:
            return 1
#         dp = [ [1 for _ in range(m)] for _ in range(n)] # 老给写反了
        dp = [ [1 for _ in range(n)] for _ in range(m)] # 1做初始值，因为边缘两侧确实都是1 条路径

        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]

        return dp[m-1][n-1]