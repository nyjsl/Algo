package nyjsl.binarytree;




import java.util.*;

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

    /**
     * 中序  入栈顺序左右
     * * @param result 遍历结果
     * @param root 根结点
     * @param <T> 泛型
     */
    public static <T> void inOrderTraversal(List<T> result, TreeNode<T> root) {
        if (null == root) {
            return;
        }
        TreeNode<T> cur = root;
        Stack<TreeNode<T>> stack = new Stack<>();
        while (null != cur || !stack.isEmpty()) {
            if (null != cur) {
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
    }

    /**
     * 翻转二叉树
     * @param root 源二叉树
     * @return 结果
     * @param <T> 泛型
     */
    public static <T> TreeNode<T> invertTree(TreeNode<T> root) {
        if (null == root) {
            return root;
        }
        TreeNode<T> temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 迭代法翻转二叉树  DFS
     * @param root 源二叉树
     * @return 结果二叉树
     * @param <T> 泛型
     */
    public static <T> TreeNode<T> invertTreeTraversal(TreeNode<T> root) {
        if (null == root) {
            return root;
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> cur = stack.pop();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (null != cur.right) {
                stack.push(cur.right);
            }
            if (null != cur.left) {
                stack.push(cur.left);
            }
        }
        return root;
    }

    /**
     * 层次遍历翻转二叉树 BFS
     * @param root 源
     * @return 结果
     * @param <T> 泛型
     */
    public static <T> TreeNode<T> invertTreeLevel(TreeNode<T> root) {
        if (null == root) {
            return root;
        }
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (null != cur.right) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }

    /**
     * 是否是对称二叉树
     * @param root
     * @return
     * @param <T>
     */
    public static <T> boolean isSymthic(TreeNode<T> root) {
        if (null == root) {
            return true;
        }
        return compare(root.left, root.right);
    }


    private static <T> boolean compare(TreeNode<T> left, TreeNode<T> right) {
        if (null == left && right == null) {
            return true;
        }
        if (null == left && right != null) {
            return false;
        }
        if (null == right && left != null) {
            return false;
        }
        boolean outSide = compare(left.left, right.right);
        boolean inSide = compare(left.right, right.left);
        boolean middle = outSide && inSide;
        return middle;

    }



}
