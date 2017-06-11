package scatter;

public class Solution082 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){  return head;}
        ListNode dummy = new ListNode(-1);
        ListNode step = head;  ListNode prev = dummy;
        while(step != null ){
            if(step.next == null){
                prev.next = step;
                prev = step;
                step = null;
                continue;
            }
            int stepVal = step.val;
            if(stepVal == step.next.val){
                //Don't append and find the next possible step[Could be null, doesn't matter]
                ListNode nextstep = step.next;
                while(nextstep != null && nextstep.val == stepVal){
                    nextstep = nextstep.next;
                }
                //No matter what situation
                step = nextstep;
            }else{
                prev.next = step;
                prev = step;
                step = step.next;
            }
        }
        prev.next = null;
        return dummy.next;
    }
}
