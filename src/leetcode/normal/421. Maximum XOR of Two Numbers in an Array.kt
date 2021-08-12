package leetcode.normal

import java.util.*


class Solution421 {
    fun findMaximumXOR(nums: IntArray): Int {
        var res = 0
        var mask = 0
        for (i in 30 downTo 0) {
            mask = mask or (1 shl i)
            val set = HashSet<Int>()
            for (num in nums) {
                set.add(num and mask)
            }
            val temp = res or (1 shl i)
            for (prefix in set) {
                if (set.contains(prefix xor temp)) {
                    res = temp
                    break
                }
            }
        }
        return res
    }

//    fun findMaximumXOR(nums: IntArray): Int {
//        val maxNum = nums.maxOrNull()!!
//        val l = Integer.toBinaryString(maxNum).length
//        val n = nums.size
//        val bitmask = 1 shl l
//        val strNums = arrayOfNulls<String>(n)
//        for (i in 0 until n) {
//            strNums[i] = Integer.toBinaryString(bitmask or nums[i]).substring(1)
//        }
//        val trie = TrieNode()
//        var maxXor = 0
//        for (num in strNums) {
//            var node: TrieNode = trie
//            var xorNode: TrieNode = trie
//            var currXor = 0
//            for (bit in num!!.toCharArray()) {
//                node = if (node.children.containsKey(bit)) {
//                    node.children[bit]!!
//                } else {
//                    val newNode = TrieNode()
//                    node.children[bit] = newNode
//                    newNode
//                }
//
//                val toggledBit = if (bit == '1') '0' else '1'
//                if (xorNode.children.containsKey(toggledBit)) {
//                    currXor = currXor shl 1 or 1
//                    xorNode = xorNode.children[toggledBit]!!
//                } else {
//                    currXor = currXor shl 1
//                    xorNode = xorNode.children[bit]!!
//                }
//            }
//            maxXor = maxOf(maxXor, currXor)
//        }
//        return maxXor
//    }
}

//class TrieNode {
//    var children = HashMap<Char, TrieNode>()
//}