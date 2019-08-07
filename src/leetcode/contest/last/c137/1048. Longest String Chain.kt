package leetcode.contest.last.c137

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1048()
    s.longestStrChain(arrayOf("a", "b", "ba", "bca", "bda", "bdca")).print()
    s.longestStrChain(arrayOf("ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru")).print()
    s.longestStrChain(arrayOf("qyssedya", "pabouk", "mjwdrbqwp", "vylodpmwp", "nfyqeowa", "pu", "paboukc", "qssedya", "lopmw", "nfyqowa", "vlodpmw", "mwdrqwp", "opmw", "qsda", "neo", "qyssedhyac", "pmw", "lodpmw", "mjwdrqwp", "eo", "nfqwa", "pabuk", "nfyqwa", "qssdya", "qsdya", "qyssedhya", "pabu", "nqwa", "pabqoukc", "pbu", "mw", "vlodpmwp", "x", "xr")).print()
}

class Solution1048 {
    fun longestStrChain(words: Array<String>): Int {
        var result = 0

        val max = words.maxBy { it.length }!!.length
        var map = hashMapOf<String, Int>()
        for (i in 1..max) {
            val cur = words.filter {
                it.length == i
            }
            if (map.isEmpty()) {
                cur.forEach {
                    map[it] = 1
                }
                result = maxOf(result, 1)
            } else {
                val temp = hashMapOf<String, Int>()
                map.forEach { t, u ->
                    cur.forEach {
                        if (isPre(t, it)) {
                            temp[it] = maxOf(map.getOrDefault(t, 1) + 1, temp.getOrDefault(it, 0))
                        }
                    }
                }
                cur.forEach {
                    temp[it] = temp.getOrDefault(it, 1)
                }
                map = temp
                if (map.isNotEmpty()) {
                    result = maxOf(result, map.maxBy { it.value }!!.value)
                }
            }
        }
        return result
    }

    private fun isPre(a: String, b: String): Boolean {
        var first = false
        for (i in 0 until a.length) {
            var j = i
            if (first) {
                j = i + 1
            }
            if (a[i] != b[j]) {
                if (!first) {
                    first = true
                    if (a[i] != b[j + 1]) {
                        return false
                    }
                } else {
                    return false
                }
            }
        }
        return true
    }
}