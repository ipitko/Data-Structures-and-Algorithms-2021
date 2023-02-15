
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class NewRoads {
    private ArrayList<Edge> edges;
    private int[] parents;
    private ArrayList<Subset> subsets;
    private int mincost;
    public NewRoads(int n) {
        this.edges=new ArrayList<>();
        this.parents=new int[n];
        this.subsets=new ArrayList<>();
        this.mincost=0;
        for(int i=0;i<n;i++){
            subsets.add(new Subset(i+1));
        }
        for(int i=0;i<n;i++){
            parents[i]=i+1;
        }
    }

    public void addRoad(int a, int b, int x) {
        edges.add(new Edge(a,b,x));
    }
    
    public int find(int x){
        while(x!=parents[x-1]){
            x=parents[x-1];
        }
        return x;
    }
    public void union(int a, int b){
        a=find(a);
        b=find(b);
        if(subsets.get(a-1).size<subsets.get(b-1).size){
            parents[a-1]=b;
            subsets.get(b-1).size=(subsets.get(b-1).size+subsets.get(a-1).size);
        }else{
            parents[b-1]=a;
            subsets.get(a-1).size=(subsets.get(b-1).size+subsets.get(a-1).size);
        }
    }

    public int minCost() {
        for(int i=0;i<parents.length;i++){
            parents[i]=i+1;
        }
        mincost=0;
        Collections.sort(edges);
        for (Edge e : edges) {
            if(find(e.alku)!=find(e.loppu)){
                mincost+=e.paino;
                union(e.alku,e.loppu);
            }
        }
        int count=0;
        HashSet<Integer> apu=new HashSet<>();
        for(int i=1;i<parents.length+1;i++){
            if(!apu.contains(find(i))){
                apu.add(find(i));
                count++;
            }
        }
        if(count>1){
            return -1;
        }else{
            return mincost;
        }
    }

    public static void main(String[] args) {
        NewRoads n = new NewRoads(4);
        n.addRoad(1,2,2);
        n.addRoad(1,3,5);
        System.out.println(n.minCost());
        n.addRoad(3,4,4);
        System.out.println(n.minCost()); // 11
        n.addRoad(2,3,1);
        System.out.println(n.minCost()); // 7
    }
}
class Edge implements Comparable<Edge>{
    int alku;
    int loppu;
    int paino;
    public Edge(int a,int b, int x){
        this.alku=a;
        this.loppu=b;
        this.paino=x;
    }
    
//    public String toString(){
//        return "("+alku+","+loppu+")"+paino;
//    }

    @Override
    public int compareTo(Edge e) {
        if(this.paino==e.paino){
            return 0;
        }else if(this.paino>e.paino){
            return 1;
        }else{
            return -1;
        }
    }
}
class Subset{
    int parent;
    int size;
    public Subset(int parent){
        this.parent=parent;
        this.size=0;
    }
}