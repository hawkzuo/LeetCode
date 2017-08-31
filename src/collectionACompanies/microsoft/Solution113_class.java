package collectionACompanies.microsoft;

import collectionUtils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution113_class {
    private List<List<Integer>> result;
    private List<Integer> l;
    private int sum;
    private int curSum = 0;
	public Solution113_class() {
		// TODO Auto-generated constructor stub
	}

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new LinkedList<List<Integer>> ();
    	l = new LinkedList<Integer> ();
    	this.sum = sum;
        if(root==null)
            return result;    	
    	
    	pathSum(root);
    	
    	return result;
    	
    	
    	
    }	
	
    private void pathSum(TreeNode root) {
        if (root != null) {

            l.add(root.val);
            curSum += root.val;

            if (root.left == null && root.right == null && curSum == sum) {
                List<Integer> list = new LinkedList<>();
                for (Integer i : l) {
                    list.add(i);
                }

                result.add(list);
            }

            if (root.left != null) {
                pathSum(root.left);
            }

            if (root.right != null) {
                pathSum(root.right);
            }

            curSum -= root.val;
            l.remove(l.size() - 1); // Delete last
        }
    }	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
