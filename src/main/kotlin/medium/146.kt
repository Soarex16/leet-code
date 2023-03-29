package medium._146

class LRUCache(private val capacity: Int) {
    private val mapping = mutableMapOf<Int, LRUList.Entry<Pair<Int, Int>>>()
    private val lru = LRUList<Pair<Int, Int>>()

    /**
     * Return the value of the key if the key exists, otherwise return -1.
     */
    fun get(key: Int): Int {
        return if (key in mapping) {
            val node = mapping[key]!!
            lru.update(node)
            node.value.second
        } else {
            -1
        }
    }

    /**
     * Update the value of the key if the key exists.
     * Otherwise, add the key-value pair to the cache.
     * If the number of keys exceeds the capacity from this operation,
     * evict the least recently used key.
     */
    fun put(key: Int, value: Int) {
        if (key in mapping) {
            val node = mapping[key]!!
            lru.update(node, Pair(key, value))
        } else {
            if (mapping.size == capacity) {
                val oldNode = lru.remove()
                mapping.remove(oldNode.value.first)
            }

            val newNode = lru.put(Pair(key, value))
            mapping[key] = newNode
        }
    }

    private class LRUList<T> {
        private var head: Entry<T>? = null
        private var tail: Entry<T>? = null

        fun update(node: Entry<T>, value: T? = null) {
            val entry = removeEntry(node)
            if (value != null) {
                entry.value = value
            }
            addToTail(entry)
        }

        private fun removeEntry(node: Entry<T>): Entry<T> {
            if (node == head && node == tail) {
                // node in head & tail (lru size == 1)
                head = null
                tail = null
            } else if (node == head) {
                head = head!!.next
                head!!.prev = null
            } else if (node == tail) {
                tail = tail!!.prev
                tail!!.next = null

            } else {
                // node in the middle
                node.prev!!.next = node.next
                node.next!!.prev = node.prev
            }

            return node
        }

        fun put(value: T): Entry<T> {
            val node = Entry(value)
            addToTail(node)
            return node
        }

        private fun addToHead(node: Entry<T>) {
            if (head == null) {
                node.prev = null
                node.next = null
                head = node
                tail = head
            } else {
                node.prev = null
                node.next = head
                head!!.prev = node
                head = node
            }
        }

        private fun addToTail(node: Entry<T>) {
            if (head == null) {
                node.prev = null
                node.next = null
                head = node
                tail = node
            } else {
                node.prev = tail
                node.next = null
                tail!!.next = node
                tail = node
            }
        }

        fun remove(): Entry<T> {
            if (head == null) {
                throw IllegalStateException("list is empty")
            }

            val removed = head
            if (tail == head) {
                head = null
                tail = null
            } else {
                head = head!!.next
                head!!.prev = null
            }
            return removed!!
        }

        class Entry<T>(var value: T, var prev: Entry<T>? = null, var next: Entry<T>? = null)
    }
}