package ai625;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * Created by Amos on 9/15/17.
 *
 */
public class TestBuilder {
    // TestBuilder

    public static void main(String[] args) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Node root = new Node(5, 3, false);
        Node optimal = null;
        pq.add(root);

        // Don't allow duplicate states
        Set<State> visitedStates = new HashSet<>();

        while(!pq.isEmpty()) {
            Node nextNode = pq.poll();
            visitedStates.add(nextNode.state);

            List<Node> nextLevel = nextNode.generateSuccessors();
            boolean found = false;
            for(Node next: nextLevel) {
                if(visitedStates.contains(next.state)) {
                    continue;
                } else if (Utils.checkState(next.state)) {
                    optimal = next;
                    found = true;
                } else {
                    pq.add(next);
                }
            }
            if(found) {
                break;
            }
        }

        System.out.println(optimal.rank);
        System.out.println(Utils.generatePath(optimal));


    }

}
