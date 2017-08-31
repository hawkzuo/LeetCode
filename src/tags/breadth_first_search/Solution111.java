//111. Minimum Depth of Binary Tree

package tags.breadth_first_search;

import collectionUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution111 {

	public Solution111() {
		// TODO Auto-generated constructor stub
	}
    public int minDepth(TreeNode root) {
        if(root == null){   return 0;}
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int cnt = 1;
        while(!queue.isEmpty()){
            int times = queue.size();
            for(int i=0;i<times;i++){
                TreeNode cur = queue.remove();
                if(cur.left == null && cur.right == null){
                    return cnt;
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                if(cur.left != null){
                    queue.add(cur.left);
                }

            }
            cnt++;
        }
        return cnt;
    }
}
