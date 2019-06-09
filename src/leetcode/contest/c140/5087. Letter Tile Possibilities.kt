package leetcode.contest.c140

import leetcode.print

fun main(args: Array<String>) {
    val a = Solution5087()
    a.numTilePossibilities("aab").print()
    a.numTilePossibilities("AAABBC").print()
}

class Solution5087 {
    fun numTilePossibilities(tiles: String): Int {
        val per = permuteSquare(tiles)
        val ans = arrayListOf<List<Char>>()
        ans.addAll(per)
        for (i in 0 until tiles.length) {
            val temp = arrayListOf<List<Char>>()
            per.forEach {
                temp.add(it.subList(i, it.lastIndex))
            }
            ans.addAll(temp)
        }
        ans.distinct().forEach {
            it.forEach {
                print("$it, ")
            }
            println()
        }
        return ans.distinct().size - 1
    }

    fun permuteSquare(nums: String): List<List<Char>> {
        val result = arrayListOf<ArrayList<Char>>()
        var listStack: ArrayList<ArrayList<Char>>
        nums.forEach {
            listStack = ArrayList(result)
            result.clear()
            if (listStack.isEmpty()) {
                result.add(arrayListOf(it))
            } else {
                while (listStack.isNotEmpty()) {
                    val list = listStack.first()
                    listStack.removeAt(0)
                    for (i in 0..list.size) {
                        val temp = ArrayList(list)
                        temp.add(i, it)
                        result.add(temp)
                    }
                }
            }
        }

        return result.distinct()
    }
}