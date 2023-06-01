package nyjsl.linkedlist;


/**
 * 单表数据结构
 * @param <T> 存储数据泛型
 */
public class ListNode<T> {

    T data;
     public ListNode<T> next;



    public ListNode(T data) {
        this.data = data;
    }
}
