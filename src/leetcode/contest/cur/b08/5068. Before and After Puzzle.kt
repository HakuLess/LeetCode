package leetcode.contest.cur.b08

fun main(args: Array<String>) {
    val s = Solution5068()
//    s.beforeAndAfterPuzzles(arrayOf("writing code", "code rocks")).forEach {
//        println(it)
//    }
    s.beforeAndAfterPuzzles(arrayOf("a", "b", "a")).forEach {
        println(it)
    }
}

class Solution5068 {
    fun beforeAndAfterPuzzles(phrases: Array<String>): List<String> {
        val first = HashMap<String, String>()
        val last = HashMap<String, String>()

        phrases.forEach {
            if (it.contains(' ')) {
                first[it] = it.split(' ').first()
                last[it] = it.split(' ').last()
            }
        }

        val ans = arrayListOf<String>()
        for (item in last) {
            first.filter {
                it.value == item.value
            }.forEach { t, u ->
                val it = "${item.key}${t.substring(u.length, t.lastIndex + 1)}"
                ans.add(it)
            }
        }

        val s = phrases.filter {
            !it.contains(" ")
        }
        val a = s.filter { t ->
            s.count {
                it == t
            } > 1
        }.distinct()
        ans.addAll(a)
        ans.sort()
        return ans
    }
}