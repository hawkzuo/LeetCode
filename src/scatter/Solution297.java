package scatter;
import java.util.*;
public class Solution297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();     String spc = "null";    sb.append('(');
        if(root == null){   sb.append(')');     return sb.toString();}
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();     queue.offer(root);
        while(!queue.isEmpty()){
            int iters = queue.size();
            for(int i=0;i<iters;i++){
                TreeNode cur = queue.remove();
                //Add current node's value
                if(cur.left == cur){
                    //Special node detected
                    sb.append(spc); sb.append(',');
                    continue;
                }else{
                    sb.append(cur.val); sb.append(',');
                }
                //Care about the childrens
                if(cur.left == null){
                    TreeNode dummy = new TreeNode(0);
                    dummy.left = dummy;
                    queue.offer(dummy);
                }else{
                    queue.offer(cur.left);
                }
                if(cur.right == null){
                    TreeNode dummy = new TreeNode(0);
                    dummy.left = dummy;
                    queue.offer(dummy);                    
                }else{
                    queue.offer(cur.right);                    
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        while(sb.length() >= 6){
            //Remove overlong string (Optional)
            if(sb.substring(sb.length()-5,sb.length()) == (",null")){
                sb.delete(sb.length()-5,sb.length());
            }else{
                break;
            }
        }
        sb.append(')');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() <=2 ){ return null;}
        String eff = data.substring(1,data.length()-1);
        String[] elements = eff.split(",");
        //Still need Queue
        TreeNode root = new TreeNode(Integer.valueOf(elements[0]));
        if(elements.length == 1){   return root;}
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int i=1;
        while(!queue.isEmpty()){
            if(i<elements.length){
                TreeNode cur = queue.remove();
                //Very important idea:  Check every two values together
                if(i+1 < elements.length){
                    if(elements[i].equals("null")){
                        cur.left = null;
                    }else{
                        cur.left = new TreeNode(Integer.valueOf(elements[i]));
                        queue.offer(cur.left);
                    }
                    if(elements[i+1].equals("null")){
                        cur.right = null;
                    }else{
                        cur.right = new TreeNode(Integer.valueOf(elements[i+1]));
                        queue.offer(cur.right);
                    }
                    i+=2;
                }else{
                    //Last element, cannot be "null"
                    cur.left = new TreeNode(Integer.valueOf(elements[i]));
                    i++;
                }
            }else{
                break;
            }   
        }
        return root;
    }

}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));