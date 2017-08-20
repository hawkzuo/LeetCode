//450. Delete Node in a BST

package tags.breadth_first_search;

public class Solution450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        //Corner case 1:
        if(root ==null){    return null;}
        TreeNode p = null;
        TreeNode cur = root;
        if(root.val == key){
//            root is to be deleted   
            ;
        }else{
            while(cur!=null){
                if(cur.val < key){
                    p=cur;
                    cur=cur.right;
                }else if(cur.val > key){
                    p=cur;
                    cur=cur.left;
                }else{
                    break;
                }
            }
        }
        if(cur == null){    return root;}
        if(cur == root){
            if(cur.left == null && cur.right == null){
                return null;
            }else if(cur.left == null && cur.right != null){
                TreeNode nroot = cur.right;
                cur.right = null;
                return nroot;
                
            }else if(cur.left != null && cur.right == null){
                TreeNode nroot = cur.left;
                cur.left = null;
                return nroot;           
                
            }else{
                //Find smallest in right sub tree
                TreeNode np = cur;
                TreeNode crr = cur.right;
                while(crr.left!=null){
                    np=crr;
                    crr=crr.left;
                }
                int nexthigher=crr.val;
                //Remove the smallest node and
                //replace cur's val with crr.
                //Note this is crr NOT cur
                if(crr.right == null){
                    if(np.left == crr){
                        np.left=null;
                    }else{
                        np.right=null;
                    }
                    cur.val=nexthigher;
                }else{
                    if(np.left == crr){
                        np.left=crr.right;
                        crr.right=null;
                    }else{
                        np.right=crr.right;
                        crr.right=null;
                    }
                    cur.val=nexthigher;                    
                }
                return root;
            }
          
        }else{
            if(cur.left == null && cur.right == null){
                if(p.left == cur){
                    p.left=null;
                }else{
                    p.right=null;
                }
                return root;
            }else if(cur.left == null && cur.right != null){
                if(p.left == cur){
                    p.left=cur.right;
                    cur.right=null;
                }else{
                    p.right=cur.right;
                    cur.right=null;
                }
                return root;
                
            }else if(cur.left != null && cur.right == null){
                if(p.left == cur){
                    p.left=cur.left;
                    cur.left=null;
                }else{
                    p.right=cur.left;
                    cur.left=null;
                }
                return root;           
                
            }else{
                TreeNode np = cur;
                TreeNode crr = cur.right;
                while(crr.left!=null){
                    np=crr;
                    crr=crr.left;
                }
                int nexthigher=crr.val;
                //Remove the smallest node and
                //replace cur's val with crr.
                //Note this is crr NOT cur
                if(crr.right == null){
                    if(np.left == crr){
                        np.left=null;
                    }else{
                        np.right=null;
                    }
                    cur.val=nexthigher;
                }else{
                    if(np.left == crr){
                        np.left=crr.right;
                        crr.right=null;
                    }else{
                        np.right=crr.right;
                        crr.right=null;
                    }
                    cur.val=nexthigher;                    
                }
                return root;
            }            

        }
        
    }

}
