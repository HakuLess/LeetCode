package leetcode

import java.util.*

class RandomizedSet() {

    /** Initialize your data structure here. */
    val hashSet = hashSetOf<Int>()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        return if (`val` in hashSet) {
            false
        } else {
            hashSet.add(`val`)
            true
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        return if (`val` in hashSet) {
            hashSet.remove(`val`)
            true
        } else {
            false
        }
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        val index = Random().nextInt(hashSet.size)
        val it = hashSet.iterator()
        for (i in 0 until index) {
            it.next()
        }
        return it.next()
    }

}