# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        return self.build(nums,0,len(nums))


    def build(self,nums,left,right):
        if left>=right: # 几乎所有带了双指针的入参，都是这么个 判断条件
            return None

        mid = (left+right)//2
        root = TreeNode(nums[mid])

        root.left = self.build(nums,left,mid)   # 感觉所有的这种树的生成的题目都是一个鸟样的模版
        root.right = self.build(nums,mid+1,right)

        return root