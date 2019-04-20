package leetcode.normal

fun main(args: Array<String>) {
    diStringMatch("IDID").forEach {
        print("$it, ")
    }
}

fun diStringMatch(S: String): IntArray {
    val ans = IntArray(S.length + 1)

    var ptr = 0
    for (i in 0 until S.length) {
        if (S[i] == 'I') {
            ans[i] = ptr
            ptr++
            println("$i ${ans[i]}")
        }
    }

    ans[S.length] = ptr
    ptr++
    for (i in S.length - 1 downTo 0) {
        if (S[i] == 'D') {
            ans[i] = ptr
            ptr++
            println("$i ${ans[i]}")
        }
    }


    return ans
}