package leetcode.normal

import java.util.*
import kotlin.collections.HashSet


class RandomizedCollection() {

    private var idx = HashMap<Int, HashSet<Int>>()
    private var nums = arrayListOf<Int>()

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element.  */
    fun insert(`val`: Int): Boolean {
        nums.add(`val`)
        val set = idx.getOrDefault(`val`, HashSet())
        set.add(nums.size - 1)
        idx[`val`] = set
        return set.size == 1
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element.  */
    fun remove(`val`: Int): Boolean {
        if (!idx.containsKey(`val`)) {
            return false
        }
        val i = idx[`val`]!!.first()
        val lastNum = nums[nums.size - 1]
        nums[i] = lastNum
        idx[`val`]!!.remove(i)
        idx[lastNum]!!.remove(nums.size - 1)
        if (i < nums.size - 1) {
            idx[lastNum]!!.add(i)
        }
        if (idx[`val`]!!.size == 0) {
            idx.remove(`val`)
        }
        nums.removeAt(nums.size - 1)
        return true
    }

    /** Get a random element from the collection.  */
    fun getRandom(): Int {
        return nums[(Math.random() * nums.size).toInt()]
    }

}