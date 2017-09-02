package collectionEasyFirstHundred;

import collectionUtils.TreeNode;

import java.util.*;

/**
 * Created by Amos on 2017/9/2.
 * Lowest Common Ancestor of a Binary Search Tree
 */
public class Sol235 {
    // Idea(new):   Use parent Map && Parent Matching
    public TreeNode lowestCommonAncestorViaMap(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
            return null;
        }

        Map<TreeNode, TreeNode> parents = new HashMap<>();
        generateParents(root, parents);

        List<TreeNode> ansP = new LinkedList<>();
        TreeNode cur = p;
        ansP.add(cur);
        while(parents.containsKey(cur)) {
            cur = parents.get(cur);
            ansP.add(0, cur);
        }

        List<TreeNode> ansQ = new LinkedList<>();
        cur = q;
        ansQ.add(cur);
        while(parents.containsKey(cur)) {
            cur = parents.get(cur);
            ansQ.add(0, cur);
        }

        Iterator<TreeNode> itP = ansP.iterator();
        Iterator<TreeNode> itQ = ansQ.iterator();

        TreeNode result = null;

        while(itP.hasNext() && itQ.hasNext()) {
            TreeNode sp = itP.next();
            TreeNode sq = itQ.next();
            if(sp == sq) {
                result = sp;
            } else {
                return result;
            }
        }
        return result;

    }

    private void generateParents(TreeNode root, Map<TreeNode, TreeNode> parents) {
        if(root == null) {  return; }
        if(root.left != null) {
            parents.put(root.left, root);
            generateParents(root.left, parents);
        }
        if(root.right != null) {
            parents.put(root.right, root);
            generateParents(root.right, parents);
        }
    }

    // Idea: Use Recursive Calls
    // Much like post-order visit, but require a little bit more thinking
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // p && q are global variables, if encountered just return them, otherwise, use recursively find LCA
        // Meanwhile, if one path with no p or q occurred, it will finally return 'null'
        if(root == null || p == null || q == null){
            return null;
        }
        if(root == p || root == q) {
            return root;
        }

        // post-visiting
        TreeNode LCA_left = lowestCommonAncestor(root.left, p, q);
        TreeNode LCA_right = lowestCommonAncestor(root.right, p, q);

        if(LCA_left == null || LCA_right == null) {
            return LCA_left == null ? LCA_right:LCA_left;
        } else {
            return root;
        }
    }


    public static void main(String[] args) {
        Sol235 s = new Sol235();
        int[] A = {};
        int[] B = {};
        StringBuilder sb = new StringBuilder();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        // Generate like this
        // 6
        // 2 8
        // 1 4 7 9
        //   3 5
        n6.left = n2;   n6.right=n8;
        n2.left = n1; n2.right = n4; n8.left = n7; n8.right = n9;
        n4.left = n3;   n4.right=n5;

        TreeNode res = s.lowestCommonAncestor(n6, n7,n3);
        System.out.println(res.val);
        System.out.println();
    }


}
