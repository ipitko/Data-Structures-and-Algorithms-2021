
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Network {
    private ArrayList<ArrayList<Integer>> networks;
    public Network(int n) {
        this.networks = new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<=n;i++){
            networks.add(new ArrayList<Integer>());
        }
    }

    public void addLink(int a, int b) {
        networks.get(a).add(b);
        networks.get(b).add(a);
    }

    public int bestRoute(int a, int b) {
        boolean[] visited = new boolean[networks.size()];
        ArrayDeque<Integer> jono = new ArrayDeque<>();
        int[] distance = new int[networks.size()];
        bfs(a,b,visited,jono,distance);
        if(distance[b]==0){
            return -1;
        }else{
            return distance[b];
        }
    }
    
    public void bfs(int a, int b, boolean[] visited,ArrayDeque<Integer> jono,int[] distance){
        jono.addLast(a);
        visited[a]=true;
        distance[a]=0;
        while(!jono.isEmpty()){
            int node = jono.removeLast();
            for(int i=0;i<networks.get(node).size();i++){
                if(!visited[networks.get(node).get(i)]){
                    jono.addFirst(networks.get(node).get(i));
                    visited[networks.get(node).get(i)]=true;
                    distance[networks.get(node).get(i)]=distance[node]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Network w = new Network(5);
        w.addLink(1,2);
        w.addLink(2,3);
        w.addLink(1,3);
        w.addLink(4,5);
        System.out.println(w.bestRoute(1,5)); // -1
        w.addLink(3,5);
        System.out.println(w.bestRoute(1,5)); // 2
    }
}