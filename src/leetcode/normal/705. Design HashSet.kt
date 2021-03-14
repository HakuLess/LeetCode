package leetcode.normal

class MyHashSet() {

    /** Initialize your data structure here. */
    val set = HashSet<Int>()

    fun add(key: Int) {
        set.add(key)
    }

    fun remove(key: Int) {
        set.remove(key)
    }

    /** Returns true if this set contains the specified element */
    fun contains(key: Int): Boolean {
        return set.contains(key)
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */