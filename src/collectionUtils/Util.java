package collectionUtils;

import java.util.List;

/*
 * Created by Amos on 10/23/17.
 */
public class Util {


    public static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(-1);
        ListNode pt = dummy;
        for(Integer val: values) {
            pt.next = new ListNode(val);
            pt = pt.next;
        }
        return dummy.next;
    }





}
