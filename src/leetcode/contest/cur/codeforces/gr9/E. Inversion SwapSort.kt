package leetcode.contest.cur.codeforces.gr9

import leetcode.contest.utils.print
import leetcode.contest.utils.toArrayList

// todo not finish
fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    fun getAns(array: ArrayList<Int>): ArrayList<Pair<Int, Int>> {
        if (array.isEmpty()) {
            return arrayListOf()
        }
        val ans = arrayListOf<Pair<Int, Int>>()
        if (array.last() == array.max()) {
            array.removeAt(array.lastIndex)
            return getAns(array)
        }
        val max = array.max()!!
        val index = array.indexOf(max)
        ans.add(Pair(index, array.lastIndex))
        array[index] = array.last()
        array[array.lastIndex] = max
        ans.addAll(getAns(array))
        return ans
    }

    val list = ArrayList<Pair<Int, Int>>()
    for (i in 0 until array.lastIndex) {
        for (j in i + 1 until array.size) {
            if (array[j] < array[i]) {
                list.add(Pair(i, j))
            }
        }
    }
    val ans = getAns(array.toArrayList())
    if (ans.size != list.size) {
        println(-1)
        return
    }
    if (list.any { it !in ans }) {
        println(-1)
        return
    }
    println(ans.size)
    ans.forEach {
        println("${it.first + 1} ${it.second + 1}")
    }
}