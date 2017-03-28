public class ReviewProblem {

    public static int minimumLengthSubArray(int[] A, int desiredSum) {
        int minLen = 0 ;
        for (int i = 0; i < A.length; i++) {
            int currentSum = 0;
            int currentLen = 0;
            int j = i;
            while(j < A.length && currentSum < desiredSum){
                currentSum += A[j];
                currentLen++;
                j++;
            }
            if (currentSum >= desiredSum && (minLen == 0 || currentLen < minLen)) {
                minLen = currentLen;
            }
        }
        return minLen;
    }

}
