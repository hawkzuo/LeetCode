    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
    	List<Integer> path = new ArrayList<Integer> ();
        if(root==null)
            return res;    	
    	
    	addPathSum(root,sum,0,path,res);
    	
    	return res;
    	
    	
    	
    }	
	
    private void addPathSum(TreeNode root,int sum,int now, List<Integer> path, List<List<Integer>> res){
        if(root==null)
            return ;
        //'now' 
        now += root.val;
        path.add(root.val);
        //leaf node
        if(root.left==null && root.right==null){
            if(sum == now){
            	res.add(path);
            	//path.remove(path.size()-1);
            	return;
            	
            	
            }else{
            	//path.remove(path.size()-1);
            }
        }else{
        	if(root.left != null){
        		addPathSum(root.left,sum,now,path,res);
        		//path.remove(path.size()-1);
        	}
        	if(root.right != null){
        		addPathSum(root.right,sum,now,path,res);
        		//path.remove(path.size()-1);
        	}
        	
        
        }
        
    }