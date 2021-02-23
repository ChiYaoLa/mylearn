# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not  head or not head.next:  #
            return False

        fast = head.next
        slow = head
        while fast != slow:
            if not fast or not fast.next: #这个条件关注了 不是not slow 而都是 跟fast相关，因为跑的快
                return False
            fast = fast.next.next
            slow = slow.next

        return True
