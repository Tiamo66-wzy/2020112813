public class MaxSumOfSubArray {

    public int maxSum(int[] array) {

        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array is null or empty.");
        }

        int result = array[0], mark = 0;

        for (int i = 0; i < array.length; i++) {
            int element = array[i];

            if (mark >= 0) {
                mark += element;
            } else {
                mark = element;
            }

            if (mark > result) {
                result = mark;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxSumOfSubArray maxSumOfSubArray = new MaxSumOfSubArray();
        int maxSum = maxSumOfSubArray.maxSum(new int[]{1, -2, 3,-2, 5,1});
        System.out.println(maxSum);
    }
}