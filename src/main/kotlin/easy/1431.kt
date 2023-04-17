package easy._1431

class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val maxCandies = candies.max()!!
        return List<Boolean>(candies.size) { i -> if (candies[i] + extraCandies >= maxCandies) true else false }
    }
}