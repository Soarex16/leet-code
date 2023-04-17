package medium._55

class Solution {
    fun canJump(nums: IntArray): Boolean {
        val n = nums.size - 1
        var maxJump = 0
        var i = 0
        while (i <= maxJump) {
            maxJump = maxJump.coerceAtLeast(i + nums[i])
            if (maxJump >= n) return true
            i++
        }
        return false
    }
}
/**
i:    0 1 2 3 4 5 6 7
in:  [2 4 0 0 0 0 0 1]
max: [2 5 5 5 5 5 - -]
*/