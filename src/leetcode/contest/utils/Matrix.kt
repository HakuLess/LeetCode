package leetcode.contest.utils

// n行 m列 矩阵
class Matrix(val n: Int, val m: Int, val matrix: Array<IntArray>) {

    override fun toString(): String {
        return matrix.joinToString { it.joinToString() }
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Matrix) return false
        return this.toString() == other.toString()
    }

    override fun hashCode(): Int {
        var result = n
        result = 31 * result + m
        result = 31 * result + matrix.contentDeepHashCode()
        return result
    }
}

// 向右旋转90°
fun Matrix.rotate() {
    if (n != m) {
        println("Rotate Error")
    }
    for (i in 0 until (n + 1) / 2) {
        for (j in 0 until n / 2) {
            val temp = matrix[n - 1 - j][i]
            matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1]
            matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i]
            matrix[j][n - 1 - i] = matrix[i][j]
            matrix[i][j] = temp
        }
    }
}

fun Array<IntArray>.toMatrix(): Matrix {
    val n = this.size
    val m = this[0].size
    return Matrix(n, m, this)
}

fun String.toMatrix(): Matrix {
    return this.trim(']').split("],[").map {
        it.toIntArray()
    }.toTypedArray().toMatrix()
}