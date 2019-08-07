package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val a = Solution443()
    a.compress(charArrayOf('a', 'a', 'a', 'b', 'b', 'a', 'a')).print()
}

class Solution443 {
    fun compress(chars: CharArray): Int {
        if (chars.size <= 1) {
            return chars.size
        }
        var count = 1
        var ans = 0
        var offset = 0
        for (i in 1 until chars.size) {
            if (chars[i - 1] == chars[i]) {
                count++
            } else {
                offset++
                chars[offset - 1] = chars[i - 1]
                ans += if (count == 1) {
                    1
                } else {
                    for (j in 0 until count.toString().length) {
                        chars[j + offset] = count.toString()[j]
                    }
                    offset += count.toString().length
                    1 + count.toString().length
                }
                count = 1
            }
        }

        offset++
        if (chars[chars.lastIndex] == chars[chars.lastIndex - 1]) {
            ans += 1 + count.toString().length
            chars[offset - 1] = chars[chars.lastIndex]
            for (j in 0 until count.toString().length) {
                chars[j + offset] = count.toString()[j]
            }
        } else {
            chars[offset - 1] = chars[chars.lastIndex]
            ans++
        }
        return ans
    }
}