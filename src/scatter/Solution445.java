package scatter;

import java.util.ArrayList;
import java.util.List;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = null;   ListNode cur = l1;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev; prev = cur;  cur=tmp;
        }
        ListNode nhead1 = prev;  
        prev = null;    cur = l2;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev; prev = cur;  cur=tmp;
        }
        ListNode nhead2 = prev;
        
        ListNode p1 = nhead1;   ListNode p2=nhead2;
        prev = null;    int carry = 0;
        
        while(p1!=null && p2!=null){
            int val = p1.val+p2.val+carry;
            carry = val/10;
            ListNode nnode = new ListNode(val %10);
            nnode.next = prev;  prev = nnode;
            p1 = p1.next;   p2=p2.next;
        }
        
        if(p1 == null && p2 == null){
            ;
        }else if(p1 == null){
            while(p2 != null){
                int val = p2.val+carry;
                carry = val/10;
                ListNode nnode = new ListNode(val %10);
                nnode.next = prev;  prev = nnode;
                p2=p2.next;
            }
        }else{
            //p2 == null
            while(p1 != null){
                int val = p1.val+carry;
                carry = val/10;
                ListNode nnode = new ListNode(val %10);
                nnode.next = prev;  prev = nnode;
                p1 = p1.next;
            }            
        }
        //Finally take care of carry-bit
        if(carry == 0){ return prev;}
        ListNode head = new ListNode(carry);    head.next = prev;  
        return head;        
    }
    public ListNode addTwoNumbersViaList(ListNode l1, ListNode l2) {
        
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        
        ListNode cur = l1;
        while(cur != null){
            list1.add(0,cur.val); cur = cur.next;
        }
        cur = l2;
        while(cur !=null){
            list2.add(0,cur.val); cur = cur.next;
        }
        
        int bits1 = list1.size();   int bits2 = list2.size();
        int carry = 0;  
        
        ListNode prev = null;
        
        
        for(int i=0;i<Math.min(bits1,bits2); i++){
            int v = list1.get(i) + list2.get(i) + carry;
            carry = v / 10;
            ListNode nnode = new ListNode(v %10);
            nnode.next = prev;  prev = nnode;
        }
        
        if(bits1 == bits2){
            ;
        }else if (bits1 > bits2){
            for(int i=bits2;i<bits1;i++){
                int v = list1.get(i) + carry;
                carry = v / 10;
                ListNode nnode = new ListNode(v %10);
                nnode.next = prev;  prev = nnode;
            }
        }else{
            for(int i=bits1;i<bits2;i++){
                int v = list2.get(i) + carry;
                carry = v / 10;
                ListNode nnode = new ListNode(v %10);
                nnode.next = prev;  prev = nnode;
            }            
        }
        
        if(carry == 0){ return prev;}
        else{
            ListNode head = new ListNode(carry);    head.next = prev;
            return head;
        }
    }
}
