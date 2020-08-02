package leetcode.contest.cur.atcoder.abc174

import leetcode.contest.utils.SegmentTree

//fun main(args: Array<String>) {
//    val (n, q) = readLine()!!.toString().split(' ').map { it.toInt() }
//    val arr = readLine()!!.toString().split(' ').map { it.toInt() }.toIntArray()
//    val list = ArrayList<HashMap<Int, Int>>()
//    list.add(HashMap())
//    val map = HashMap<Int, Int>()
//    for (i in arr.indices) {
//        map[arr[i]] = map.getOrDefault(arr[i], 0) + 1
//        list.add(HashMap(map))
//    }
//    for (i in 0 until q) {
//        val (l, r) = readLine()!!.toString().split(' ').map { it.toInt() }
//        val left = list[l - 1]
//        val right = list[r]
//        val cur = HashMap(right)
//        left.forEach { i, i2 ->
//            cur[i] = cur[i]!! - i2
//            if (cur[i] == 0) cur.remove(i)
//        }
////        println("$l after $cur")
//        println(cur.size)
//    }
//}

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.toString().split(' ').map { it.toInt() }
    val arr = readLine()!!.toString().split(' ').map { it.toInt() }.toIntArray()
    val source = ArrayList<HashSet<Int>>()
    arr.forEach {
        val set = hashSetOf<Int>()
        set.add(it)
        source.add(set)
    }
    val root = SegmentTree { a: HashSet<Int>, b: HashSet<Int> ->
        val map = HashSet<Int>(a)
        map.addAll(b)
        map
    }.build(source.toTypedArray())
    for (i in 0 until q) {
        val (l, r) = readLine()!!.toString().split(' ').map { it.toInt() }
        val ans = root!!.query(root, l - 1, r - 1)
        println(ans.size)
    }
}