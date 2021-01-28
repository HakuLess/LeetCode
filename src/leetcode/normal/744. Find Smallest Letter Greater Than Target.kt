package leetcode.normal

class Solution744 {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        letters.forEach {
            if (it > target) {
                return it
            }
        }
        return letters[0]
    }
}