package leetcode

import java.util.*

fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    val result = Array(rooms.size) { false }
    val hash = hashSetOf<Int>()
    val stack = Stack<Int>()
    stack.push(0)
    hash.add(0)

    while (stack.isNotEmpty()) {
        val item = stack.pop()
        result[item] = true
        rooms[item].forEach {
            if (it !in hash) {
                stack.push(it)
                hash.add(it)
            }
        }
    }

    return result.none { !it }
}