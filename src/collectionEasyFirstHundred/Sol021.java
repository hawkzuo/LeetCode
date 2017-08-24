package collectionEasyFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/8/25.
 * Merge Two Sorted Lists
 */
public class Sol021 {
    // Idea: Dummy Node
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode cursorA = l1;  ListNode cursorB = l2;
        while(cursorA != null && cursorB != null) {
            if(cursorA.val < cursorB.val) {
                current.next = cursorA;
                current = cursorA;
                cursorA = cursorA.next;
            } else if (cursorA.val > cursorB.val) {
                current.next = cursorB;
                current = cursorB;
                cursorB = cursorB.next;
            } else {
                current.next = cursorA;
                current = cursorA;  cursorA = cursorA.next;
                current.next = cursorB;
                current = cursorB;  cursorB = cursorB.next;
            }
        }
        if(cursorA != null) {
            addLeftovers(current, cursorA);
        }else if (cursorB != null) {
            addLeftovers(current, cursorB);
        }
        return dummy.next;
    }

    private void addLeftovers(ListNode current, ListNode cursor) {
        while(cursor != null) {
            current.next = cursor;
            current = cursor;
            cursor = cursor.next;
        }
    }


    public ListNode mergeTwoListsOld(ListNode l1, ListNode l2) {

        if(l1 == null){ return l2;}
        if(l2 == null){	return l1;}
        ListNode s1, s2, last, newHead;

        ListNode n1 = l1;	ListNode n2 = l2;

        int v1 = n1.val; int v2 = n2.val;

        if(v1 == v2){
            s1=n1;
            s2=n2;
            while(n1.next != null){
                if(n1.next.val == v1){
                    n1 = n1.next;
                }else{
                    break;
                }
            }
            while(n2.next != null){
                if(n2.next.val == v2){
                    n2 = n2.next;
                }else{
                    break;
                }
            }

            newHead = s1;
            ListNode t1 = n1.next;	ListNode t2 = n2.next;
            n1.next = s2;
            n2.next = null;
            last = n2;

            n1 = t1;
            n2 = t2;

        }else if(v1 < v2){
            s1=n1;
            s2=n2;
            while(n1.next != null){
                if(n1.next.val <= v2){
                    n1 = n1.next;
                }else{
                    break;
                }
            }
            while(n2.next != null){
                if(n2.next.val == v2){
                    n2 = n2.next;
                }else{
                    break;
                }
            }

            newHead = s1;
            ListNode t1 = n1.next;	ListNode t2 = n2.next;
            n1.next = s2;
            n2.next = null;
            last = n2;

            n1 = t1;
            n2 = t2;
        }else{

            s1=n1;
            s2=n2;
            while(n1.next != null){
                if(n1.next.val == v1){
                    n1 = n1.next;
                }else{
                    break;
                }
            }
            while(n2.next != null){
                if(n2.next.val <= v1){
                    n2 = n2.next;
                }else{
                    break;
                }
            }

            newHead = s2;
            ListNode t1 = n1.next;	ListNode t2 = n2.next;
            n2.next = s1;
            n1.next = null;
            last = n1;
            n1 = t1;
            n2 = t2;
        }

        if(n1 == null && n2 == null){
            return newHead;
        }else if(n1 != null && n2 == null){
            last.next = n1;
            return newHead;
        }else if(n1 == null){
            last.next = n2;
            return newHead;
        }

        //Looping
        while(n1 != null && n2 != null){
            v1 = n1.val;	v2 = n2.val;
            if(v1 == v2){
                s1=n1;
                s2=n2;
                while(n1.next != null){
                    if(n1.next.val == v1){
                        n1 = n1.next;
                    }else{
                        break;
                    }
                }
                while(n2.next != null){
                    if(n2.next.val == v2){
                        n2 = n2.next;
                    }else{
                        break;
                    }
                }
                ListNode t1 = n1.next;	ListNode t2 = n2.next;

                last.next = s1;
                n1.next = s2;
                n2.next = null;
                last = n2;

                n1 = t1;
                n2 = t2;

            }else if(v1 < v2){
                s1=n1;
                s2=n2;
                while(n1.next != null){
                    if(n1.next.val <= v2){
                        n1 = n1.next;
                    }else{
                        break;
                    }
                }
                while(n2.next != null){
                    if(n2.next.val == v2){
                        n2 = n2.next;
                    }else{
                        break;
                    }
                }
                ListNode t1 = n1.next;	ListNode t2 = n2.next;

                last.next = s1;
                n1.next = s2;
                n2.next = null;
                last = n2;

                n1 = t1;
                n2 = t2;
            }else{

                s1=n1;
                s2=n2;
                while(n1.next != null){
                    if(n1.next.val == v1){
                        n1 = n1.next;
                    }else{
                        break;
                    }
                }
                while(n2.next != null){
                    if(n2.next.val <= v1){
                        n2 = n2.next;
                    }else{
                        break;
                    }
                }
                ListNode t1 = n1.next;	ListNode t2 = n2.next;

                last.next = s2;
                n2.next = s1;
                n1.next = null;
                last = n1;

                n1 = t1;
                n2 = t2;
            }
        }
        //At least one list runs out.
        if(n1 == null && n2 == null){
            return newHead;
        }else if(n1 != null){
            last.next = n1;
            return newHead;
        }else {
            last.next = n2;
            return newHead;
        }
    }
}
