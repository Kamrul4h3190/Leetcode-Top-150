import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(List.of("a","b")));equations.add(new ArrayList<>(List.of("b","c")));equations.add(new ArrayList<>(List.of("bc","cd")));
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(List.of("a","c")));queries.add(new ArrayList<>(List.of("c","b")));queries.add(new ArrayList<>(List.of("bc","cd")));queries.add(new ArrayList<>(List.of("cd","bc")));
        double[] values = {1.5,2.5,5.0};


//        testClass.showGraph(testClass.buildGraph(equations,values));
        System.out.println("query results : "+ Arrays.toString(testClass.calcEquation(equations,values,queries)));
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, Map<String, Double>> graph = buildGraph(equations,values);

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0), dest = queries.get(i).get(1);
            result[i] = dfs(src , dest , new HashSet<>(), graph);
        }
        return result;
    }
    public double dfs(String src, String dest, Set<String> visited, Map<String, Map<String, Double>> graph){
        if(!graph.containsKey(src )) return -1.0;
        if (src.equals(dest)) return 1.0;

        visited.add(src);
        for (Map.Entry<String, Double> adjacent : graph.get(src).entrySet()) {
            if (!visited.contains(adjacent.getKey())){
                double cost = dfs(adjacent.getKey(),dest,visited,graph);
                if (cost!=-1) return cost* adjacent.getValue();
            }
        }
        return -1.0;
    }

    public Map<String,Map<String,Double>> buildGraph(List<List<String>> equations,double[] values){
        Map<String,Map<String,Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);

            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1/values[i]);

        }
        return graph;
    }

    public void showGraph(Map<String,Map<String,Double>> graph){
        for (String key : graph.keySet()) {
            System.out.print(key+" : ");System.out.print(graph.get(key));
            System.out.println();
        }
    }

}
//# Using DFS
//private  Map<String, Map<String, Double>> makeGraph(List<List<String>> e, double[] values){
//        // build a graph
//        // like a -> b = values[i]
//        // and b -> a  = 1.0 / values[i];
//        Map<String, Map<String, Double>> graph = new HashMap<>();
//        String u, v;
//
//        for(int i = 0; i < e.size(); i++){
//        u = e.get(i).get(0);
//        v = e.get(i).get(1);
//
//        graph.putIfAbsent(u, new HashMap<>());
//        graph.get(u).put(v, values[i]);
//
//        graph.putIfAbsent(v, new HashMap<>());
//        graph.get(v).put(u, 1/values[i]);
//
//        }
//        return graph;
//        }
//
//public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        Map<String, Map<String, Double>> graph = makeGraph(equations, values);
//
//        double []ans = new double[queries.size()];
//
//        // check for every Querie
//        // store it in ans array;
//        for(int i = 0; i < queries.size(); i++){
//        ans[i] = dfs(queries.get(i).get(0) , queries.get(i).get(1) , new HashSet<>(), graph);
//        }
//        return ans;
//        }
//
//public double dfs(String src, String dest, Set<String> visited, Map<String, Map<String, Double>> graph){
//        // check the terminated Case
//        // if string is not present in graph return -1.0;
//        // like [a, e] or [x, x] :)
//        if(graph.containsKey(src ) == false)
//        return -1.0;
//
//        // simply say check src and dest are equal :) then return dest
//        // store it in weight varaible;
//        //case like [a,a] also handle
//        if(graph.get(src).containsKey(dest)){
//        return graph.get(src).get(dest);
//        }
//
//        visited.add(src);
//
//        for(Map.Entry<String, Double> nbr : graph.get(src).entrySet()){
//        if(visited.contains(nbr.getKey()) == false){
//        double weight = dfs(nbr.getKey(), dest, visited, graph);
//
//        // if weight is not -1.0(terminate case)
//        // then mutliply it
//        // like in querie   a -> c => 2 * 3 = 6
//        if(weight != -1.0){
//        return nbr.getValue() * weight;
//        }
//        }
//        }
//        return -1.0;
//        }