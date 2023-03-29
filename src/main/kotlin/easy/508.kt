package easy._509

class Solution {
    fun fib(n: Int): Int {
        if (n < 2) {
            return n
        }

        var f_p = 0
        var f_c = 1
        for (i in 2..n) {
            val f_n = f_p + f_c
            f_p = f_c
            f_c = f_n
        }

        return f_c
    }
}