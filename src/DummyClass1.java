import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {

//        int[] ratings = {1,2,4,2,1};
//        int[] ratings = {1,2,3,3,1,2,1};
//        int[] ratings = {1,3,2,2,1};
//        int[] ratings = {1,2,5,7,8,4,2,5,2,2};
//        int[] ratings = {1,0,2};
//        int[] ratings = {1,2,2};
        int[] ratings = {0,2,4,7,6,5,4,3,2,1,1,1,2,3,4,2,1,1,1};
        int candy = candy2(ratings);
        System.out.println("candy :"+candy);
    }

    //time-o(n), space-o(1)
    public static int candy2(int[] ratings) {
        int n=ratings.length,candies=1;
        int i=1;
        while (i < n) {
            int up=1,down=0;
            if (ratings[i]==ratings[i-1]){
                i++;
                candies++;
                continue;
            }
            while (i<n && ratings[i]>ratings[i-1]){
                up++;
                candies+=up;
                i++;
            }
            while (i<n && ratings[i]<ratings[i-1]){
                down++;
                candies+=down;
                i++;
            }
            down++;
//            System.out.println("up,down:"+up+","+down);
            if ( down>up){
                candies+= down-up;
            }
        }
        return candies;
    }

    //time-o(n), space - o(n)
    public static int candy(int[] ratings) {
        int n=ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);

        for (int i = 1; i < n; i++) {
            if (ratings[i]>ratings[i-1] && candies[i]<=candies[i-1])
                candies[i] = candies[i-1]+1;
        }
        System.out.println(Arrays.toString(candies));

        for (int i = n-2; i >=0 ; i--) {
            if (ratings[i]>ratings[i+1] && candies[i]<=candies[i+1])
                candies[i] = candies[i+1]+1;
        }
        System.out.println(Arrays.toString(candies));

        return Arrays.stream(candies).sum();
    }
}
