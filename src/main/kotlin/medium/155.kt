package medium._155

import java.util.*

class MinStack {
    private val items = Stack<Int>()
    private val mins = Stack<Int>()

    fun push(`val`: Int) {
        items.push(`val`)
        if (mins.empty() || `val` <= mins.peek()) {
            mins.push(`val`)
        }
    }

    fun pop() {
        val item = items.pop()
        if (item == mins.peek()) {
            mins.pop()
        }
    }

    fun top(): Int = items.peek()

    fun getMin(): Int = mins.peek()
}