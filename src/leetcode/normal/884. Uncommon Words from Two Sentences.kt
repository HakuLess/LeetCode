package leetcode.normal

fun uncommonFromSentences(A: String, B: String): Array<String> {
    val hashMap = HashMap<String, Int>()
    A.split(' ').forEach {
        hashMap[it] = hashMap.getOrDefault(it, 0) + 1
    }
    B.split(' ').forEach {
        hashMap[it] = hashMap.getOrDefault(it, 0) + 1
    }
    val ans = arrayListOf<String>()
    hashMap.forEach { t, u ->
        if (u == 1) {
            ans.add(t)
        }
    }
    return ans.toTypedArray()
}