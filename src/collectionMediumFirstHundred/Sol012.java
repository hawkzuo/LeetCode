package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/7/13.
 * Integer to Roman
 */
public class Sol012 {
    public String intToRoman(int num) {
        int d1=num % 10;
        int d2=0; int d3=0; int d4=0;
        if((num / 10) > 0){
            d2 = (num / 10) % 10;
            if((num / 100) > 0){
                d3 = (num / 100) % 10;
                if((num / 1000) > 0){
                    d4 = (num / 1000) % 10;
                }
            }
        }
        String [] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String [] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String [] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String [] thousands = {"","M","MM","MMM","MMMM","MMMMM"};
        return thousands[d4] + hundreds[d3] + tens[d2] + ones[d1];
    }
}
