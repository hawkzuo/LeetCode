//116. Populating Next Right Pointers in Each Node

package tags.breadth_first_search;

import collectionUtils.TreeLinkNode;

public class Solution116 {

	public Solution116() {
		// TODO Auto-generated constructor stub
	}
    public void connect(TreeLinkNode root) {
        if(root == null){   return;}
        TreeLinkNode head = root;
        
        TreeLinkNode cur = null;
        
        while(head.left != null){
            cur = head;
            while(cur!=null){
                cur.left.next = cur.right;
                if(cur.next != null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            head = head.left;
        }        




    }
}
