package companies.microsoft;

public class Solution342 {

	public Solution342() {
		// TODO Auto-generated constructor stub
	}
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;        
    }
}
