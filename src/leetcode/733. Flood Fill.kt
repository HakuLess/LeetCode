package leetcode

import java.util.*

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    if (image.isEmpty() || image[0].isEmpty()) {
        return arrayOf()
    }
    val origin = image[sr][sc]
    val stack = Stack<Pair<Int, Int>>()
    val hashSet = hashSetOf<Pair<Int, Int>>()

    stack.push(Pair(sr, sc))
    hashSet.add(Pair(sr, sc))

    while (stack.isNotEmpty()) {
        val item = stack.pop()
        if (image[item.first][item.second] == origin) {
            image[item.first][item.second] = newColor

            if (item.first + 1 < image.size) {
                val next = Pair(item.first + 1, item.second)
                if (next !in hashSet) {
                    stack.push(next)
                    hashSet.add(next)
                }
            }
            if (item.first - 1 >= 0) {
                val next = Pair(item.first - 1, item.second)
                if (next !in hashSet) {
                    stack.push(next)
                    hashSet.add(next)
                }
            }
            if (item.second + 1 < image[0].size) {
                val next = Pair(item.first, item.second + 1)
                if (next !in hashSet) {
                    stack.push(next)
                    hashSet.add(next)
                }
            }
            if (item.second - 1 >= 0) {
                val next = Pair(item.first, item.second - 1)
                if (next !in hashSet) {
                    stack.push(next)
                    hashSet.add(next)
                }
            }
        }
    }

    return image
}