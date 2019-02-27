fun firstUniqChar(s: String): Int {

    val map = hashMapOf<Char, Int>()
    s.forEachIndexed { index, c ->
        val i = map.getOrDefault(c, -1)
        if (i == -1) {
            map[c] = index
        } else {
            map[c] = -2
        }
    }

    map.forEach { t, u ->
        println("$t, $u")
    }
    var ans = s.length + 1
    map.forEach { t, u ->
        if (u in 0..(ans - 1)) {
            ans = u
        }
    }
    return if (ans < s.length + 1) {
        ans
    } else {
        -1
    }
}