# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        if not head.next:
            return None

        res = head
        fast = head
        slow = head
        count = n+1
        while count != 0:
            fast = fast.next
            count = count-1

        while not fast:
            head = head.next
            slow = slow.next
            fast = fast.next

        slow.next = head.next.next

        return res