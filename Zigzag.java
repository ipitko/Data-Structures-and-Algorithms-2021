
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Iiris
 */
public class Zigzag {

    /**
     * @param n
     * @return 
     */
    public int[] create(int n) {
        int[] luvut = new int[n];
        int keski = (n-(n/2))-1;
        int i = 1;
        int k = 0;
            while(i<=n){
                if(i%2==0){
                    luvut[keski+k]=i;
                }else{
                    luvut[keski-k]=i;
                    k++;
                }
                i++;
            }
        return luvut;
    }

    public static void main(String[] args) {
        Zigzag z = new Zigzag();
        System.out.println(Arrays.toString(z.create(1))); // [1]
        System.out.println(Arrays.toString(z.create(2))); // [1,2]
        System.out.println(Arrays.toString(z.create(3))); // [3,1,2]
        System.out.println(Arrays.toString(z.create(4))); // [3,1,2,4]
        System.out.println(Arrays.toString(z.create(5))); // [5,3,1,2,4]
    }
    
}
