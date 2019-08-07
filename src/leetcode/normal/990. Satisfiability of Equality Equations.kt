package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    equationsPossible(arrayOf("w==s", "p==q", "r==i", "v==s", "i==o", "k==g", "c==f", "n==v", "a==w", "d==w", "v==s", "l==m")).print()
}

fun equationsPossible(equations: Array<String>): Boolean {
    val array = CharArray(26)
    val equals = equations.filter {
        it[1] == '='
    }

//    equals.forEach {
//        println("${it[0]}  ${it[3]}")
//    }

    for (i in 'a'..'z') {
        fillArray(i, array, equals)
    }

    array.forEachIndexed { index, c ->
        println("${'a' + index}  $c")
    }
    equations.filter {
        it[1] == '!'
    }.forEach {
        if (array[it[0] - 'a'] in 'a'..'z' &&
                array[it[3] - 'a'] in 'a'..'z' &&
                array[it[3] - 'a'] == array[it[0] - 'a'] ||
                it[3] == it[0]) {
            return false
        }
    }

    return true
}

fun fillArray(ch: Char, array: CharArray, equals: List<String>) {
//    if (array[ch - 'a'] in 'a'..'z') {
//        return
//    }
    equals.filter {
        (it[0] == ch || it[3] == ch) && (array[it[0] - 'a'] != array[it[3] - 'a'] ||
                array[it[0] - 'a'] !in 'a'..'z' || array[it[3] - 'a'] !in 'a'..'z')
    }.forEach {
        println("cal ${it[0]}:${array[it[0] - 'a']}  ${it[3]}:${array[it[3] - 'a']}")
        when {
            array[it[0] - 'a'] in 'a'..'z' -> {
                array[it[0] - 'a'] = array[it[0] - 'a']
                array[it[3] - 'a'] = array[it[0] - 'a']
                fillArray(it[3], array, equals)
            }
            array[it[3] - 'a'] in 'a'..'z' -> {
                array[it[0] - 'a'] = array[it[3] - 'a']
                array[it[3] - 'a'] = array[it[3] - 'a']
                fillArray(it[0], array, equals)
            }
            else -> {
                array[it[0] - 'a'] = ch
                array[it[3] - 'a'] = ch
//                println("${it[0]} ${it[3]}")
                fillArray(it[0], array, equals)
                fillArray(it[3], array, equals)
            }
        }
    }
}