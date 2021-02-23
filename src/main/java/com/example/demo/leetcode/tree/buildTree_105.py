class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        # 如果preorder pop开头的元素，而inorder元素
        if len(inorder) == 0: # 采用inorder 而不是preorder 是有原因的
            return None

        pos = inorder.index(preorder[0])
        root = TreeNode(preorder[0])


        left = self.buildTree(preorder[1:pos+1],inorder[:pos])  # 难点就是这里的坐标范围 容易搞错
        right = self.buildTree(preorder[pos+1:],inorder[pos+1:])
        root.left = left
        root.right = right

        return root


