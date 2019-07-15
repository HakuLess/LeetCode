package leetcode.contest.c145

import leetcode.print
import java.util.ArrayList
import java.util.HashMap


fun main(args: Array<String>) {
    val s = Solution1125()
    s.smallestSufficientTeam(
            arrayOf("java", "nodejs", "reactjs"),
            listOf(
                    listOf("java"),
                    listOf("nodejs"),
                    listOf("nodejs", "reactjs")
            )
    ).print()
}

class Solution1125 {

    var res: List<Int> = ArrayList()

    fun smallestSufficientTeam(req_skills: Array<String>, people: List<List<String>>): IntArray {
        val idx = HashMap<String, Int>()
        var n = 0
        for (s in req_skills)
            idx[s] = n++
        val pe = IntArray(people.size)
        for (i in 0..pe.lastIndex) {
            for (p in people[i]) {
                val skill = idx[p]!!
                pe[i] += 1 shl skill
            }
        }

        search(0, pe, ArrayList(), n)
        return res.toIntArray()
    }

    fun search(cur: Int, pe: IntArray, select: ArrayList<Int>, n: Int) {
        if (cur == (1 shl n) - 1) {
            // when all bits are 1, all skills are covered
            if (res.isEmpty() || select.size < res.size) {
                res = ArrayList(select)
            }
            return
        }

        if (res.isNotEmpty() && select.size >= res.size) return

        var zeroBit = 0
        while (cur shr zeroBit and 1 == 1) zeroBit++
        for (i in 0..pe.lastIndex) {
            val per = pe[i]
            if (per shr zeroBit and 1 == 1) {
                select.add(i)
                // when a person can cover a zero bit in the current number, we can add him
                search(cur or per, pe, select, n)
                // search in a backtracking way
                select.removeAt(select.size - 1)
            }
        }
    }

//    fun smallestSufficientTeam(req_skills: Array<String>, people: List<List<String>>): IntArray {
//        val ns = req_skills.size
//        val np = people.size
//
//        val map = HashMap<String, Int>()
//        for (i in 0 until ns) map[req_skills[i]] = i
//
//        val suff = ArrayList<ArrayList<Int>>()
//        for (i in 0 until (1 shl ns)) {
//            suff.add(arrayListOf())
//        }
//
//        for (i in 0 until np) {
//            var skill = 0
//            for (s in people[i]) skill = skill or (1 shl map[s]!!)
//            for (prev in suff.indices) {
//                if (suff[prev].isEmpty()) continue
//                val comb = prev or skill
//                if (suff[comb].isEmpty() || suff[prev].size + 1 < suff[comb].size) {
//                    suff[comb] = ArrayList(suff[prev])
//                    suff[comb].add(i)
//                }
//            }
//        }
//        val res = suff[(1 shl ns) - 1]
//        res.forEach {
//            println("$it, ")
//        }
//        val arr = IntArray(res.size)
//        for (i in arr.indices) arr[i] = res[i]
//        return arr
//    }
}