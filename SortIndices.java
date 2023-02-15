import java.util.Arrays;

public class SortIndices {
    public int[] get(int[] t) {
        Pari[] indeksit = new Pari[t.length];
        for(int i=0;i<t.length;i++){
            Pari p = new Pari(t[i],i);
            indeksit[i]=p;
        }
        Arrays.sort(indeksit);
        int[] palautettava = new int[indeksit.length];
        for(int i=0;i<indeksit.length;i++){
            palautettava[i]=indeksit[i].palautaArvo();
        }
        return palautettava;
    }

    public static void main(String[] args) {
        SortIndices s = new SortIndices();
        System.out.println(Arrays.toString(s.get(new int[] {1,2,4,3}))); // [0,1,3,2]
        System.out.println(Arrays.toString(s.get(new int[] {4,2,1,3}))); // [2,1,3,0]
        System.out.println(Arrays.toString(s.get(new int[] {6,2,8,5,3}))); // [1,4,3,0,2]
    }
}
class Pari implements Comparable<Pari>{
    
    private int a, b;
    public Pari(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    public int palautaArvo(){
        return this.b;
    }

    @Override
    public int compareTo(Pari p) {
            if (this.a == p.a) {
                return 0;
            } else if (this.a > p.a) {
                return 1;
            } else {
                return -1;
            }
    }
    
}

