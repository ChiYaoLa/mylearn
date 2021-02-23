# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        # 其实就是 再用两个指针关系，衍生出 两条链
        large = ListNode(0)
        largehead = large
        small = ListNode(0)
        smallhead = small

        while not head:
            if head.val > x:
                large.next = head
                large = large.next
            else:
                small.next = head
                small = small.next

            head = head.next

        large.next = smallhead.next
        return large.next