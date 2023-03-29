package easy._1

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val n = nums.size
        val map: MutableMap<Int, Int> = HashMap()
        val result = IntArray(2)
        for (i in 0 until n) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i
                result[0] = map[target - nums[i]]!!
                return result
            }
            map[nums[i]] = i
        }
        return result
    }
}