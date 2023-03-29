package medium._307

class NumArray(nums: IntArray) {
    private val tree: IntArray = IntArray(nums.size + 1)
    private val n = nums.size

    init {
        nums.forEachIndexed(this::add)
    }

    fun add(index: Int, value: Int) {
        var i = index + 1
        while (i <= n) {
            tree[i] += value
            i += (i and -i)
        }
    }

    fun sum(right: Int) : Int {
        var i = right + 1
        var sum = 0
        while (i > 0) {
            sum += tree[i]
            i -= (i and -i)
        }
        return sum
    }

    fun update(index: Int, `val`: Int) {
        val prevVal = sumRange(index, index)
        add(index,  `val` - prevVal)
    }

    fun sumRange(left: Int, right: Int): Int {
        return sum(right) - sum(left - 1)
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * obj.update(index,`val`)
 * var param_2 = obj.sumRange(left,right)
 */