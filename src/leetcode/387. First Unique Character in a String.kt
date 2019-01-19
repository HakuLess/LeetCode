package leetcode

fun main(args: Array<String>) {
    val s = "leetcode"
    firstUniqChar(s).print()
}

fun firstUniqChar(s: String): Int {
    val map = linkedMapOf<Char, Int>()
    s.forEach {
        val c = map.getOrDefault(it, 0)
        map[it] = c + 1
    }

    map.forEach {
        if (it.value == 1) {
            println(it.key)
            val result = s.indexOfFirst { c ->
                it.key == c
            }
            return result
        }
    }
    return -1
}