package medium._198

class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        val dp = arrayOf(
            IntArray(n + 1),
            IntArray(n + 1)
        )

        dp[0][0] = 0
        dp[1][0] = 0

        for (i in 1..n) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1])
            dp[1][i] = nums[i - 1] + dp[0][i -1]
        }

        return Math.max(dp[0][n], dp[1][n])
    }
}