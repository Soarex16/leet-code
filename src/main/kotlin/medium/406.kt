package medium._406

class Solution {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        val result = arrayOfNulls<IntArray>(people.size)
        val sortedPeople = people.sortedWith(object : Comparator<IntArray> {
            override fun compare(a: IntArray, b: IntArray): Int {
                val cmp0 = a[0] - b[0]
                return if (cmp0 == 0) {
                    a[1] - b[1]
                } else {
                    cmp0
                }
            }
        })

        for (p in sortedPeople) {
            val h = p[0]
            var k = p[1]
            var i = 0
            while (k > 0 || result[i] != null) {
                if (result[i] == null || result[i]!![0] >= h) {
                    k--
                }
                i++
            }
            result[i] = p
        }

        @Suppress("UNCHECKED_CAST")
        return result as Array<IntArray>
    }
}