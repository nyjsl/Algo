package nyjsl.linkedlist;

public class MLinkedList<T> {

    private int size;

    public int getSize() {
        return size;
    }

    private ListNode<T> dummyHead;

    public MLinkedList() {
        this.size = 0;
        dummyHead = new ListNode<>(null);
    }

    /**
     * 获取链表第index个节点的元素的值
     * @param index 索引
     * @return ListNode 或者null;
     */
    public T getValAt(int index) {
        ListNode<T> tListNode = get(index);
        return tListNode == null ? null: tListNode.data;
    }

    /**
     * 获取链表第index个节点的元素
     * @param index 索引
     * @return ListNode 或者null;
     */
    public ListNode<T> get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ListNode<T> cur = dummyHead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * @param val
     */
    public void addAtHead(T val) {
        ListNode<T> newHead = new ListNode<>(val);
        ListNode oldHead = dummyHead.next;
        newHead.next = oldHead;
        dummyHead.next = newHead;
        size++;
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素
     * @param val
     */
    public void addAtTail(T val) {
        ListNode<T> newTail = new ListNode<>(val);
        ListNode<T> oldTail = get(size - 1);
        if (null != oldTail) {
            oldTail.next = newTail;
        }else{
            dummyHead.next = newTail;
        }
        size++;
    }

    /**
     * 在链表中的第 index 个节点之前添加值为 val  的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * @param index
     * @param val
     */
    public void addAtIndex(int index,T val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = cur.next;
        pre.next = next;
        size--;
    }

    public void print() {
        ListNode cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            System.out.println(cur.data);
        }
    }



}
