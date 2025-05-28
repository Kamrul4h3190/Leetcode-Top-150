import java.util.*;

public class TestClass {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        String startGene = "AACCGGTT", endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};

        System.out.println("minMoves : "+testClass.minMutation(startGene,endGene,bank));
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        int level = 0;
        HashSet<String> bankSet = new HashSet<>(List.of(bank));

        Queue<String> queue = new LinkedList<>(); HashSet<String> visited = new HashSet<>();
        queue.offer(startGene); visited.add(startGene);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endGene)) return level;
                
                for (char gene : "ACGT".toCharArray()) {
                    for (int s = 0; s < 8; s++) {
                        char[] currCharArray = curr.toCharArray();
                        if(currCharArray[s]!=gene){
                            currCharArray[s] = gene;
                            String next = new String(currCharArray);
                            if (!visited.contains(next) && bankSet.contains(next)){
                                queue.add(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
