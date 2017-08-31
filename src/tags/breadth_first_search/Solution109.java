//109. Convert Sorted List to Binary Search Tree

package tags.breadth_first_search;

import collectionUtils.ListNode;
import collectionUtils.TreeNode;

public class Solution109 {

    private ListNode cur=null;
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){   return null;}
        cur = head;
        
        int len=0;
        while(head!=null){
            head = head.next;
            len++;
        }
        
        TreeNode nr = cBST(0,len);
        return nr;
    }
    
    private TreeNode cBST(int begin,int end){
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
        //Follow the in-order process.
        //However, the root is newly created.
        root.right = r;
        return root;
    }

}
