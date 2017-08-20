//133. Clone Graph

package tags.breadth_first_search;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution133 {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){   return null;}
        
        //Map<UndirectedGraphNode,Integer> visited = new HashMap<UndirectedGraphNode,Integer>();   
        
        Map<UndirectedGraphNode,UndirectedGraphNode> connect = new HashMap<UndirectedGraphNode,UndirectedGraphNode>(); 
        
        Deque<UndirectedGraphNode> q = new ArrayDeque<UndirectedGraphNode>();
        UndirectedGraphNode nroot = new UndirectedGraphNode(node.label);
        q.add(node);    
        
        connect.put(node,nroot);    
        
        while(!q.isEmpty()){
            
            int ops = q.size();
            
            for(int i=0;i<ops;i++){
                
                UndirectedGraphNode cur = q.remove();
                UndirectedGraphNode newnode = connect.get(cur);
                
                List<UndirectedGraphNode> nbs = cur.neighbors;
                List<UndirectedGraphNode> newnbs = newnode.neighbors;
                
                for(UndirectedGraphNode nb : nbs){
                    if(nb == cur){
                        newnbs.add(newnode);
                    }else if(connect.containsKey(nb)){
                        newnbs.add(connect.get(nb));
                        
                    }else{
                        UndirectedGraphNode nsib = new UndirectedGraphNode(nb.label);
                        connect.put(nb,nsib);
                        newnbs.add(connect.get(nb));                        
                        q.add(nb);
                    }
                }
            }

        }
        
        return nroot;
        
        
        
    }

}
