package collectionHardFirstFifty;

import collectionUtils.*;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Created by Amos on 10/23/17.
 * Merge k Sorted Lists
 */
public class Sol023 {

    // Idea: Use PriorityQueue or Use Divide & Conquer
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.length);
    }


    // Format [start, end)
    private ListNode mergeList(ListNode[] lists, int start, int end) {
        //  nnnnnnnn
        //  2n 2n 2n 2n
        // 4n 4n
        // 8n
        // @return: The merged Head Node
        int len = end - start;
        if(len == 1) {
            return lists[start];
        } else if (len == 2) {
            return mergeTwoLists(lists[start], lists[start+1]);
        } else {
            // Mind Typo Here
            int mid = start + len / 2;
            ListNode leftHead = mergeList(lists, start, mid);
            ListNode rightHead = mergeList(lists, mid, end);
            return mergeTwoLists(leftHead, rightHead);
        }
    }

    private ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(-1);
        ListNode cursor = dummy;
        while(n1 != null && n2 != null) {
            if(n1.val <= n2.val) {
                cursor.next = n1;
                cursor = cursor.next;
                n1 = n1.next;
            } else {
                cursor.next = n2;
                cursor = cursor.next;
                n2 = n2.next;
            }
        }
        if(n1 != null) {
            cursor.next = n1;
        } else if(n2 != null) {
            cursor.next = n2;
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        //O(nklgk)
        // 1234
        // 1257
        // 347
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode step : lists) {
            if (step != null) {
                pq.offer(step);
            }
        }

        ListNode cursor = dummy;

        while(!pq.isEmpty()) {
            ListNode step = pq.poll();
            cursor.next = step;
            cursor = cursor.next;

            if(step.next != null) {
                pq.offer(step.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Sol023 s = new Sol023();
        int[] A = {};
        int[] B = {};
        StringBuilder sb = new StringBuilder();

        int[][] data = {{-10,-9,-9,-3,-1,-1,0},{-5},{4},{-8},{},{-9,-6,-5,-4,-2,2,3},{-3,-3,-2,-1,0}};
        ListNode[] lists = new ListNode[data.length];
        for(int i=0; i<data.length; i++) {
            lists[i] = Util.buildList(data[i]);
        }
        System.out.print(s.mergeKLists(lists));

    }


}
