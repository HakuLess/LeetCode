package leetcode.normal

fun main(args: Array<String>) {
    commonChars(arrayOf(
//            "cool", "lock", "cook"
            "bella", "label", "roller"
    )).forEach {
        print("$it, ")
    }
}

fun commonChars(A: Array<String>): List<String> {
    if (A.isEmpty()) {
        return emptyList()
    }

    val result = HashMap<String, Int>()
    A[0].forEach {
        result[it.toString()] = result.getOrDefault(it.toString(), 0) + 1
    }

    for (i in 1 until A.size) {
        result.forEach {
            val key = it.key
            val count = A[i].count { c -> c.toString() == key }
            result[key] = minOf(result[key] ?: 0, count)
        }
    }

    val ans = arrayListOf<String>()
    result.forEach { t, u ->
        if (u > 0) {
            for (i in 0 until u) {
                ans.add(t)
            }
        }
    }

    return ans
}