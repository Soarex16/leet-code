package easy._1137

class Solution {
    fun tribonacci(n: Int): Int {
        if (n < 2) {
            return n
        } else if (n == 2) {
            return 1
        }

        var f_pp = 0
        var f_p = 1
        var f_c = 1
        for (i in 2..n) {
            val f_n = f_pp + f_p + f_c
            f_pp = f_p
            f_p = f_c
            f_c = f_n
        }

        return f_p
    }
}