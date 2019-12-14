package leetcode.contest.cur.b15

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = CombinationIterator("abc", 1)
    s.hasNext().print()
    s.next().print()
    s.hasNext().print()
    s.next().print()
    s.hasNext().print()
    s.next().print()
}
class CombinationIterator(characters: String, combinationLength: Int) {

    val origin = characters
    val total = characters.length
    val length = combinationLength
    var cur = arrayListOf<Int>()
    var temp = origin.substring(0, length)
    init {
        for (i in 0 until length) {
            cur.add(i)
        }
    }

    fun next(): String {
        val ans = getStr()
        var offset = 0
        for (i in cur.indices.reversed()) {
            if (cur[i] != origin.lastIndex - offset) {
                cur[i] = cur[i] + 1
                for (j in i..cur.lastIndex) {
                    cur[j] = cur[i] + j - i
                }
                return ans
            }
            offset++
        }
        temp = ans
        return ans
    }

    fun hasNext(): Boolean {
        return temp != origin.substring(total - length, total)
    }

    private fun getStr(): String {
        var ans = ""
        cur.forEach {
            ans += origin[it]
        }
        return ans
    }

}
