package medium._147

data class ListNode(val `val`: Int, var next: ListNode? = null)

class Solution {
    fun insertionSortList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        var newListHead: ListNode? = null
        var current = head
        while (current != null) {
            val newTail = current.next
            current.next = null
            val newHead = insert(newListHead, current)
            newListHead = newHead
            current = newTail
        }

        return newListHead
    }

    /**
     * returns new tail
     * [node] must be isolated (next == null)
     * head must be cut before node
     */
    private fun insert(head: ListNode?, node: ListNode): ListNode {
        if (head == null) {
            return node
        }

        var prev: ListNode? = null
        var curr = head
        while (curr != null && curr.`val` < node.`val`) {
            prev = curr
            curr = curr.next
        }

        val newHead = if (prev != null) {
            node.next = curr
            prev.next = node
            head
        } else {
            node.next = curr
            node
        }

        return newHead
    }
}