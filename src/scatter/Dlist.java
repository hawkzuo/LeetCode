package scatter;

public class Dlist {

	DlistNode head;
	DlistNode tail;
	int len;
	public Dlist(){
		len=0;
		head=null;
		tail=null;
	}
	public void addTop(DlistNode n){
		if(len == 0){
			head=n;	tail=n;
			len++;
		}else{
			n.setNext(head);n.setPrev(null);
			head.setPrev(n);
			head=n;
			len++;
		}
	}
	public void addLast(DlistNode n){
		if(len == 0){
			head=n;	tail=n;
			len++;
		}else{
			n.setPrev(tail);n.setNext(null);
			tail.setNext(n);
			tail=n;
			len++;
		}			
	}
	public void remove(DlistNode n){
		if(len == 0){	return ;}
		if(n.prev == null){
			if(len == 1){
				len--;n.next=null;
				head=null;	tail=null;
			}else if (n.next == null){
				return;
			}else{
				n.next.setPrev(null);
				head=n.next;
				n.next=null;	len--;	
			}
		}else{
			n.prev.setNext(n.next);
			if(n.next!=null){
				n.next.setPrev(n.prev);
				n.next=null;	n.prev=null;
			}else{
				tail=n.prev;
				n.next=null;	n.prev=null;
			}
			len--;
		}
	}
	private int size(){
		return len;
	}

}
