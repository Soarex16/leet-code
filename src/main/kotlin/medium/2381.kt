package medium._2381

class Solution {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val n = s.length
        val q = IntArray(n + 1)
        val offsets = IntArray(n)
        for (shift in shifts) {
            val start = shift[0]
            val end = shift[1]
            val dir = if (shift[2] == 1) { 1 } else { -1 }
            q[start] += dir
            q[end + 1] -= dir
        }
        var acc = 0
        for (i in 0 until n) {
            acc += q[i]
            offsets[i] = acc
        }

        return buildString {
            for (i in s.indices) {
                append(shiftChar(s[i], offsets[i]))
            }
        }
    }
}

fun shiftChar(c: Char, offset: Int): Char {
    val off = offset % ('z' - 'a' + 1)
    val offC = c + off
    return if (off > 0) {
        if (offC <= 'z') {
            offC
        } else {
            val add : Int = (c + off - 'z'.toInt()).toInt()
            'a' - 1 + add
        }
    } else if (off < 0) {
        if ('a' <= offC) {
            offC
        } else { // a > (c + off) -> c < a
            val add: Int = off - ('a' - c)
            'z' + add + 1
        }
    } else {
        c
    }
}