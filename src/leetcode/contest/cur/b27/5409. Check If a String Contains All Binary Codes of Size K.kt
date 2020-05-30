package leetcode.contest.cur.b27

import leetcode.contest.utils.print
import java.util.*
import kotlin.math.pow


fun main(args: Array<String>) {
    val s = Solution5409()
    s.hasAllCodes("0110", 3).print()
}

class Solution5409 {

    fun hasAllCodes(s: String, k: Int): Boolean {
        var left = 0
        var right = k
        val len = s.length
        val set = HashSet<String>()
        while (right <= len) {
            set.add(s.substring(left, right))
            left++
            right++
        }
        return set.size == 2.0.pow(k).toInt()
    }

//    var ans = true
//    fun hasAllCodes(s: String, k: Int): Boolean {
//        helper("", s, k)
//        return ans
//    }
//
//    private fun helper(cur: String, s: String, k: Int) {
//        if (!ans) {
//            return
//        }
//        if (cur.length == k) {
//            ans = ans and (s.indexOf(cur) != -1)
//        } else {
//            helper("0$cur", s, k)
//            helper("1$cur", s, k)
//        }
//    }

//    fun hasAllCodes(s: String, k: Int): Boolean {
//        val set = HashSet<String>()
//        for (i in 0 until 2.0.pow(k).toInt()) {
////            val item = String.format("%13",i.toString(2))
//            var item = i.toString(2)
//            while (item.length != k) {
//                item = "0$item"
//            }
//            set.add(item)
//        }
//        set.forEach {
//            if (s.indexOf(it) == -1) {
//                return false
//            }
//        }
//        return true
//    }
}