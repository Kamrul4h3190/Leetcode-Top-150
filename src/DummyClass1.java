import java.util.HashMap;
import java.util.HashSet;

public class DummyClass1 {
    public static void main(String[] args) {
//        String s =  "abcabcbb";
//        String s = "cadbzabcd";
        String s =  " ";
//        String s =  "au";
//        String s =  "dvdf";
//        String s = "pwwkew";
        int len = lengthOfLongestSubstring(s);
        System.out.println("len : "+len);
    }
    public static int lengthOfLongestSubstring(String s) {
        int length = 0,left = 0,right=0,n=s.length();
        HashMap<Character,Integer> positionMap = new HashMap<>();

        while (right<n){
            Character curr = s.charAt(right);
            if (!positionMap.containsKey(curr)){
                positionMap.put(curr,right);
            }else {
                int position = positionMap.get(curr);
                if (position >= left){left=position+1;}
                positionMap.put(curr,right);
            }
            right++;
            length = Math.max(length,right-left);
        }
        return length;
    }
}

