package leetcode

fun brokenCalc(X: Int, Y: Int): Int {
    if (X >= Y) {
        return X - Y
    }

    return 1 + if (Y % 2 == 0) {
        brokenCalc(X, Y / 2)
    } else {
        brokenCalc(X, Y + 1)
    }
}