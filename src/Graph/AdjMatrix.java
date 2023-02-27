package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AdjMatrix {
    int vertices;
    int matrix[][];

    //for minimum spanning tree;
    Edge [] edge;
    AdjMatrix(int vertices){
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
        edge = new Edge[vertices];
        //no need to populate with 0 java already sets it as 0;
    }
    public void addEdge(int source, int destination){
        //if weight exists than take it as parameter and than assign the weight in the matrix
        //matrix[source][destination] = w;
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }
    public void printGraph() {
        for (int row = 0; row < vertices; row++) {
            System.out.print(row + " is connected to ");
            for (int column = 0; column < vertices; column++){
                if(matrix[row][column]!=0){
                    System.out.print(column+" , ");
                }
            }
            System.out.println("");
        }
    }
    List<Integer> getAdjNode(int vertex){
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < vertices; j++){
            if(matrix[vertex][j]!=0){
               list.add(j);
            }
        }
        return list;
    }
    public void BFS(int source){
        boolean visited[] = new boolean[vertices];
        Queues queue = new Queues(vertices);
        queue.enqueue(source);
        visited[source] = true;
        while (!queue.isEmpty()){
            int value = queue.dequeue();
            System.out.println("Visited Node "+value);
//            iterating using java's function
            Iterator<Integer> iterator = getAdjNode(value).iterator();
            while (iterator.hasNext()){
                int adjVal = iterator.next();
                if(!visited[adjVal]){
                    queue.enqueue(adjVal);
                    visited[adjVal]=true;
                }
            }
//            iterating using for loop
//            List<Integer> list = getAdjNode(value);
//            for (int i =0; i<list.size(); i++){
//                list.get(i);
//            }
        }
    }
    //recursion
    //do linear by yourself

    //2 seperate functions of dfs are made as the visited array need to be made only once
    public void DepthFirstSearch(int source){
        boolean visited[] = new boolean[vertices];
        visited[source] = true;
        DFS(source,visited);
    }
    public void DFS(int source, boolean[] visited){
        System.out.println(source);
        Iterator<Integer> iterator = getAdjNode(source).iterator();
        while (iterator.hasNext()){
            int adjVal = iterator.next();
            if(!visited[adjVal]){
                DFS(adjVal, visited);
            }
        }
    }
    public void dijskstra(int source){
        int distance[] = new int[vertices];
        int prevPath[] = new int[vertices];
        boolean visited[] = new boolean[vertices];

        for (int i=0; i<vertices; i++){
            distance[i] = Integer.MAX_VALUE;
            prevPath[i] = -1;
            visited[i] = false;
        }
        //distance of source to source is 0
        distance[source] = 0;

        for (int i=0; i<vertices; i++){
            int minVertex = findMinVertex(distance, visited);
            for (int j = 0; j<vertices; j++){
                if(matrix[minVertex][j] != 0 && !visited[j]){
                    if(distance[minVertex] + matrix[minVertex][j] < distance[j])
                    {
                        distance[j] = distance[minVertex] + matrix[minVertex][j];
                        prevPath[j] = minVertex;
                    }
                }
            }
        }

    }

    public int findMinVertex(int[] distance, boolean[] visited){
        int minVertex = -1;
        for (int i=0; i<distance.length; i++){
            if (!visited[i] && (minVertex == -1 || distance[minVertex] > distance[i])){
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static class  Edge implements Comparable<Edge>{
        int u;
        int v;
        int w;

        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w = o.w;
        }
    }

    int edgeindex = -1;
    public void addEdge(int source, int destination,int w){
        edge[++edgeindex] = new Edge(source,destination,w);
    }

    //mst
    //just define only this in the exams
    public void KruskalAlgorithmMST(){
        Arrays.sort(edge);
        Edge mst[] = new Edge[vertices-1];   //vertices -1 so that we dont have a connected graph

        int parent[] = new int[vertices];
        int size[] = new int[vertices];
        for (int  i =0; i<vertices; i++){
            parent[i] = -1;
        }
        int edgeTaken = 1;
        int edgeIndex = -1;
        int mstIndex = -1;

        while (edgeTaken<vertices){
            Edge e = edge[++edgeIndex];
            int uAbsRoot = find(e.u, parent);
            int vAbsRoot = find(e.v, parent);
            if (uAbsRoot == vAbsRoot){
                continue;
            }
            mst[++mstIndex] = e;
            edgeTaken++;
            union(uAbsRoot,vAbsRoot,size,parent);
        }

        //print mst; use for loop
        //or return mst
    }
    public int find(int vertex, int parent[]){
        if(parent[vertex] == -1){
            return vertex;
        }
        return parent[vertex] = find(parent[vertex],parent);
    }
    public void union(int uabsroot, int vasbroot, int[] size, int[] parent){
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

    //mst
    //for prims algo
    public void prims(int source){
        int key[]=new int[vertices];
        boolean mstset[]=new boolean[vertices];
        int mst[]=new int[vertices];
        for(int i=0;i<vertices;i++){
            mst[i]=-1;
            key[i]=Integer.MAX_VALUE;
        }
        key[source]=0;
        for(int i=1;i<vertices;i++){
            int minvertex=findMinVertex(key,mstset);
            mstset[minvertex]=true;
            for (int j=0; j<vertices; j++){
                if (matrix[minvertex] [j]!=0){
                    if (matrix[minvertex][j]<key[j]&& !mstset[j]){
                        key[j] = matrix[minvertex][j];
                        mst[j] = minvertex;
                    }
                }
            }
        }
        //print mst
    }

    public void topologicalSorting(int[][] matrix, int vertices){
        int indegree[]=new int[vertices];
        Queues queue = new Queues(vertices);

        for (int i=0; i<vertices; i++){
            for (int j=0; j<vertices; j++) {
                if (matrix[i][j] != 0) {
                    indegree[j]++;
                }
            }
        }
        for (int i=0; i<vertices;i++){
            if (indegree[i]==0){
                queue.enqueue(i);
            }
        }
        while (!queue.isEmpty()){
            int value=queue.dequeue();
            System.out.println(value);
            for (int j=0; j<vertices;j++){
                if (matrix[value][j]!=0){
                    indegree[j]--;
                    if (indegree[j]==0){
                        queue.enqueue(j);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        AdjMatrix adj = new AdjMatrix(4);
        adj.addEdge(0,1);
        adj.addEdge(0,2);
        adj.addEdge(1,2);
        adj.addEdge(2,3);
        adj.printGraph();
        adj.BFS(0);
    }
}
