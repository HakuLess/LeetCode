package leetcode.contest.cur.codeforces.ecr94

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (z in 0 until t) {
        val n = readLine()!!.toInt()
        val list = readLine()!!.split(' ').map { it.toInt() }
        val map = HashMap<Int, ArrayList<Int>>()
        list.forEachIndexed { index, it ->
            map[it] = map.getOrDefault(it, arrayListOf())
            map[it]!!.add(index)
        }
        var ans = 0
        for (i in list.indices) {
            if (map[list[i]]!!.size < 2) continue
            for (j in i + 1..list.lastIndex) {
                if (map[list[j]]!!.size < 2) continue
                for (k in j + 1..list.lastIndex) {
                    if (list[i] != list[k]) continue
                    for (l in k + 1..list.lastIndex) {
                        if (list[i] == list[k] && list[j] == list[l]) {
                            ans++
                        }
                    }
                }
            }
        }
        println(ans)
    }
}