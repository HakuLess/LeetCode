package leetcode.contest.cur.leetcode.c221

import leetcode.contest.utils.print
import leetcode.contest.utils.toIntArray

fun main(args: Array<String>) {
    val s = Solution5640()
    s.maximizeXor("[0,1,2,3,4]".toIntArray(),
            arrayOf(
                    intArrayOf(3, 1),
                    intArrayOf(1, 3),
                    intArrayOf(5, 6)
            )).print()

    s.maximizeXor("[5,2,4,6,6,3]".toIntArray(),
            arrayOf(
                    intArrayOf(12, 4),
                    intArrayOf(8, 1),
                    intArrayOf(6, 3)
            )).print()
}

class Solution5640 {
    fun maximizeXor(nums: IntArray, queries: Array<IntArray>): IntArray {
        val q = queries.sortedBy { it[1] }
        nums.sort()
        var i = 0
        var j = 0
        var cur = q[i]
        val map = HashMap<String, Int>()
        val root = GFG.get()
        while (j in q.indices) {
            while (i in nums.indices && nums[i] <= cur[1]) {
//                println("insert ${cur[1]} ${nums[i]}")
                GFG.insert(root, nums[i])
                i++
            }
            map[cur.joinToString()] = try {
                GFG.max_xor(root, cur[0])
            } catch (ex: Exception) {
                -1
            }

            j++
            if (j !in q.indices) break
            cur = q[j]
        }
//        map.print()
        return queries.map {
            map.getOrDefault(it.joinToString(), -1)
        }.toIntArray()
    }
}

// Java code to find the maximum possible X-OR of
// every array element with another array


internal object GFG {
    // Function to initialise a Trie Node
    fun get(): trie {
        val root = trie()
        root.value = 0
        root.child[0] = null
        root.child[1] = null
        return root
    }

    // Computing max xor
    fun max_xor(root: trie?, key: Int): Int {
        var temp = root

        // Checking for all bits in integer range
        for (i in 31 downTo 0) {
            // Current bit in the number
            var current_bit = key and (1 shl i)
            if (current_bit > 0) current_bit = 1

            // Traversing Trie for different bit, if found
            temp = if (temp!!.child[1 - current_bit] != null) temp.child[1 - current_bit] else temp.child[current_bit]
        }

        // Returning xor value of maximum bit difference
        // value. Thus, we get maximum xor value
        return key xor temp!!.value
    }

    // Inserting B[] in Trie
    fun insert(root: trie?, key: Int) {
        var temp = root

        // Storing 31 bits as integer representation
        for (i in 31 downTo 0) {
            // Current bit in the number
            var current_bit = key and (1 shl i)
            if (current_bit > 0) current_bit = 1

            //System.out.println(current_bit);
            // New node required
            if (temp!!.child[current_bit] == null) temp.child[current_bit] = get()

            // Traversing in Trie
            temp = temp.child[current_bit]
        }
        // Assigning value to the leaf Node
        temp!!.value = key
    }

    // Driver Code
    @JvmStatic
    fun main(args: Array<String>) {
        val A = intArrayOf(7, 3, 9, 12)
        val B = intArrayOf(1, 3, 5, 2)
        val N = A.size

        // Forming Trie for B[]
        val root = get()
        for (i in 0 until N) insert(root, B[i])
        for (i in 0 until N) println(max_xor(root, A[i]))
    }

    // Structure of Trie DS
    internal class trie {
        var value = 0
        var child = arrayOfNulls<trie>(2)
    }
}
