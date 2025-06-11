class App {
    public static void main(String[] args) {
        App app = new App();
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int target = 3;
        int[][] matrix = {{2}};
        int target = 1;
        System.out.println("row search : "+app.searchRow(matrix,target));
        System.out.println("matrix search : "+app.searchMatrix(matrix,target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {//double binary search
        int row = searchRow(matrix,target);
        if (row<matrix.length)
            return searchInsert(matrix[row],target );
        return false;
    }
//    public boolean searchMatrix(int[][] matrix, int target) {//single binary search
//        for (int[] row :matrix) {
//            if (target<=row[row.length-1] && searchInsert(row,target)) return true;
//        }
//        return false;
//    }
    private boolean searchInsert(int[] nums, int target) {
        int start = 0,end = nums.length-1;

        while (end>=start){//breaks when end becomes less than start
            int middle = (start+end)/2;
            if (nums[middle]==target) return true;

            if(target>nums[middle]) start = middle+1;
            else end = middle-1;
        }

        return false;
    }
    public int searchRow(int[][] matrix, int target) {
        int start = 0,end = matrix.length-1;

        while (end>=start){//breaks when end becomes less than start
            int middle = (start+end)/2;
            if (matrix[middle][matrix[middle].length-1]==target) return middle;

            if(target>matrix[middle][matrix[middle].length-1]) start = middle+1;
            else end = middle-1;
        }

        return start;
    }


}
