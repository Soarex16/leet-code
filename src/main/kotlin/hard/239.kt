package hard._239

import java.util.*

class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        assert(nums.size >= k)
        val q = LinkedList<Int>()
        val n = nums.size

        fun addToQueue(x: Int) {
            while (!q.isEmpty() && q.last < x) {
                q.removeLast()
            }

            q.addLast(x)
        }

        for (i in 0 until k - 1) {
            addToQueue(nums[i])
        }

        val result = IntArray(n - k + 1)
        for (i in k - 1 until n) {
            addToQueue(nums[i])
            result[i - k + 1] = q.first
            if (nums[i - k + 1] == q.first) {
                q.removeFirst()
            }
        }

        return result
    }
}