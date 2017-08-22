package collectionMediumFirstHundred;

import java.util.*;

/**
 * Created by Amos on 2017/7/31.
 * Clone Graph
 */
public class Sol133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){   return null;}

        Map<UndirectedGraphNode,UndirectedGraphNode> connect = new HashMap<>();

        Deque<UndirectedGraphNode> q = new ArrayDeque<>();
        UndirectedGraphNode clonedRoot = new UndirectedGraphNode(node.label);
        q.add(node);

        connect.put(node,clonedRoot);

        while(!q.isEmpty()){
            // Once in the queue, all neighbors will be visited
            // Each node will be in queue only once, and must after the connection is established
            int ops = q.size();
            for(int i=0;i<ops;i++){
                UndirectedGraphNode cur = q.remove();
                UndirectedGraphNode clonedNode = connect.get(cur);

                List<UndirectedGraphNode> nbs = cur.neighbors;
                List<UndirectedGraphNode> newNbs = clonedNode.neighbors;

                for(UndirectedGraphNode nb : nbs){
                    if(nb == cur){
                        newNbs.add(clonedNode);
                    }else if(connect.containsKey(nb)){
                        newNbs.add(connect.get(nb));
                    }else{
                        // Encounter a node not visited before
                        UndirectedGraphNode clonedNb = new UndirectedGraphNode(nb.label);
                        connect.put(nb,clonedNb);
                        newNbs.add(connect.get(nb));

                        q.add(nb);
                    }
                }
            }
        }
        return clonedRoot;
    }
}
