import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Tasajako {

    static int n = 28;
    static Integer[] luvut = new Integer[n];
    static int toistot = 20;
    static int ylaraja = 99999999;
    static int[] loppusumma = new int[n];
    
    static boolean tasajako(Integer[] luvut, int erotus, int k) {
	if (k==luvut.length){
            return (erotus==0);
        }else{
            if(Math.abs(erotus)>loppusumma[k]){
                return false;
            }
            if (tasajako(luvut, erotus+luvut[k], k+1)){
                return true;
            }else{
                return tasajako(luvut, erotus-luvut[k], k+1);
            }
        }
    }

    public static void main(String[] args) {

	Random generator = new Random();

        for (int t=0; t<toistot; t++) {
	    if (t>0) System.out.println("--");
	    for (int i=0; i<luvut.length; i++) {
		luvut[i] = generator.nextInt(ylaraja-1)+1;
	    }
            Arrays.sort(luvut,Collections.reverseOrder());
            int summa=0;
            for(int i=0;i<luvut.length;i++){
                summa+=luvut[i];
            }
            loppusumma[0]=summa;
            for(int i=1;i<luvut.length;i++){
                loppusumma[i]=loppusumma[i-1]-luvut[i-1];
            }
            long alku = System.nanoTime();
	    boolean loytyi = tasajako(luvut, 0, 0);
            long loppu = System.nanoTime();
            long aika = loppu-alku;
            System.out.printf("aika: %d ms; vastaus: %b%n",
                              TimeUnit.NANOSECONDS.toMillis(aika), loytyi);
        }
    }
}

