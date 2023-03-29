package medium._304

class NumMatrix(matrix: Array<IntArray>) {
    private val n = matrix.size
    private val m = matrix[0].size
    private val tree: Array<IntArray> = Array(n + 1) { IntArray(m + 1)}

    init {
        matrix.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                add(rowIndex, colIndex, value)
            }
        }
    }

    private fun add(row: Int, col: Int, value: Int) {
        var r = row + 1
        while (r <= n) {
            var c = col + 1
            while (c <= m) {
                tree[r][c] += value
                c += (c and -c)
            }
            r += (r and -r)
        }
    }

    fun sum(row: Int, col: Int) : Int {
        var r = row + 1
        var sum = 0
        while (r > 0) {
            var c = col + 1
            while (c > 0) {
                sum += tree[r][c]
                c -= (c and -c)
            }
            r -= (r and -r)
        }
        return sum
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return sum(row2, col2) - sum(row1 - 1, col2) - sum(row2, col1 - 1) + sum(row1 - 1, col1 - 1)
    }
}