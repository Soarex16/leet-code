package medium._2

data class ListNode(val `val`: Int, var next: ListNode? = null)

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
        var add = 0
        var h1 = l1
        var h2 = l2
        var res = ListNode(0)
        val head = res

        while (h1 != null && h2 != null) {
            val s = h1.`val` + h2.`val` + add
            val d = s % 10
            add = s / 10

            val next = ListNode(d)
            res.next = next
            res = next

            h1 = h1.next
            h2 = h2.next
        }

        if (h1 != null || h2 != null) {
            var h = h1 ?: h2
            while (h != null) {
                val s = h.`val` + add
                val d = s % 10
                add = s / 10

                val next = ListNode(d)
                res.next = next
                res = next

                h = h.next
            }
        }

        // rest elem will be only one
        if (add != 0) {
            val rest = ListNode(add)
            res.next = rest
        }

        return head.next!!
    }
}