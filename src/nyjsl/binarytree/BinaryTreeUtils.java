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
     * @return 是否是对称二叉树
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

    /**
     * 求二叉树的最大深度 （最大深度其实就是根节点的高度）
     * @param root 根结点
     * @return 最大深度
     * @param <T> 泛型
     */
    public static <T> int maxDepth(TreeNode<T> root) {
        if (null == root) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int mid = 1 + Math.max(leftHeight, rightHeight);
        return mid;
    }

    /**
     * 求二叉树的最小深度 （根节点到叶子节点的最小高度）
     * @param root 根节点
     * @return 最小深度
     * @param <T> 泛型
     */
    public static <T> int minDepth(TreeNode<T> root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        int mid;
        if (root.left == null) {
            mid = rightDepth+1;
        } else if (root.right == null) {
            mid = leftDepth+1;
        } else{
            mid = 1 + Math.min(leftDepth, rightDepth);
        }
        return mid;
    }

    /**
     * 普通二叉树节点数量
     * @param root 跟节点
     * @return 节点数量
     * @param <T> 泛型
     */
    public static <T> int normalTreeNodeCount(TreeNode<T> root) {
        if (null == root) {
            return 0;
        }
        int leftCount = normalTreeNodeCount(root.left);
        int rightCount = normalTreeNodeCount(root.right);
        int mid = 1 + leftCount + rightCount;
        return mid;
    }

    /**
     * 完全二叉树的节点数量
     *   如果子树是满二叉树 节点数量直接是 2^height-1
     *   否则继续遍历寻找
     * @param root 根节点
     * @return 节点数量
     * @param <T> 泛型
     */
    public static <T> int completeTreeNodeCount(TreeNode<T> root) {
        if (null == root) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (left != null) {
            leftHeight++;
            left = left.left;
        }
        while (right != null) {
            rightHeight++;
            right = right.right;
        }
        if (leftHeight ==rightHeight) {
            return (2<<leftHeight-1) -1;
        }else{
            return 1 + completeTreeNodeCount(root.left) + completeTreeNodeCount(root.right);
        }
    }


    /**
     * 是否是平衡二叉树（左右子树，高度差绝对值不大于1）
     * @param root 根节点
     * @param <T> 泛型
     */
    public static <T> boolean isBalanceTree(TreeNode<T> root){
        return balanceTreeHeight(root) != -1;
    }
    /**
     * 平衡二叉树高度
     * @param root 根节点
     * @return 平衡则返回高度，否则返回-1
     * @param <T> 泛型
     */
    private static <T> int balanceTreeHeight(TreeNode<T> root) {
        if (null == root) {
            return 0;
        }
        int leftHeight = balanceTreeHeight(root.left);
        if ( leftHeight == -1) {
            return -1;
        }
        int rightHeight = balanceTreeHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }else{
            return 1 + Math.max(leftHeight , rightHeight);
        }
    }

    /**
     * 二叉树的所有路径
     * @param root 根节点
     * @return 路径列表集合
     * @param <T> 泛型
     */
    public static <T> List<List<T>> binaryTreePaths(TreeNode<T> root) {
        List<List<T>> result = new ArrayList<>();
        if (null != root) {
            List<T> paths = new ArrayList<>();
            traversal(result, paths,root);
        }
        return result;
    }

    /**
     * 递归，回溯 遍历节点路径
     * @param result 路径列表
     * @param paths 路径
     * @param root 根节点
     * @param <T> 泛型
     */
    private static <T> void traversal(List<List<T>> result, List<T> paths,TreeNode<T> root) {
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            //注意一行，因为paths后面还会改变，所以不能直接使用paths
            result.add(new ArrayList<>(paths));
            return;
        }
        if (null != root.left) {
            traversal(result,paths,root.left);
            paths.remove(paths.size()-1);
        }
        if (null != root.right) {
            traversal(result,paths,root.right);
            paths.remove(paths.size()-1);
        }

    }

    /**
     * 二叉树的所有左叶子节点之合
     *
     * @return 所有左叶子节点之合
     */
    public static Integer sumOfLeftChildren(TreeNode<Integer> root) {
        if (null == root) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        Integer leftSum = sumOfLeftChildren(root.left);
        if (null != root.left && root.left.left == null && root.left.right == null) {
            leftSum = root.left.val;
        }
        Integer rightSum = sumOfLeftChildren(root.right);
        Integer sum = leftSum+rightSum;
        return sum;
    }


}
