package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution925()
    s.isLongPressedName("alex", "aaleex").print()
    s.isLongPressedName("pyplrz", "ppyypllr").print()
    s.isLongPressedName("saeed", "ssaaedd").print()
}

class Solution925 {

    fun isLongPressedName(name: String, typed: String): Boolean {
        fun getList(str: String): ArrayList<Pair<Char, Int>> {
            val l = ArrayList<Pair<Char, Int>>()
            var tmp = 0
            var lst: Char = ' '
            str.forEach {
                if (it == lst) {
                    tmp++
                } else {
                    if (lst != ' ')
                        l.add(Pair(lst, tmp))
                    tmp = 1
                    lst = it
                }
            }
            l.add(Pair(lst, tmp))
            return l
        }
        val a = getList(name)
        val b = getList(typed)
        if (a.size != b.size) return false
        for (i in a.indices) {
//            println("${a[i]}, ${b[i]}")
            if (a[i].first != b[i].first || a[i].second > b[i].second) return false
        }
        return true
    }
}