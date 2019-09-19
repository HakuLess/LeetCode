package leetcode.contest.last.b08

fun main(args: Array<String>) {
    val s = Solution5068()
    s.beforeAndAfterPuzzles(arrayOf("writing code", "code rocks")).forEach {
        println(it)
    }
    s.beforeAndAfterPuzzles(arrayOf("a", "b", "a")).forEach {
        println(it)
    }
}

class Solution5068 {
    fun beforeAndAfterPuzzles(phrases: Array<String>): Array<String> {
        val first = HashMap<Int, String>()
        val last = HashMap<Int, String>()

        phrases.forEachIndexed { index, it ->
            first[index] = it.split(' ').first()
            last[index] = it.split(' ').last()
        }

        val ans = arrayListOf<String>()
        for (i in 0 until phrases.size) {
            for (j in 0 until phrases.size) {
                if (first[i] == last[j] && i != j) {
                    val index = phrases[i].indexOf(' ')
                    if (index != -1) {
                        ans.add("${phrases[j]}${phrases[i].substring(index, phrases[i].length)}")
                    } else {
                        ans.add(phrases[j])
                    }
                }
            }
        }

        ans.sort()
        return ans.distinct().toTypedArray()
    }
}