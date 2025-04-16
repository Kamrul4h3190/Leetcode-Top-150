import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        int n = 326;
        int n = 2;
        System.out.println(isHappy(n));
    }
    public static boolean isHappy(int n) {
        HashSet<Integer> sumset = new HashSet<>();
        while (n!=1 && !sumset.contains(n)){
            sumset.add(n);
            int sum=0,digit;
            while (n>0){
                digit = n%10;
                sum+= digit*digit;
                n/=10;
            }
            n=sum;
//            System.out.println(n);
        }
        return n==1;
    }

}

