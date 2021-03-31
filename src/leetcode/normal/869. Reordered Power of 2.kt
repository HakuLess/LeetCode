package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution869()
    s.reorderedPowerOf2(2).print()
    s.reorderedPowerOf2(24).print()
    s.reorderedPowerOf2(46).print()
}

class Solution869 {
    fun reorderedPowerOf2(n: Int): Boolean {
        fun getMap(n: Int): HashMap<Int, Int> {
            var num = n
            val ans = hashMapOf<Int, Int>()
            while (num > 0) {
                ans[num % 10] = ans.getOrDefault(num % 10, 0) + 1
                num /= 10
            }
            return ans
        }

        val list = arrayListOf<HashMap<Int, Int>>()
        var num = 1
        while (num <= 1000000000) {
            list.add(getMap(num))
            num *= 2
        }
        return getMap(n) in list
    }
}