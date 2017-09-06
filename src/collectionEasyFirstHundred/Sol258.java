package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/6.
 * Add Digits
 */
public class Sol258 {
    // Idea: Boring pattern finding questions
    public int addDigits(int num) {
        if(num < 10){return num;}
        return 1 + (num-1)%9;
    /*
        int res=0;

    	while(num!=0){
    		res += num % 10;
    		num = num / 10;
    		if(res >= 10){
    			res = res % 10 + res / 10;
    		}
    	}
    	return res;
    */
    /*
    	int res=0;
    	while(num!= 0){
    		res += num % 10;
    		num = num / 10;
    	}
        return addDigits(res);
    */
    }
}
