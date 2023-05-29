package nyjsl;

import nyjsl.linkedlist.MLinkedList;

public class Test {

    public static void main(String[] args) {
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
    }
}
