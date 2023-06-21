package nyjsl.binarytree;



import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class BinaryTreeUtils {


    /**
     * 递归前序遍历,遍历结果放入List中
     * @param result 前序遍历后的结束列表
     * @param root 根结点
     * @param <T> 类型
     */
    public static <T> void preOrderRecursion(List<T> result, TreeNode<T> root){
        if (null == root) {
            return;
        }
        result.add(root.val);
        preOrderRecursion(result,root.left);
        preOrderRecursion(result,root.right);
    }

    /**
     * 递归中序遍历,遍历结果放入List中
     * @param result 中序遍历后的结束列表
     * @param root 根结点
     * @param <T> 类型
     */
    public static <T> void inOrderRecursion(List<T> result, TreeNode<T> root){
        if (null == root) {
            return;
        }
        inOrderRecursion(result,root.left);
        result.add(root.val);
        inOrderRecursion(result,root.right);
    }
    /**
     * 递归后续遍历,遍历结果放入List中
     * @param result 后续遍历后的结束列表
     * @param root 根结点
     * @param <T> 类型
     */
    public static <T> void afterOrderRecursion(List<T> result, TreeNode<T> root){
        if (null == root) {
            return;
        }
        afterOrderRecursion(result,root.left);
        afterOrderRecursion(result,root.right);
        result.add(root.val);
    }

    /**
     * 前序遍历 (栈模拟)
     * @param result 遍历结果
     * @param root 根结点
     * @param <T> 泛型
     */
    public static  <T> void preOrderTraversal(List<T> result, TreeNode<T> root){
        if (null == root) {
            return;
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> pop = stack.pop();
            result.add(pop.val);
            if (null != pop.right) {
                stack.add(pop.right);
            }
            if (null != pop.left) {
                stack.add(pop.left);
            }
        }
    }

    /**
     * 后续遍历, 前序遍历 更改左右入栈顺序,然后翻转
     * @param result 遍历结果
     * @param root 根结点
     * @param <T> 泛型
     */
    public static <T> void afterOrderTraversal(List<T> result, TreeNode<T> root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> pop = stack.pop();
            result.add(pop.val);
            if (null != pop.left) {
                stack.push(pop.left);
            }
            if (null != pop.right) {
                stack.push(pop.right);
            }
        }
        Collections.reverse(result);
    }
}
