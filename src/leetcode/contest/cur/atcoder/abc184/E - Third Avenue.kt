package leetcode.contest.cur.atcoder.abc184

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(' ').map { it.toInt() }
    val matrix = Array<CharArray>(h) { CharArray(w) }
    for (i in matrix.indices) {
        matrix[i] = readLine()!!.toString().toCharArray()
    }
    val map = HashMap<Char, ArrayList<Pair<Int, Int>>>()
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (matrix[i][j] !in map.keys) {
                map[matrix[i][j]] = arrayListOf()
            }
            map[matrix[i][j]]!!.add(Pair(i, j))
        }
    }
    val usd = IntArray(26) { 0 }
    val s = map['S']!!.first()
    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    queue.add(s)
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val dist = Array(h) { IntArray(w) { 10000 } }
    dist[s.first][s.second] = 0

    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val (x, y) = queue.poll()
            if (matrix[x][y] == 'G') {
//                dist.print()
                println(dist[x][y])
                return
            }
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx !in matrix.indices || ny !in matrix[0].indices || matrix[nx][ny] == '#') continue
                if (dist[nx][ny] > dist[x][y] + 1) {
                    dist[nx][ny] = dist[x][y] + 1
                    queue.offer(Pair(nx, ny))
                }
            }
            val c = matrix[x][y]
            if (c in 'a'..'z' && usd[c - 'a'] == 0) {
                usd[c - 'a']++
                map[c]!!.forEach {
                    if (dist[it.first][it.second] > dist[x][y] + 1) {
                        dist[it.first][it.second] = dist[x][y] + 1
                        queue.offer(it)
                    }
                }
            }
        }
    }
    println(-1)
}