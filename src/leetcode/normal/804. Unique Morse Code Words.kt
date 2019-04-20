package leetcode.normal

import java.lang.StringBuilder

fun uniqueMorseRepresentations(words: Array<String>): Int {
    val dic = arrayOf(".-", "-...", "-.-.", "-..", "", "..-.", "--.", "....", "", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..")
    val set = hashSetOf<String>()
    words.forEach {
        val str = StringBuilder()
        it.forEach {
            str.append(dic[it - 'a'])
        }
        set.add(str.toString())
    }

    return set.size
}