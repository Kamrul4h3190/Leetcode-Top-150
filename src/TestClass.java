import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
//        int numCourses = 3;
//        int[][] prerequisites = {{1,0},{0,2},{2,1}};
//        int numCourses = 20;
//        int[][] prerequisites = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        int numCourses = 5;
//        int[][] prerequisites = {{1,0},{1,2},{3,2},{4,3},{2,4}}; // cycle
        int[][] prerequisites = {{1,0},{1,2},{3,2},{3,4},{2,4}}; // 4 2 3 0 1
//        int numCourses = 4;
//        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//        int numCourses = 1;
//        int[][] prerequisites = {};
//        System.out.println("canFinish : "+testClass.canFinish(numCourses,prerequisites));

        List<List<Integer>> graph = testClass.buildGraph(prerequisites,numCourses);
        testClass.showGraph(graph);
//        System.out.println(graph);
        System.out.println("findOrder : "+ Arrays.toString(testClass.findOrder(numCourses, prerequisites)));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 1) return new int[]{0};

        List<List<Integer>> graph = buildGraph(prerequisites, numCourses);

        int [] visited = new int[numCourses];
        return findTopoOrder(graph,visited);
    }
    public int[] findTopoOrder(List<List<Integer>> graph, int[] visited){
        ArrayDeque<Integer> queue = new ArrayDeque<>(graph.size());
        for (int i = 0; i < graph.size(); i++) {
            if (!dfs(i,graph,queue,visited)) return new int[]{};
        }
        int[] order = new int[visited.length];
        for (int i = 0; i < order.length; i++) {
            order[i] = queue.pollFirst();
        }
        return order;
    }
    public boolean dfs(int i, List<List<Integer>> graph,ArrayDeque<Integer> queue, int[] visited){
        if (visited[i]==2) return true;
        if (visited[i]==1) return false;
        visited[i] = 1;//started traversing
        List<Integer> adjNodes = graph.get(i);

        for (int adjNode: adjNodes){
            if(!dfs(adjNode,graph,queue,visited)) return false;
        }
        if(visited[i]!=2) queue.offerFirst(i);
        visited[i] = 2;//finished traversing all neighbors
        return true;
    }
    public List<List<Integer>> buildGraph(int[][] prerequisites,int numCourses){
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        return graph;
    }

    public void showGraph(List<List<Integer>> graph){
        for (int i=0;i<graph.size(); i++){
            System.out.print(i+" : ");
            for (int adjacent :graph.get(i)) {
                System.out.print(adjacent+"->");
            }
            System.out.println();
        }
    }

}
