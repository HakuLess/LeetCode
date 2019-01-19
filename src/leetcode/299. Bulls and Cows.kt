package leetcode

import kotlin.math.min

/**
 * Created by HaKu on 2018/9/18.
 */

fun main(args: Array<String>) {
    val secret = "1807"
    val guess = "7810"

//    val secret = "1123"
//    val guess = "0111"
    println(getHint(secret, guess))
}

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

            cows += min(secretLength, guessLength)
        }
    }

    cows -= bulls
    return "${bulls}A${cows}B"
}