package leetcode.normal

fun hammingDistance(x: Int, y: Int): Int {
    return Integer.toBinaryString(x xor y).count {
        it == '1'
    }
}