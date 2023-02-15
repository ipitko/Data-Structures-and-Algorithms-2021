
public class TwoChar {

    public long count(String s) {
        String[] kirjaimet = s.split("");
        int[] samaaperakkain = new int[kirjaimet.length];
        samaaperakkain[0]=1;
        for(int i=1;i<kirjaimet.length;i++){
            if(kirjaimet[i].equals(kirjaimet[i-1])){
                samaaperakkain[i]=samaaperakkain[i-1]+1;
            }else{
                samaaperakkain[i]=1;
            }
        }
        long[] summat = new long[samaaperakkain.length];
        summat[0] = 0;
        String edellinen = kirjaimet[0];
        String toka = "";
        int apu = 1;
        for(int i=1;i<samaaperakkain.length;i++){
            if(kirjaimet[i].equals(edellinen)){
                summat[i]=summat[i-1];
                apu++;
            }
            if(!kirjaimet[i].equals(edellinen)&&toka.equals("")){
                toka=edellinen;
                edellinen=kirjaimet[i];
                summat[i]=samaaperakkain[i-1];
                apu = 1;
            }
            if(kirjaimet[i].equals(toka)){
                summat[i]=summat[i-1]+apu;
                apu=1;
                toka = edellinen;
                edellinen = kirjaimet[i];
            }
            if(!kirjaimet[i].equals(edellinen)&&!kirjaimet[i].equals(toka)){
                edellinen = kirjaimet[i];
                toka = kirjaimet[i-1];
                summat[i]=samaaperakkain[i-1];
                apu = 1;
            }
        }
        long summa = 0;
        for(int i=0;i<summat.length;i++){
            summa+=summat[i];
        }
        
        return summa;
    }

    public static void main(String[] args) {
        TwoChar t = new TwoChar();
        System.out.println(t.count("aaaa")); // 0
        System.out.println(t.count("abab")); // 6
        System.out.println(t.count("aabacba")); // 8
    }
    
}
