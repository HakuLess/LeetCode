package leetcode.contest.cur.codeforces.kh7

import leetcode.contest.utils.print

// 0、1元素分解为至少其中之一总数不大于K的子字符串的数量
// K从1到字符串长度
fun main() {
//    val s = readLine()!!.map { it - '0' }.toIntArray()
//    val (pos0, pos1) = s.indices.partition { s[it] == 0 }.toList().map(List<Int>::toIntArray)
////    pos0.print()
////    pos1.print()
//    val acc0 = s.runningFold(0) { acc, i -> acc + 1 - i }.toIntArray()
////    acc0.print()
//    for (k in 1..s.size) {
//        // seed不断向后遍历！给力的解法！
//        generateSequence(0) { i ->
//            val v0 = pos0.getOrNull(acc0[i] + k) ?: return@generateSequence null
//            val v1 = pos1.getOrNull(i - acc0[i] + k) ?: return@generateSequence null
//            maxOf(v0, v1)
//        }.count().let { print("$it ") }
//    }
}
