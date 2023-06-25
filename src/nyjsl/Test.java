package nyjsl;

import nyjsl.binarytree.BinaryTreeUtils;
import nyjsl.binarytree.TreeNode;
import nyjsl.hashtable.HappyNum;
import nyjsl.hashtable.IsAnagram;
import nyjsl.hashtable.TwoSum;
import nyjsl.linkedlist.ListNode;
import nyjsl.linkedlist.ListNodeUtils;
import nyjsl.linkedlist.MLinkedList;
import nyjsl.str.StrUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        testMLinkedList();
//        testReverse();
//        testSwapPair();
//        testDelectBack();
//        testDetectCycle();
//        testAnagram();
//        testHappyNo();
//        testTwoSum();
//        testReverseStr();
//        testReverse2k();
//        System.out.println(StrUtils.replaceSpace("We are happy."));

//        testTreeTraversalRecursion();
//        testTreeTraversal();
//        testInvertTree();
//        testSythemmic();
//        testTreeDepth();
//        testTreeOpthions();
//        testTreePaths();
//        System.out.println(BinaryTreeUtils.sumOfLeftChildren(buildTestTreeInt()));
//        System.out.println(BinaryTreeUtils.bottomLeft(buildTestTree()));
//        System.out.println(BinaryTreeUtils.hasSum(buildTestTreeInt(),11));
//        System.out.println(BinaryTreeUtils.hasSum(buildTestTreeInt(),8));
        TreeNode<String> root = buildTestTree();
        ArrayList<String> inOrder = new ArrayList<>();
        BinaryTreeUtils.inOrderTraversal(inOrder,root);
        ArrayList<String> postOrder = new ArrayList<>();
        BinaryTreeUtils.afterOrderRecursion(postOrder,root);
        TreeNode<String> result = BinaryTreeUtils.buildFrom(inOrder,postOrder);
        ArrayList<String> res = new ArrayList<>();
        BinaryTreeUtils.preOrderRecursion(res,result);
        System.out.println(res);

    }

    private static void testTreePaths() {
        List<List<String>> paths = BinaryTreeUtils.binaryTreePaths(buildTestTree());
        CommonUtils.printList(paths);
    }

    private static void testTreeOpthions() {
        System.out.println(BinaryTreeUtils.normalTreeNodeCount(buildTestTree()));
        System.out.println(BinaryTreeUtils.completeTreeNodeCount(buildSythmeicTree()));
        System.out.println(BinaryTreeUtils.isBalanceTree(buildTestTree()));
    }

    private static void testTreeDepth() {
        System.out.println(BinaryTreeUtils.maxDepth(buildTestTree()));
        System.out.println(BinaryTreeUtils.minDepth(buildTestTree()));
    }

    private static void testSythemmic() {
        System.out.println(BinaryTreeUtils.isSymthic(buildTestTree()));
        System.out.println(BinaryTreeUtils.isSymthic(buildSythmeicTree()));
    }

    private static void testInvertTree() {
        TreeNode<String> root = buildTestTree();
        root = BinaryTreeUtils.invertTree(root);
        ArrayList result = new ArrayList();
        BinaryTreeUtils.preOrderTraversal(result,root);
        CommonUtils.printList(result);
        result.clear();
        System.out.println();
        root = BinaryTreeUtils.invertTreeTraversal(root);
        BinaryTreeUtils.preOrderTraversal(result,root);
        CommonUtils.printList(result);
        result.clear();
        System.out.println();
        root = BinaryTreeUtils.invertTreeLevel(root);
        BinaryTreeUtils.preOrderTraversal(result,root);
        CommonUtils.printList(result);
    }

    private static void testTreeTraversal() {
        TreeNode<String> root = buildTestTree();
        ArrayList result = new ArrayList();
        BinaryTreeUtils.preOrderTraversal(result,root);
        CommonUtils.printList(result);
        result.clear();
        System.out.println();
        BinaryTreeUtils.afterOrderTraversal(result,root);
        CommonUtils.printList(result);
        result.clear();
        System.out.println();
        BinaryTreeUtils.inOrderTraversal(result,root);
        CommonUtils.printList(result);
        result.clear();
        System.out.println();
    }

    /**
     * 测试使用递归方法进行二叉树的遍历
     */
    private static void testTreeTraversalRecursion() {
        TreeNode<String> root = buildTestTree();
        ArrayList result = new ArrayList();
        BinaryTreeUtils.preOrderRecursion(result,root);
        CommonUtils.printList(result);
        result.clear();
        System.out.println();
        BinaryTreeUtils.inOrderRecursion(result,root);
        CommonUtils.printList(result);
        result.clear();
        System.out.println();
        BinaryTreeUtils.afterOrderRecursion(result,root);
        CommonUtils.printList(result);
        result.clear();
        System.out.println();
    }

    /**
     *                       A
     *                 B          C
     *             E      F          D
     *                  G
     *          前序遍历结果    A   B  E  F  G  C  D
     *          中序遍历结果    E   B  G  F  A  C  D
     *          后序遍历结果    E   G  F  B  D  C  A
     *          层次遍历结果
     *                      [A],
     *                      [B, C],
     *                      [E, F, D],
     *                      [G],
     *
     * @return
     */
    private static TreeNode<String> buildTestTree() {
        TreeNode<String> a = new TreeNode<>("A");
        TreeNode<String> b = new TreeNode<>("B");
        TreeNode<String> c = new TreeNode<>("C");
        TreeNode<String> d = new TreeNode<>("D");
        TreeNode<String> e = new TreeNode<>("E");
        TreeNode<String> f = new TreeNode<>("F");
        TreeNode<String> g = new TreeNode<>("G");
        f.left = g;
        b.left = e;
        b.right = f;
        c.right =d;
        a.left = b;
        a.right = c;
        return a;
    }
    /**
     *                       1
     *                 2          3
     *             5      6          4
     *                  7
     *
     * @return
     */
    private static TreeNode<Integer> buildTestTreeInt() {
        TreeNode<Integer> a = new TreeNode<>(1);
        TreeNode<Integer> b = new TreeNode<>(2);
        TreeNode<Integer> c = new TreeNode<>(3);
        TreeNode<Integer> d = new TreeNode<>(4);
        TreeNode<Integer> e = new TreeNode<>(5);
        TreeNode<Integer> f = new TreeNode<>(6);
        TreeNode<Integer> g = new TreeNode<>(7);
        f.left = g;
        b.left = e;
        b.right = f;
        c.right =d;
        a.left = b;
        a.right = c;
        return a;
    }

    /**
     * 构建一颗对称二叉树
     *                  A
     *              B       B
     *            D    C  C    D
     * @return
     */
    private static TreeNode<String> buildSythmeicTree() {
        TreeNode<String> a = new TreeNode<>("A");
        TreeNode<String> b1 = new TreeNode<>("B");
        TreeNode<String> b2 = new TreeNode<>("B");
        TreeNode<String> d1 = new TreeNode<>("D");
        TreeNode<String> c1 = new TreeNode<>("C");
        TreeNode<String> c2 = new TreeNode<>("C");
        TreeNode<String> d2 = new TreeNode<>("D");
        b1.left = d1;
        b1.right = c1;
        b2.left = c2;
        b2.right =d2;
        a.left = b1;
        a.right = b2;
        return a;
    }

    private static void testReverse2k() {
        String src = new String("abcdefg");
        System.out.println(StrUtils.reverse2K(src,2));
    }

    private static void testReverseStr() {
        char[] h = new char[]{'h','e','l','l','o'};
        StrUtils.reverse(h);
        for (int i = 0; i < h.length; i++) {
            System.out.println(h[i]);
        }
    }

    private static void testTwoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] x = TwoSum.twoSum(nums, target);
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }

    private static void testHappyNo() {
        System.out.println(HappyNum.isHappyNo(18));
        System.out.println(HappyNum.isHappyNo(19));
    }

    private static void testAnagram() {
        System.out.println(IsAnagram.isAnagram("abc", "bca"));
        System.out.println(IsAnagram.isAnagram("abc", "abc"));
        System.out.println(IsAnagram.isAnagram("abc", "abca"));
    }

    private static void testDetectCycle() {
        ListNode a = new ListNode("a");
        ListNode b = new ListNode("b");
        ListNode c = new ListNode("c");
        ListNode d = new ListNode("d");
        ListNode e = new ListNode("e");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = b;
        ListNodeUtils.print(ListNodeUtils.detectCycle(a));
    }

    private static void testDelectBack() {
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
