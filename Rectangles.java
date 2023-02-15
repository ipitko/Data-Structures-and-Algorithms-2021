
import static java.lang.Math.abs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iiris
 */
public class Rectangles {

    public long area(int rec1[], int rec2[], int rec3[]) {
        int i = 0;
        
        long kokoAla=yhdenAla(rec1[0],rec1[1],rec1[2],rec1[3])+yhdenAla(rec2[0],rec2[1],rec2[2],rec2[3])+yhdenAla(rec3[0],rec3[1],rec3[2],rec3[3]);
        if(leikkaavatko(rec1,rec2)){
            int[] rec1rec2=kahdenLeikkaus(rec1,rec2);
            kokoAla-=yhdenAla(rec1rec2[0],rec1rec2[1],rec1rec2[2],rec1rec2[3]);
            i++;
        }
        if(leikkaavatko(rec1,rec3)){
            int rec1rec3[] = kahdenLeikkaus(rec1,rec3);
            kokoAla-= yhdenAla(rec1rec3[0],rec1rec3[1],rec1rec3[2],rec1rec3[3]);
            i++;
        }
        if(leikkaavatko(rec2,rec3)){
            int rec2rec3[] = kahdenLeikkaus(rec2,rec3);
            kokoAla-= yhdenAla(rec2rec3[0],rec2rec3[1],rec2rec3[2],rec2rec3[3]);
            i++;
        }
        if(i==3){
            int rec1rec2[] = kahdenLeikkaus(rec1,rec2);
            int rec1rec3[] = kahdenLeikkaus(rec1,rec3);
            int rec1rec2rec3[] = kahdenLeikkaus(rec1rec2,rec1rec3);
            kokoAla+= yhdenAla(rec1rec2rec3[0],rec1rec2rec3[1],rec1rec2rec3[2],rec1rec2rec3[3]);
        }
        return kokoAla;
    }
    
    public long yhdenAla(int x1, int y1, int x2, int y2){
        return abs(x2-x1)*abs(y2-y1);
    }
    
    public boolean leikkaavatko(int rec1[], int rec2[]){
        boolean apu=true;
        if(rec1[2]<rec2[0]||rec2[2]<rec1[0]){
            apu=false;
        }
        if(rec1[1]<rec2[3]||rec2[1]< rec1[3]){
            apu=false;
        }
        return apu;
    }
    
    public int[] kahdenLeikkaus(int rec1[], int rec2[]){
        int suurempix1=Math.max(rec1[0], rec2[0]);
        int suurempiy2=Math.max(rec1[3], rec2[3]);
        int pienempix2=Math.min(rec1[2], rec2[2]);
        int pienempiy1=Math.min(rec1[1], rec2[1]);

        int x1 = suurempix1;
        int y1 = pienempiy1;
        int x2 = pienempix2;
        int y2 = suurempiy2;
        
        int[] suorakulmio = {x1,y1,x2,y2};
        
        return suorakulmio;
    }
    
    public static void main(String[] args) {
        Rectangles r = new Rectangles();
        int[] rec1 = {-1,1,1,-1};
        int[] rec2 = {0,3,2,0};
        int[] rec3 = {0,2,3,-2};
        System.out.println(r.area(rec1,rec2,rec3)); // 16
    }
}
