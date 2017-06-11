//230. Kth Smallest Element in a BST

package breadth_first_search;

public class Solution230 {


    private int res;
    private int cnt;
    
    public int kthSmallestDFS(TreeNode root, int k) {
        cnt = 0;
        
        inorderVDFS(root,k);
        
        return res;
    }
    private void inorderVDFS(TreeNode root,int k){
        if(root == null){   return;}
        
        inorderVDFS(root.left,k);
        
        cnt++;
        if(cnt == k){
            res = root.val;
            return;
        }
        
        
        inorderVDFS(root.right,k);        
        
    }
    
    
    
}
