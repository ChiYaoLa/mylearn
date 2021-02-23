class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # 一个很奇怪的思路，聚焦于 sum 是否要加到 当前的数字nums[i] 上
        # 如果sum>0 可以加到当前nums
        sum = 0
        res = nums[0]
        for i in range(len(nums)):
            if( sum>0 ):
                sum = sum + nums[i]
            else:
                sum = nums[i]
            res = max(sum,res)
        return res




