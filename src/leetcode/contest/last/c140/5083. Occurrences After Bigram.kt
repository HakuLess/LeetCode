package leetcode.contest.last.c140

fun main(args: Array<String>) {
    val a = Solution5083()
    a.findOcurrences("alice is a good girl she is a good student", "a", "good").forEach {
        println(it)
    }
    a.findOcurrences("we will we will rock you", "we", "will").forEach {
        println(it)
    }
    a.findOcurrences("obo jvezipre obo jnvavldde jvezipre jvezipre jnvavldde jvezipre jvezipre jvezipre y jnvavldde jnvavldde obo jnvavldde jnvavldde obo jnvavldde jnvavldde jvezipre", "jnvavldde", "y").forEach {
        println(it)
    }
}

class Solution5083 {
    fun findOcurrences(text: String, first: String, second: String): Array<String> {
        val list = text.split(' ')
        val ans = arrayListOf<String>()
        var index = 0
        while (index < list.size - 2) {
            if (list[index] == first && list[index + 1] == second) {
                ans.add(list[index + 2])
            }
            index++
        }
        return ans.toTypedArray()
    }
}