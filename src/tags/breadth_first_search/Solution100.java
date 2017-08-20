//100. Same Tree

//Divide and Conquer
package tags.breadth_first_search;

public class Solution100 {

	public Solution100() {
		// TODO Auto-generated constructor stub
	}
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q== null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
