package medium._45

class Solution {
    fun jumpExplicitMemo(nums: IntArray): Int {
        fun <TArg, TRes> memo(fn: (TArg) -> TRes): (TArg) -> TRes {
            val cache = mutableMapOf<TArg, TRes>()
            return {
                cache.getOrPut(it) { fn(it) }
            }
        }

        val n = nums.size - 1
        var minJumps: (Int) -> Int = { 42 }
        minJumps = memo<Int, Int> { pos ->
            if (pos >= n) return@memo 0 // we are not interested to jump over N

            val jumpSize = nums[pos]
            if (pos + jumpSize >= n) return@memo 1 // can jump to N with 1 jump - recursion base

            var minValue = Int.MAX_VALUE - 1
            for (i in pos + 1..pos + jumpSize) {
                minValue = minValue.coerceAtMost(minJumps(i))
            }

            return@memo minValue + 1
        }

        return minJumps(0)
    }

    fun jump(nums: IntArray): Int {
        // dp[i] = min jumps to reach end from i
        val dp = IntArray(nums.size) { Int.MAX_VALUE }
        val n = nums.size - 1
        fun minJumps(pos: Int) : Int {
            if (pos >= n) return 0 // we are not interested to jump over N

            if (dp[pos] < Int.MAX_VALUE) return dp[pos]
            val jumpSize = nums[pos]
            if (pos + jumpSize >= n) return 1 // can jump to N with 1 jump - recursion base

            var minValue = Int.MAX_VALUE - 1
            for (i in pos + 1..pos + jumpSize) {
                minValue = minValue.coerceAtMost(minJumps(i))
            }

            dp[pos] = minValue + 1
            return minValue + 1
        }

        return minJumps(0)
    }
}