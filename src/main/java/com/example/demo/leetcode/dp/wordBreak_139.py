class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        dp = [False for _ in range(len(s))]
        if s[0] in wordDict:
            dp[0] = True

        for i in range(1,len(s)):
            for j in range(0,i):
                if dp[j] and  s[j+1:i] in wordDict:
                    dp[i] = True
                    break

