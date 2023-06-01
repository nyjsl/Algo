package nyjsl.linkedlist;


public class ListNodeUtils {
    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (null != cur) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public static ListNode reverseR(ListNode head) {
        ListNode pre  = null;
        return R(pre, head);
    }

    public static ListNode R(ListNode pre, ListNode cur) {
        if (null == cur) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        return R(cur,temp);
    }

    /**
     * 两两交换链表
     * @param head
     * @return
     */
    public static ListNode swapPair(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next;
            ListNode nextThird = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = next;
            next.next = nextThird;
            cur = cur.next.next;
        }
        return dummyHead.next;
    }

    /**
     * 删除链表的倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode deleteCoutBackN(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = dummyHead;

        for (int i = 0; i < n; i++) {
            if (null != fast) {
                fast = fast.next;
            }
        }

        ListNode slow = dummyHead;
        while (fast.next!= null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }


    public static void print(ListNode head) {
        while (null != head) {
            System.out.printf(head.data+"");
            head = head.next;
        }
    }

}
