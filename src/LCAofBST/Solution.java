package LCAofBST;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
		
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

/*		
		 if(root == null){
	            return null;
	        }    
	        if (root == p || root == q){
	            return root;
	        }
	        TreeNode l=lowestCommonAncestor(root.left,p,q);
	        TreeNode r=lowestCommonAncestor(root.right,p,q);
	        
	        if(l != null && r != null){
	            return root;
	        }
	        return (l != null) ? l:r;		
*/		
		
		
		
		List<TreeNode> p_path = new ArrayList<TreeNode>();p_path.add(root);
		List<TreeNode> q_path = new ArrayList<TreeNode>();q_path.add(root);
		
		p_path=find_path(root,p,p_path);
		q_path=find_path(root,q,q_path);
		
		TreeNode lca=root;
        for(int i=0;i<Math.min(p_path.size(), q_path.size());i++){
        	if( p_path.get(i).val == q_path.get(i).val){
        		//Lowest doesn't mean value, it means the deep of the tree.
        		lca=p_path.get(i);
        		/*
        		if(p_path.get(i).val < least){
        			lca=p_path.get(i);
        			least=p_path.get(i).val;
        		}else{
        			;
        		} 
        		*/
        	}
        	else{
        		break;
        	}
        }
		
        return lca;
    }

	
	public List<TreeNode> find_path(TreeNode r, TreeNode p, List<TreeNode> path){
		if(r != null){
			if(r == p){
				return path;
			}
			if(r.left == p || r.right== p){
				path.add(p);
				return path;
			}else{
				List<TreeNode> lpath = new ArrayList<TreeNode>(); lpath.add(r.left);
				List<TreeNode> r1=find_path(r.left,p,lpath);
				List<TreeNode> rpath = new ArrayList<TreeNode>(); rpath.add(r.right);
				List<TreeNode> r2=find_path(r.right,p,rpath);
				if(r1 != null){
					List<TreeNode> sum=new ArrayList<TreeNode>();
					sum.addAll(path); sum.addAll(r1);
					return sum;					
				}else if(r2 != null){
					List<TreeNode> sum=new ArrayList<TreeNode>();
					sum.addAll(path); sum.addAll(r2);
					return sum;
				}else{
					return null;
				}								
			}					
		}else{
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n3=new TreeNode(3);
		TreeNode n5=new TreeNode(5);
		TreeNode n0=new TreeNode(0);
		TreeNode n7=new TreeNode(7);
		TreeNode n9=new TreeNode(9);
		
		TreeNode n4=new TreeNode(4,n3,n5);
		TreeNode n2=new TreeNode(2,n0,n4);
		TreeNode n8=new TreeNode(8,n7,n9);
		TreeNode n6=new TreeNode(6,n2,n8);
		
		Solution s=new Solution();
		TreeNode lcares=s.lowestCommonAncestor(n6, n2, n4);
		System.out.println(lcares);
	}

}
