class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # 双指针交换问题,再引入一个指针i
        i = 0
        left,right = 0,len(nums)-1

        # nums[i] 的只可能是0 1 2中一个可能，如果是1，那就直接+1 contine
        while i<=right:
            while i<=right and  nums[i]==2:  # 可能替换完之后， nums[i]还是2，此时末尾是2 满足要求，我们希望nums[i] 应当是0 1 这两种情况
                nums[i],nums[right] = nums[right],nums[i]
                right = right-1
            if nums[i] == 0: # 上面while处理完，ums[i] 是0 1 这两种情况,因为i从左到右开始的，所以当排除掉2之后，绝对只可能是 0 1
                nums[i],nums[left] = nums[left],nums[i]
                left = left+1
            i = i+1

