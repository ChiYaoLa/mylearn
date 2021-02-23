class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        m = len(word1)
        n = len(word2)

        # 如果又一个空串
        if m*n == 0:
            return m+n  #很精炼，本来要写2个if

        # 把空串当成边界情况 是我没想到，一下子简洁了
        dp = [  [ 0 for _ in range(n+1)] for _ in range(m+1)]
        for i in range(m+1):
            dp[i][0] = i
        for j in range(n+1):
            dp[0][j] = j

        # word1[:i] word2[:j] 的编辑距离的问题，看最后一个字符的情况分类讨论
        for i in range(1,m+1):
            for j in range(1,n+1):
                if word1[i-1] == word2[j-1]:  # dp 矩阵的i j 需要跟字符串的i j 的index含义统一，所以i-1 j-1
                    dp[i][j] = min( dp[i-1][j-1] ,dp[i-1][j]+1 ,dp[i][j-1]+1)
                if word1[i-1] != word2[j-1]:
                    dp[i][j] = min( dp[i-1][j-1]+1 , dp[i-1][j]+1 ,dp[i][j-1]+1)
        print(dp)
        return dp[m][n]
