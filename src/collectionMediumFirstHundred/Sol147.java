package collectionMediumFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/8/10.
 * Insertion Sort List
 */
public class Sol147 {
    public ListNode insertionSortList(ListNode head) {
        // Idea: Basic List Operations
        if(head == null || head.next == null){	return head;}

        ListNode dummy = new ListNode(-1);  ListNode prev = head;   dummy.next = head;

        ListNode currentStep = head.next;
        while(currentStep != null){
            if(currentStep.val >= prev.val){
                prev = currentStep;
                currentStep = currentStep.next;
            } else{
                // Pop out the currentStep node
                ListNode next = currentStep.next;
                prev.next = next;

                // Find the right place to put node in
                ListNode cursor = dummy;
                while(currentStep.val > cursor.next.val){
                    cursor = cursor.next;
                }
                currentStep.next = cursor.next;
                cursor.next = currentStep;

                // Move on to the next step
                currentStep = next;
            }
        }
        return dummy.next;
    }
}
