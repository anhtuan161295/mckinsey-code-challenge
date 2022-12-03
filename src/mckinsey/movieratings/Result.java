package mckinsey.movieratings;

public class Result {

    // Complete the maximizeRatings function below.
    // https://leetcode.com/discuss/interview-question/499867/maximal-movie-ratings
    // The question is vague and sample cases are ambiguous, however there are some key points:
    // Let's say Alexa select the first number, Alexa can select the second number (consecutive number) or skip it and select the third number
    // it is similar to another question when the user can walk 1 step or 2 step at a time.
    // the maximum rating formula will be: sum = max(dp[i -1], dp[i - 2])
    // we also need to compare the maximum rating between each index
    // the last element in dp array will be the maximum ratings

    static int maximizeRatingsV2(int[] ratings) {
        // dp[i][0] is the previous maximum ratings, dp[i][1] is the current maximum ratings
        int[][] dp = new int[ratings.length + 1][2];
        dp[1][1] = ratings[0];

        // we use <= because we need last rating number for the final result
        for (int i = 2; i <= ratings.length; i++) {
            dp[i][0] = dp[i - 1][1];

            int max = Math.max(dp[i - 1][0], dp[i - 1][1]); // compare the maximum value from previous result
            max = Math.max(max, dp[i - 2][1]); // compare the case when last consecutive number is skipped
            max += ratings[i - 1];
            dp[i][1] = max;
        }

        int result = Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
        return result;
    }

    // https://leetcode.com/discuss/interview-question/499867/maximal-movie-ratings
    static int maximizeRatings(int[] ratings) {
        int[][] dp = new int[ratings.length + 1][2];  // 0 is for non-skip case, 1 is the current maximum number;
        dp[1][1] = ratings[0];
        for (int i = 2; i <= ratings.length; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = Math.max(dp[i - 2][1], Math.max(dp[i - 1][1], dp[i - 1][0])) + ratings[i - 1];
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }

    public static void main(String[] args) {
        int result = maximizeRatingsV2(new int[]{9, -1, -3, 4, 5}); // 17
        System.out.println(result);

        int result2 = maximizeRatingsV2(new int[]{-1, -2, -3, -4, -5}); // -6
        System.out.println(result2);
    }


}
