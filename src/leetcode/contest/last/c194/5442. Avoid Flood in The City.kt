package leetcode.contest.last.c194

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution5442()
//    s.avoidFlood(intArrayOf(1, 2, 0, 0, 2, 1)).print()
//    s.avoidFlood(intArrayOf(1, 0, 2, 0, 2, 1)).print()
//    s.avoidFlood(intArrayOf(69, 0, 0, 0, 69)).print()
//    s.avoidFlood(intArrayOf(1, 2, 0, 2, 3, 0, 1)).print()
    s.avoidFlood(intArrayOf(1, 1, 0, 0)).print()
//    s.avoidFlood(intArrayOf(0, 72328, 0, 0, 94598, 54189, 39171, 53361, 0, 0, 0, 72742, 0, 98613, 16696, 0, 32756, 23537, 0, 94598, 0, 0, 0, 11594, 27703, 0, 0, 0, 20081, 0, 24645, 0, 0, 0, 0, 0, 0, 0, 2711, 98613, 0, 0, 0, 0, 0, 91987, 0, 0, 0, 22762, 23537, 0, 0, 0, 0, 54189, 0, 0, 87770, 0, 0, 0, 0, 27703, 0, 0, 0, 0, 20081, 16696, 0, 0, 0, 0, 0, 0, 0, 35903, 0, 72742, 0, 0, 0, 35903, 0, 0, 91987, 76728, 0, 0, 0, 0, 2711, 0, 0, 11594, 0, 0, 22762, 24645, 0, 0, 0, 0, 0, 53361, 0, 87770, 0, 0, 39171, 0, 24577, 0, 0, 0, 24577, 0, 0, 72328, 0, 0, 32756, 0, 0, 76728)).print()
}

class Solution5442 {
    fun avoidFlood(rains: IntArray): IntArray {
        val ans = IntArray(rains.size) { -1 }
        val ts = TreeSet<Int>()
        val seen = HashMap<Int, Int>()
        for (i in rains.indices) {
            if (rains[i] == 0) {
                ts.add(i)
            } else {
                if (rains[i] in seen.keys) {
                    val up = ts.ceiling(seen[rains[i]])
                    if (up == null) return intArrayOf()
                    ans[up] = rains[i]
                    seen[rains[i]] = i
                    ts.remove(up)
                } else {
                    seen[rains[i]] = i
                }
            }
        }
        for (i in ts) {
            ans[i] = 1
        }
        return ans
    }
//    fun avoidFlood(rains: IntArray): IntArray {
//        val ans = IntArray(rains.size) { -1 }
//        val st = Stack<Int>()
//        val seen = HashSet<Int>()
//        for (i in rains.indices) {
//            if (rains[i] > 0) {
//                if (seen.contains(rains[i])) {
//                    if (st.isNotEmpty()) {
//                        ans[st.pop()] = rains[i]
//                        seen.remove(rains[i])
//                    } else {
//                        return intArrayOf()
//                    }
//                } else {
//                    seen.add(rains[i])
//                }
//            } else if (rains[i] == 0) {
//                st.add(i)
//            }
//        }
//        for (i in ans.indices) {
//            if (rains[i] == 0 && ans[i] == -1) {
//                ans[i] = 1
//            }
//        }
//        seen.clear()
//        ans.print()
//        rains.print()
//        for (i in rains.indices) {
//            if (ans[i] != -1) {
//                seen.remove(ans[i])
//            } else {
//                if (seen.contains(rains[i])) {
//                    return intArrayOf()
//                }
//                seen.add(rains[i])
//            }
//        }
//        return ans
//    }
}