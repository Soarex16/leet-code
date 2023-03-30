package medium._740

class Solution {
    fun deleteAndEarn(nums: IntArray): Int {
        val numPairs = mutableListOf(
            Pair(Int.MIN_VALUE, 0)
        )
        nums
            .asSequence()
            .groupingBy { it }
            .eachCount()
            .asSequence()
            .sortedBy { it.key }
            .map { Pair(it.key, it.value) }
            .toCollection(numPairs)

        val result = robHelper(numPairs)
        return result
    }

    // Hacky reuse of house robber task
    private fun robHelper(nums: List<Pair<Int, Int>>): Int {
        val n = nums.size
        val dp = arrayOf(
            IntArray(n + 1),
            IntArray(n + 1)
        )

        for (i in 2..n) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1])
            dp[1][i] = nums[i - 1].first * nums[i - 1].second + if (nums[i - 2].first + 1 == nums[i - 1].first) {
                dp[0][i - 1]
            } else {
                Math.max(dp[0][i - 1], dp[1][i - 1])
            }
        }

        return Math.max(dp[0][n], dp[1][n])
    }
}