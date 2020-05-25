package leetcode.normal

import java.util.*

class LRUCache(private val capacity: Int) : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
    override fun get(key: Int): Int {
        return super.getOrDefault(key, -1)
    }

    override fun removeEldestEntry(eldest: Map.Entry<Int, Int>): Boolean {
        return size > capacity
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */