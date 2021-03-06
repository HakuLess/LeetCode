package leetcode.normal

/**
 * Created by HaKu on 2018/9/18.
 */
class Solution299 {
    fun getHint(secret: String, guess: String): String {
        var bulls = 0
        var cows = 0
        val set = hashSetOf<Char>()
        secret.forEachIndexed { index, c ->
            if (c == guess[index]) {
                bulls++
            }

            if (!set.contains(c)) {
                set.add(c)
                val secretLength = secret.filter {
                    it == c
                }.length

                val guessLength = guess.filter {
                    it == c
                }.length

                cows += minOf(secretLength, guessLength)
            }
        }

        cows -= bulls
        return "${bulls}A${cows}B"
    }
}