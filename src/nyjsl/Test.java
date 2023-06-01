package nyjsl;

import nyjsl.linkedlist.ListNode;
import nyjsl.linkedlist.ListNodeUtils;
import nyjsl.linkedlist.MLinkedList;

public class Test {

    public static void main(String[] args) {
//        testMLinkedList();
//        testReverse();
//        testSwapPair();
        ListNode a = new ListNode("a");
        a.next = new ListNode("b");
        a.next.next = new ListNode("c");
        a.next.next.next = new ListNode("d");
        a.next.next.next.next = new ListNode("e");
        a.next.next.next.next.next = new ListNode("f");
        ListNodeUtils.print(ListNodeUtils.deleteCoutBackN(a,4));
    }

    private static void testSwapPair() {
        ListNode a = new ListNode("a");
        a.next = new ListNode("b");
        a.next.next = new ListNode("c");
        a.next.next.next = new ListNode("d");
        a.next.next.next.next = new ListNode("e");
        a.next.next.next.next.next = new ListNode("f");
        ListNodeUtils.print(ListNodeUtils.swapPair(a));
    }

    private static void testReverse() {
        ListNode a = new ListNode("a");
        a.next = new ListNode("b");
        a.next.next = new ListNode("c");
        ListNodeUtils.print(a);
        ListNodeUtils.print(ListNodeUtils.reverse(a));
        ListNodeUtils.print(ListNodeUtils.reverseR(a));
    }

    private static void testMLinkedList() {
        MLinkedList mLinkedList = new MLinkedList();
        mLinkedList.addAtHead(1);
        mLinkedList.addAtHead(2);
        mLinkedList.addAtHead(3);
        mLinkedList.addAtTail(4);
        mLinkedList.addAtTail(5);
        mLinkedList.addAtTail(6);
        mLinkedList.addAtIndex(0,0);
        mLinkedList.addAtIndex(-1,-1);
        mLinkedList.addAtIndex(mLinkedList.getSize(),7);
        mLinkedList.print();
        mLinkedList.deleteAtIndex(mLinkedList.getSize());
        mLinkedList.print();
        mLinkedList.deleteAtIndex(mLinkedList.getSize()-1);
        mLinkedList.print();
        mLinkedList.deleteAtIndex(-1);
        mLinkedList.deleteAtIndex(0);
        mLinkedList.print();
        mLinkedList.deleteAtIndex(1);
        mLinkedList.print();
    }
}
