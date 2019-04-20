package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val array = intArrayOf(17, 13, 11, 2, 3, 5, 7)
    deckRevealedIncreasing(array).print()
}

fun deckRevealedIncreasing(deck: IntArray): IntArray {
    val ans = IntArray(deck.size) { -1 }
    deck.sort()

    var count = 0
    var add = true
    var i = 0
    while (i != deck.size) {
        if (ans[count] == -1) {
            if (add) {
                ans[count] = deck[i]
                i++
            }
            add = !add
        }
        count = (count + 1) % deck.size
    }
    return ans
}