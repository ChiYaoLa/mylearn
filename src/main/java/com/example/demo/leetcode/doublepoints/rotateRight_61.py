# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        # 对于这种k-steps 类型的链表，往往需要引入 dummynode

        if not head:
            return None
        if not head.next:
            return head

        count = head
        count_len = 0
        while count:
            count = count.next
            count_len = count_len+1

        clean_k = k%count_len


        slow = head
        fast = head
        for i in range(clean_k):
            fast = fast.next

        while fast.next:   #fast.next这样更好理解
            fast = fast.next
            slow = slow.next

        # slow.next 就是分割的节点
        fast.next = head
        res = slow.next
        slow.next = None

        return res


