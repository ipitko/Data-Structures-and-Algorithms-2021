
import java.util.PriorityQueue;

public class TwoThree {

    public int smallest(int n) {
        PriorityQueue<Integer> keko = new PriorityQueue<>();
        int x=1;
        keko.add(x);
        for(int i=0;i<n;i++){
            x=keko.peek();
            keko.poll();
            keko.add(2*x);
            keko.add(3*x);
        }
        return keko.peek();
    }

    public static void main(String[] args) {
        TwoThree t = new TwoThree();
        System.out.println(t.smallest(1)); // 2
        System.out.println(t.smallest(5)); // 6
        System.out.println(t.smallest(123)); // 288
        System.out.println(t.smallest(55555)); // 663552
    }
    
}
