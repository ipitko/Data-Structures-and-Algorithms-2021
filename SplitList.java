
public class SplitList {

    public int count(int[] t) {
        int maara=0;
        long[] maxVasen =  new long[t.length];
        maxVasen[0]=t[0];
        for(int i = 1;i<t.length;i++){
            if(t[i]>maxVasen[i-1]){
                maxVasen[i]=t[i];
            }else{
                maxVasen[i]=maxVasen[i-1];
            }
        }

        long[] minOikea = new long[t.length];
        minOikea[t.length-1]=t[t.length-1];
        for(int i = t.length-2; i>=0;i--){
            if(t[i]<minOikea[i+1]){
                minOikea[i]=t[i];
            }else{
                minOikea[i]=minOikea[i+1];
            }
            
        }
        
        for(int i=1;i<t.length;i++){
            if(maxVasen[i-1]<minOikea[i]){
                maara++;
            }
        }
        return maara;
    }
    

    public static void main(String[] args) {
        SplitList s = new SplitList();
//        System.out.println(s.count(new int[] {1,2,3,4,5})); // 4
//        System.out.println(s.count(new int[] {5,4,3,2,1})); // 0
//        System.out.println(s.count(new int[] {2,1,2,5,7,6,9})); // 3
//        System.out.println(s.count(new int[] {5,6,6,7,8,10,3})); // 0
//        System.out.println(s.count(new int[] {2,1,2,6,3,4,9,12})); // 3
//        System.out.println(s.count(new int[] {2, 3, 1, 3})); //0
        System.out.println(s.count(new int[] {7, 3, 1, 3, 6})); //0
        
    }
    
}
