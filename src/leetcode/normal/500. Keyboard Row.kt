package leetcode.normal

class Solution500 {
    fun findWords(words: Array<String>): Array<String> {
        val row0 = arrayOf('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p')
        val row1 = arrayOf('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l')
        val row2 = arrayOf('z', 'x', 'c', 'v', 'b', 'n', 'm')

        val ans = arrayListOf<String>()
        words.map {
            val item = IntArray(it.length)
            for (i in it.indices) {
                when {
                    it[i].toLowerCase() in row0 -> item[i] = 0
                    it[i].toLowerCase() in row1 -> item[i] = 1
                    else -> item[i] = 2
                }
            }
            item
        }.forEachIndexed { index, ints ->
            if (ints.all { it == ints[0] }) {
                ans.add(words[index])
            }
        }
        return ans.toTypedArray()
    }
}