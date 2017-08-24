package collectionMediumFirstHundred;

import collectionUtils.ListNode;
import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/7/30.
 * Convert Sorted List to Binary Search Tree
 */
public class Sol109 {
    private ListNode cur=null;

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){   return null;}
        cur = head;

        int len=0;
        while(head!=null){
            head = head.next;
            len++;
        }

        return cBST(0,len);
    }

    private TreeNode cBST(int begin,int end){
        // Notice the index of the list and the inorder traversal connection

        if(begin >= end){   return null;}

        int index = (begin + end)/2;

        //Left-Visit
        TreeNode l = cBST(begin,index);

        //Middle-Visit
        TreeNode root = new TreeNode(cur.val);
        root.left = l;
        cur = cur.next;

        //Right-Visit
        TreeNode r = cBST(index+1,end);

        //Post-Process and return values
        root.right = r;
        return root;
    }
}
