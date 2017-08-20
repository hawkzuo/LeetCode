//117. Populating Next Right Pointers in Each Node II

package tags.breadth_first_search;

public class Solution117 {

    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        TreeLinkNode pre = null;
        TreeLinkNode cur = null;
        
        while(head != null){
            cur = head;
            while(cur != null){
                if(cur.left != null){
                    head = cur.left;
                    break;
                }
                if(cur.right != null){
                    head = cur.right;
                    break;
                }
                cur = cur.next;
            }
            if(cur == null){
                head = null;
            }
            while(cur!=null){
                if(cur.left!=null){
                    if(pre != null){
                        pre.next = cur.left;
                    }
                    pre = cur.left;
                }
                if(cur.right!=null){
                    if(pre !=null){
                        pre.next = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            pre = null;
            
        }
    }

}
