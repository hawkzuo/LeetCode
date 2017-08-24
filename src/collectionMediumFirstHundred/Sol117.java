package collectionMediumFirstHundred;

import collectionUtils.TreeLinkNode;

/**
 * Created by Amos on 2017/7/31.
 * Populating Next Right Pointers in Each Node II
 */
public class Sol117 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        TreeLinkNode pre = null;
        TreeLinkNode cur = null;

        // head: Start node in each level
        // cur:  Current node visiting
        // pre:  Record previous node while visiting each level, reset to 'null' after visiting each level
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

            // Now if cur == null, then the next level has no nodes except for 'null's
            // if cur != null, then cur must have one children that is not null and the head is the left child(if existing)
            // or right child(if left not existing)

            // Use pre.next to set 'next' pointers for next level nodes, instead of 'cur.right.next ....'
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
