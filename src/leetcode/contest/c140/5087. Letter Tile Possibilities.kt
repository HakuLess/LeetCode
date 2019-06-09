package leetcode.contest.c140

import leetcode.print

fun main(args: Array<String>) {
    val a = Solution5087()
//    a.numTilePossibilities("aab").print()
    a.numTilePossibilities("AAABBC").print()
}

class Solution5087 {

    fun numTilePossibilities(tiles: String): Int {
        val count = IntArray(26)
        for (c in tiles.toCharArray()) count[c - 'A']++
        return dfs(count)
    }

    fun dfs(arr: IntArray): Int {
        var sum = 0
        for (i in 0..25) {
            if (arr[i] == 0) continue
            sum++
            arr[i]--
            sum += dfs(arr)
            arr[i]++
        }
        return sum
    }
//
//    val ans = arrayListOf<String>()
//    private val seen = hashSetOf<Int>()
//
//    fun numTilePossibilities(tiles: String): Int {
//        for (i in 0 until tiles.length) {
//            dfs(tiles, "")
//        }
////        ans.forEach {
////            println(it)
////        }
//        return ans.distinct().size
//    }
//
//    private fun dfs(tiles: String, cur: String) {
//        for (i in 0 until tiles.length) {
//            if (seen.contains(i)) {
//                continue
//            }
//            seen.add(i)
//            ans.add(cur + tiles[i])
//            dfs(tiles, cur + tiles[i])
//            seen.remove(i)
//        }
//    }
}