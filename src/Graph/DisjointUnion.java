package Graph;

public class DisjointUnion {
    int parent[];
    int size[];
    int vertices;
    DisjointUnion(int vertices){
        this.vertices = vertices;
        parent = new int[vertices];
        size = new int[vertices];
        for (int i=0; i<vertices; i++) {
            //-1 because array cannot have negative index, 0 can be an index
            parent[1] = -1;
        }
    }
    public int isCycleDetected(int u, int v){
        int uAbsRoot = find(u);
        int vAbsRoot = find(v);
        if(uAbsRoot == vAbsRoot){
            System.out.println("Cycle detected");
            return 1;
        }
        union(uAbsRoot, vAbsRoot);
        return 0;
    }
    public int find(int vertex){
        if(parent[vertex] == -1){
            return vertex;
        }
        return parent[vertex] = find(parent[vertex]);
    }
    public void union(int uabsroot, int vasbroot){
        if(size[uabsroot] == size[vasbroot]){
            parent[uabsroot] = vasbroot;
            size[vasbroot]++;
        } else if (size[uabsroot]>size[vasbroot]) {
            parent[vasbroot] = uabsroot;
        }
        else {
            parent[uabsroot] = vasbroot;
        }
    }

    public static void main(String[] args) {
        DisjointUnion disjointUnion = new DisjointUnion(4);
        System.out.println(disjointUnion.isCycleDetected(0,1));
        System.out.println(disjointUnion.isCycleDetected(1,2));
        System.out.println(disjointUnion.isCycleDetected(2,0));
    }
}
