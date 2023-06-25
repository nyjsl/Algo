package nyjsl.binarytree;

/**
 * 二叉树的种类:
 *  满二叉树,如果一颗二叉树只有度和0的结点和度为2的结点,并且度为0 的结点在同一层上,则这颗二叉树为满二叉树
 *
 *  完全二叉树,除了最底层结点可能未填满外,其余每层结点数都达到最大值,并且最下面一层结点都集中在该层最左边的若干位置
 *
 *  二叉搜索树,二叉搜索树是一个有序树,
 *      若它的左子树不为空,则左子树的所有结点的值均小于它的根结点的值
 *      若它的右子树不为空,则右子树上的所有结点的值均大于它的根结点的值
 *
 *  平衡二叉搜索树(AVL树)
 *      一颗空树或它的左右两个子树的高度差的绝对值不超过1,并且左右两个子树都是一颗平衡二叉树
 *
 *
 *   二叉树可以链式存储,也可以顺序存储(如果父节点的数组下标为i,则它的左孩子就是i*2+1,右孩子就是i*2+2)
 *
 *   二叉树的遍历方式
 *      二叉树主要有两种遍历方式,
 *          深度优先遍历 ,先往深走,遇到叶子结点再返回
 *              前序遍历
 *              中序遍历
 *              后序遍历
 *          广度优先遍历 ,一层一层的去遍历
 *              层次遍历
 */
public class TreeNode<T> {

    public T val;

    public TreeNode<T> left;

    public TreeNode<T> right;


    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
