import java.util.ArrayList;
import java.util.HashMap;


class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet  rs = new RandomizedSet();
        rs.insert(5);
        rs.insert(4);
        rs.insert(3);
        rs.insert(6);
        rs.insert(7);
        rs.remove(3);

        System.out.println(rs.indexMap);
    }

    HashMap<Integer,Integer> indexMap;
    ArrayList<Integer> nums;
    java.util.Random rand = new java.util.Random();

    public RandomizedSet() {
        indexMap = new HashMap<>();
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
//            System.out.println("insertion : false");
            return false;
        }
        nums.add(val);
        indexMap.put(val,nums.size()-1);
//        System.out.println("insertion : true");
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)){
//            System.out.println("deletion : false");
            return false;
        }
        int location = indexMap.get(val);
        int lastElement = nums.get(nums.size() - 1),n=nums.size();
        nums.set(location, lastElement);
        indexMap.put(lastElement,location);
        indexMap.remove(val);
        nums.remove(n-1);
//        System.out.println("deletion : true");
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

//public class DummyClass1 {
//    public static void main(String[] args) {
//
//        int [] citations = {3,0,6,1,5};
////        int [] citations = {1,2,1};
//        int h_index = hIndex(citations);
//        System.out.println("h_index : "+ h_index);
//
//    }
//
//    public static int hIndex(int[] citations) {
//        int [] bucket = new int[citations.length+1];
//        for (int citation : citations) {
//            if (citation > citations.length)
//                bucket[bucket.length - 1]++;
//            else
//                bucket[citation]++;
//        }
//
//        int count = 0;
//        for (int i = bucket.length-1; i >=0 ; i--) {
//            count+=bucket[i];
//            if (count>=i) return i;
//        }
//
//        return 0;
//    }
//
//}
