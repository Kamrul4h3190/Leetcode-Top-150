import java.util.*;

public class TestClass {

    int[][] adjList =   {{2,4},{1,3},{2,4},{1,3}};
    Node[]  nodes = new Node[adjList.length+1];

    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        int[][] adjList =   {{2,4},{1,3},{2,4},{1,3}};
        Node[]  nodes = new Node[adjList.length+1];
        for (int i = 1; i <= adjList.length; i++) {
            nodes[i] = new Node(i);
        }

        Map<Node,List<Node>> graph = testClass.buildGraph(adjList,nodes);
        Node node = nodes[1];
        Node clone = testClass.cloneGraph(node);
//        testClass.showGraph(graph);
    }
    public Node cloneGraph(Node node) {
        if (node==null) return null;
        Map<Node,Node> map = new HashMap<>();
        return dfs(node,map);
    }
    private Node dfs(Node node,Map<Node,Node> map){

        if (map.containsKey(node)) return map.get(node);
        map.put(node,new Node(node.val));

        for (Node neighbor : node.neighbors ) {
            Node clone = dfs(neighbor,map);
            map.get(node).neighbors.add(clone);
        }
        return map.get(node);
    }
    private Map<Node,List<Node>> buildGraph(int[][] adjList,Node[] nodes){
        Map<Node,List<Node>> graph = new HashMap<>();
        for (int i = 0; i < adjList.length; i++) {
            Node key = nodes[i+1];
            List<Node> neighbors = new ArrayList<>();
            for (int neighbor : adjList[i]) {
                neighbors.add(nodes[neighbor]);
            }
            key.neighbors = neighbors;
            graph.put(key,neighbors);
        }

        return graph;
    }

    private void showGraph(Map<Node,List<Node>> graph){
        for (Node key : graph.keySet()){
            System.out.print(key.val+" : ");
            for (Node neighbor : graph.get(key)) {
                System.out.print(neighbor.val+" ");
            }
            System.out.println();
        }
    }
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}