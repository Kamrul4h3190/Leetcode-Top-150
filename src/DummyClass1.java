import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {

        int [] citations = {3,0,6,1,5};
//        int [] citations = {1,2,1};
        int h_index = hIndex(citations);
        System.out.println("h_index : "+ h_index);

    }

    public static int hIndex(int[] citations) {
        int [] bucket = new int[citations.length+1];
        for (int citation : citations) {
            if (citation > citations.length)
                bucket[bucket.length - 1]++;
            else
                bucket[citation]++;
        }

        int count = 0;
        for (int i = bucket.length-1; i >=0 ; i--) {
            count+=bucket[i];
            if (count>=i) return i;
        }

        return 0;
    }

}
