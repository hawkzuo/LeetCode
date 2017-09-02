package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/27.
 * Count Primes
 */
public class Sol204 {
    // Idea: Math rules
    // TODO: Take notes
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] notPrime = new boolean[n];
        int res = 0;
        int bound = (int) Math.sqrt(n);
        for (int i = 2; i < n; i++) {
            // notPrime numbers will definitely be marked true before i increased to that value
            if (!notPrime[i]) {
                // Mark all numeric times of prime to be notPrime
                res++;
                if (i <= bound)
                    for (int j = i * i; j < n; j += i)
                        notPrime[j] = true;
            }
        }
        return res;
    }
}
