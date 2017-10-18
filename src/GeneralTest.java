import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Amos on 2017/7/1.
 */

public class GeneralTest {


    public static void main(String[] args){
//        System.out.println("Tom Dickens , Katy Perry , ".split(" , ").length);
//        System.out.println("Tom Dickens , ".split(" , ").length);
        int[][] d = new int[2][3];
        int t = 2;
        Integer tt = null;


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(3);
        System.out.println(pq.peek());

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        PriorityQueue<Integer> pq3 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        pq2.add(1);
        pq2.add(2);
        pq2.add(3);
        System.out.println(pq2.peek());


    }

}
