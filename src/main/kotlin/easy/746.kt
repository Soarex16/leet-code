package easy._746

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        val dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 0
        for (i in 2..n) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        }

        return dp[n]
    }
}