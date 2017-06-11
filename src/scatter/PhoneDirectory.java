package scatter;
import java.util.*;
public class PhoneDirectory {
	
	int Cap = -1;
	Set<Integer> avl;
	
    /** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public PhoneDirectory(int maxNumbers) {	    
		Cap = maxNumbers;
		avl = new HashSet<Integer>();
		for(int i=0;i<Cap;i++){		avl.add(i);	}		
	}
	
	/** Provide a number which is not assigned to anyone.
	    @return - Return an available number. Return -1 if none is available. */
	public int get() {
	    if(avl.size() == 0){	return -1;}
	    int pKey=-1;
	    for(Integer psKey: avl){
	    	avl.remove(psKey);
	    	pKey = psKey;
	    	break;
	    }
	    return pKey;
	}
	
	/** Check if a number is available or not. */
	public boolean check(int number) {
	    return avl.contains(number);
	}
	
	/** Recycle or release a number. */
	public void release(int number) {
		if(avl.contains(number)){	return;}
		else{	avl.add(number);}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
