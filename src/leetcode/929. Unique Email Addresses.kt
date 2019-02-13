package leetcode

import java.lang.StringBuilder

fun numUniqueEmails(emails: Array<String>): Int {
    val set = hashSetOf<String>()
    emails.forEach {
        val sb = StringBuilder()
        var preAt = true
        var plus = false
        it.forEach {
            if (preAt) {
                if (it == '@') {
                    sb.append(it)
                    preAt = false
                } else if (plus || it == '.') {

                } else if (it == '+') {
                    plus = true
                } else {
                    sb.append(it)
                }
            } else {
                sb.append(it)
            }
        }
        set.add(sb.toString())
    }

    return set.size
}