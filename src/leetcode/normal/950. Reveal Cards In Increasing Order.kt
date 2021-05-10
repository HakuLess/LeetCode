package leetcode.normal

class Solution950 {
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
}