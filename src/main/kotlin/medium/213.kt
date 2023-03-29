package medium._213

class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        return if (n > 1) {
            val x1 = robSimple(nums.copyOfRange(0, n - 1))
            val x2 = robSimple(nums.copyOfRange(1, n))
            Math.max(
                x1,
                x2
            )
        } else {
            nums[0]
        }
    }

    private fun robSimple(nums: IntArray): Int {
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