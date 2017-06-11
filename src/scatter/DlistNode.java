package scatter;

public class DlistNode {
	int key;
	int value;
	DlistNode next;
	DlistNode prev;		
	public DlistNode(int k, int v){
		key = k;
		value = v;
		next = null;
		prev = null;
	}
	public void setNext(DlistNode ne){
		next=ne;
	}
	public void setPrev(DlistNode pre){
		prev=pre;
	}
}
