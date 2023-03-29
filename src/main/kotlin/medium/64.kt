package medium._64

class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val dp = Array(rows) { IntArray(cols) }
        dp[0][0] = grid[0][0]
        for (r in 1 until rows) {
            dp[r][0] = dp[r - 1][0] + grid[r][0]
        }
        for (c in 1 until cols) {
            dp[0][c] = dp[0][c - 1] + grid[0][c]
        }
        for (r in 1 until rows) {
            for (c in 1 until cols) {
                dp[r][c] = grid[r][c] + Math.min(dp[r][c - 1], dp[r - 1][c])
            }
        }

        return dp[rows - 1][cols - 1]
    }
}