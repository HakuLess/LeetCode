package leetcode

fun palindromePairs(words: Array<String>): List<List<Int>> {
    val ans = arrayListOf<ArrayList<Int>>()
    for (i in 0 until words.size) {
        for (j in i + 1 until words.size) {
            if (isPalindrom(words[i] + words[j], 0)) {
                ans.add(arrayListOf(i, j))
            }
            if (isPalindrom(words[j] + words[i], 0)) {
                ans.add(arrayListOf(j, i))
            }
        }
    }
    return ans
}

fun isPalindrom(str: String, offset: Int): Boolean {
    return if (offset >= str.lastIndex - offset) {
        true
    } else {
        if (str[offset] == str[str.lastIndex - offset]) {
            isPalindrom(str, offset + 1)
        } else {
            false
        }
    }
}