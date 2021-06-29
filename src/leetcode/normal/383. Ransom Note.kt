package leetcode.normal

class Solution383 {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val a = IntArray(26)
        val b = IntArray(26)
        ransomNote.map { a[it - 'a']++ }
        magazine.map { b[it - 'a']++ }
        return (0..25).all {
            a[it] <= b[it]
        }
    }
}