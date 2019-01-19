package leetcode

fun main(args: Array<String>) {
//    val J = "aA"
//    val S = "aAAbbbb"
    val J = "z"
    val S = "ZZ"
    print(numJewelsInStones(J, S))
}

fun numJewelsInStones(J: String, S: String): Int {
    return S.toCharArray().count { it in J.toCharArray() }
}