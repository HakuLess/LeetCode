package leetcode.contest.cur.leetcode.b55

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MovieRentingSystem(n: Int, entries: Array<IntArray>) {

    data class Movie(val shop: Int, val id: Int, val price: Int, var rent: Boolean)

    val l = ArrayList<Movie>()

    val map = HashMap<Int, PriorityQueue<Movie>>()
    val rentMap = HashMap<Pair<Int, Int>, Movie>()
    val rentList = PriorityQueue<Movie>(compareBy({ it.price }, { it.shop }, { it.id }))

    init {
        entries.forEach {
            val it = Movie(it[0], it[1], it[2], false)
            map[it.id] = map.getOrDefault(it.id, PriorityQueue<Movie>(compareBy({ it.price }, { it.shop })))
            map[it.id]!!.add(it)
            rentMap[Pair(it.shop, it.id)] = it
        }
    }

    fun search(movie: Int): List<Int> {
        if (movie !in map.keys) return emptyList()
        val ans = arrayListOf<Int>()
        val tmp = PriorityQueue(map[movie])
        while (tmp.isNotEmpty() && ans.size != 5) {
            val it = tmp.poll()
            if (!it.rent) ans.add(it.shop)
        }
        return ans
    }

    fun rent(shop: Int, movie: Int) {
        rentMap[Pair(shop, movie)]!!.rent = true
        rentList.offer(rentMap[Pair(shop, movie)])
    }

    fun drop(shop: Int, movie: Int) {
        rentMap[Pair(shop, movie)]!!.rent = false
        rentList.remove(rentMap[Pair(shop, movie)])
    }

    fun report(): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        val tmp = PriorityQueue(rentList)
        while (tmp.isNotEmpty() && ans.size != 5) {
            val it = tmp.poll()
            ans.add(listOf(it.shop, it.id))
        }
        return ans
    }

}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * var obj = MovieRentingSystem(n, entries)
 * var param_1 = obj.search(movie)
 * obj.rent(shop,movie)
 * obj.drop(shop,movie)
 * var param_4 = obj.report()
 */