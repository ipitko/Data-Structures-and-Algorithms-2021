
public class Subtrees {
    public int[] apu(Node node){
        if(node==null){
            return new int[] {0,0};
        }
        int[] vasen = apu(node.left);
        int[] oikea = apu(node.right);
        
    }

    public int diff(Node node) {
        int max = 0;
        for(int i=1;i<apu(node).length;i++){
            max=Math.max(apu(node)[i], apu(node)[i-1]);
        }
        return max;
    }

    public static void main(String[] args) {
        Subtrees s = new Subtrees();
        Node tree = new Node(null,
                             new Node(new Node(null,null),
                                      new Node(null,null)));
        System.out.println(s.diff(tree)); // 3
    }
    
}
