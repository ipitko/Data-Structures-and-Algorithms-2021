

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Iiris
 */
public class Sequence {

    /**
     * @param n
     * @return 
     */
    public String generate(int n) {
        if(n==1){
            return "1";
        }else if(n==2){
            return "11";
        }else{
            String apu = "11";
            String uusi = "";
            for(int i = 3; i <= n; i++){
                uusi="";
                apu = apu + "x"; // jotta saadaan looppi toimimaan
                char[] apu2 = apu.toCharArray();
                int maara = 1;
                for(int k = 1; k < apu.length(); k++){
                    if(apu2[k] != apu2[k-1]){
                        uusi = uusi + maara;
                        uusi = uusi + apu2[k-1];
                        maara=1;
                    }else{
                        maara++;
                    }
                }
                apu=uusi;
            }
            return uusi;
        }
    }

    public static void main(String[] args) {
        Sequence s = new Sequence();
        System.out.println(s.generate(1)); // 1
        System.out.println(s.generate(2)); // 11
        System.out.println(s.generate(3)); // 21
        System.out.println(s.generate(4)); // 1211
        System.out.println(s.generate(5)); // 111221
        System.out.println(s.generate(6)); // 312211
    }
    
}
