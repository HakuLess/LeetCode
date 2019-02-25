package leetcode

fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    var lo = 0
    var hi = letters.size
    while (lo < hi) {
        val mi = lo + (hi - lo) / 2
        if (letters[mi] <= target)
            lo = mi + 1
        else
            hi = mi
    }
    return letters[lo % letters.size]
}