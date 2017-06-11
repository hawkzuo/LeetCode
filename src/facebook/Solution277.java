package facebook;

public class Solution277 {

	public Solution277() {
		// TODO Auto-generated constructor stub
	}
    public int findCelebrity(int n) {
        if(n<=1){   return -1;}     
        //Now n>=2
        int lp = 0; int rp=1;
      //By the property of celebrity, one method call will surely reduce size by 1
        while(lp <n && rp<n){
            if(knows(lp,rp)){
                //lp must not be a celebrity
                lp=Math.max(lp,rp)+1;                
            }else{
                //rp must not be a celebrity
                rp=Math.max(lp,rp)+1;
            }      
        }
        
        int candidate = -1;
        if(lp < n)	candidate = lp;
        else		candidate = rp;

        for(int i=0;i<n;i++){
            if(i == candidate){
                continue;
            }
            //Check this candidate
            if(!knows(i,candidate) || knows(candidate,i)){
                return -1;
            }
        }
        return candidate;

    }
    //Dummy method to support this class
	private boolean knows(int lp, int rp) {
		// TODO Auto-generated method stub
		return false;
	}
}
