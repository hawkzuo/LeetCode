package companies.microsoft;

public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	     
	     
	     public String toString(){
	    	 String str="";
	    	 
	    	 ListNode t = this;
	    	 while(t != null){
	    	 
	    		 str += "["+t.val+"]";
	    		 t = t.next;
	    	 }
	    	 
	    	 return str;
	    	 	    	 
	     }
	     
}
