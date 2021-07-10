package leetcode.normal

import java.util.*
import kotlin.collections.HashMap

// 二分前记得看能不能用TreeMap
class TimeMap() {

    /** Initialize your data structure here. */
    val map = HashMap<String, TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        map[key] = map.getOrDefault(key, TreeMap())
        map[key]!![timestamp] = value
    }

    fun get(key: String, timestamp: Int): String {
        val v = map.getOrDefault(key, TreeMap())
        val ans = v.floorEntry(timestamp) ?: return ""
        return ans.value
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */