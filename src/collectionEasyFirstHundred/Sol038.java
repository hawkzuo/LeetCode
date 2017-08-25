package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Count and Say
 */
public class Sol038 {
    // Idea: Step by step construct
    //       Rules are not very clear
    public String countAndSay(int n) {

        if(n <= 0) {    return "";}
        String[] refer = {"1", "11", "21", "1211", "111221"};
        if(n <= 5) {    return refer[n-1]; }

        StringBuilder toDecode = new StringBuilder(refer[4]);
        StringBuilder decoded = null;
        int step = 6;
        while(step <= n){
            processRule12(toDecode);
            processRule3(toDecode);
            decoded = new StringBuilder();
            build(toDecode, decoded);
            toDecode = decoded;
            step++;
        }
        return decoded.toString();
    }

    private void build(StringBuilder input, StringBuilder decoded) {
        int index = 0;
        int times = 0;  Character step = null;
        while(index < input.length()) {
            char current = input.charAt(index);
            if( current== '*' || current == '[' || current == '(') {
                // Calculate
                if(step != null) {
                    decoded.append(times);  decoded.append(step);
                }
                if(current == '*') {
                    decoded.append("11");
                    index++;
                }else if(current == '(') {
                    decoded.append("21");
                    index += 2;
                }else {
                    decoded.append("1211");
                    index += 2;
                }
                times = 0;  step = null;
            } else {
                if(step == null) {
                    step = current;
                    times = 1;
                }else if (step == current) {
                    times ++;
                }else {
                    // Calculate
                    decoded.append(times);  decoded.append(step);
                    step = current; times = 1;
                }
                index ++;
            }
        }
    }

    private void processRule3(StringBuilder input) {
        char prev = input.charAt(0);
        for(int i=1;i<input.length();i++) {
            if(input.charAt(i) == '1' && prev == '2' && i == input.length()-1) {
                input.setCharAt(i-1, '[');
                input.setCharAt(i, '[');
                prev = '1';
            } else if(input.charAt(i) == '1' && prev == '2' && input.charAt(i+1) != '1') {
                input.setCharAt(i-1, '[');
                input.setCharAt(i, '[');
                prev = '1';
            } else {
                prev = input.charAt(i);
            }
        }
    }

    private void processRule12(StringBuilder input) {
        int count = 0;
        for(int i=0;i<input.length();i++) {
            if(input.charAt(i) == '1') {
                count ++;
            } else {
                if(count == 1) {
                    input.setCharAt(i-1, '*');
                }else if(count == 2) {
                    input.setCharAt(i-2, '(');
                    input.setCharAt(i-1, '(');
                }
                count = 0;
            }
        }
        // Final take care
        if(count == 1) {
            input.setCharAt(input.length()-1, '*');
        }else if (count == 2) {
            input.setCharAt(input.length()-2, '(');
            input.setCharAt(input.length()-1, '(');
        }
    }
// 31131211131221
// 13211311123113112211
// 1321131112112113112211
// 13211311123113112211
    // 3[21]3[11]21113[11]22[11]
    // 3[21]3[11][1211]113[11]22[11]

    public static void main(String[] args) {
        Sol038 s = new Sol038();
        StringBuilder sb = new StringBuilder();
        System.out.println(s.countAndSay(10));

    }
}
