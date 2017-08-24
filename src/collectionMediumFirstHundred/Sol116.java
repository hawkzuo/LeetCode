package collectionMediumFirstHundred;

import collectionUtils.TreeLinkNode;

/**
 * Created by Amos on 2017/7/31.
 * Populating Next Right Pointers in Each Node
 */
public class Sol116 {
    //      1 -> NULL
    //    /  \
    //   2 -> 3 -> NULL
    //  / \  / \
    // 4->5->6->7 -> NULL

    // Level by level construction
    public void connect(TreeLinkNode root) {
        if(root == null){   return;}
        TreeLinkNode head = root;
        TreeLinkNode cur = null;

        while(head.left != null){
            cur = head;
            while(cur!=null){
                // Handle 2->3 4->5 6->7
                cur.left.next = cur.right;
                if(cur.next != null){
                    // Handle 5->6
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            head = head.left;
        }
    }
}
