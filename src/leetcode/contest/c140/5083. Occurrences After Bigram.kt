package leetcode.contest.c140

fun main(args: Array<String>) {
    val a = Solution5083()
//    a.findOcurrences("alice is a good girl she is a good student", "a", "good").forEach {
//        println(it)
//    }
//    a.findOcurrences("we will we will rock you", "we", "will").forEach {
//        println(it)
//    }
    a.findOcurrences("obo jvezipre obo jnvavldde jvezipre jvezipre jnvavldde jvezipre jvezipre jvezipre y jnvavldde jnvavldde obo jnvavldde jnvavldde obo jnvavldde jnvavldde jvezipre", "jnvavldde", "y").forEach {
        println(it)
    }
}
class Solution5083 {
    fun findOcurrences(text: String, first: String, second: String): Array<String> {
        val list = text.split(' ')
        var c = 0
        val ans = arrayListOf<String>()
        var cur = 0
        while (c < list.size) {
//            println("cur ${list[c]}")

            if (cur == 2) {
                ans.add(list[c])
                cur = 0
                c -= 2
                c++
                println("cur $c ${list[c]}")
                continue
            }
            if (cur == 1 && list[c] == second) {
                cur = 2
                c++
                println("cur $c ${list[c]}")
                continue
            }
            if (list[c] == first) {
                cur = 1
                c++
//                println("cur $c ${list[c]}")
            } else {
                c++
                cur = 0
            }
        }
        return ans.toTypedArray()
    }
}