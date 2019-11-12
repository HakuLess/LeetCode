package leetcode.contest.utils

/**
 * Longest Common SubString
 * */
fun LCSubStr(X: CharArray, Y: CharArray, m: Int, n: Int): Int {
    // Create a table to store lengths of longest common suffixes of
    // substrings. Note that LCSuff[i][j] contains length of longest
    // common suffix of X[0..i-1] and Y[0..j-1]. The first row and
    // first column entries have no logical meaning, they are used only
    // for simplicity of program
    val lcsStr = Array(m + 1) { IntArray(n + 1) }
    var result = 0  // To store length of the longest common substring

    // Following steps build LCSuff[m+1][n+1] in bottom up fashion
    for (i in 0..m) {
        for (j in 0..n) {
            if (i == 0 || j == 0)
                lcsStr[i][j] = 0
            else if (X[i - 1] == Y[j - 1]) {
                lcsStr[i][j] = lcsStr[i - 1][j - 1] + 1
                result = maxOf(result, lcsStr[i][j])
            } else
                lcsStr[i][j] = 0
        }
    }
    return result
}

/**
 * Longest Common SubSequence
 * */
fun <T> lcs(v1: List<T>, v2: List<T>, m: Int, n: Int): Int {
    val dp = Array(m + 1) { IntArray(n + 1) }

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (i in 0..m) {
        for (j in 0..n) {
            if (i == 0 || j == 0)
                dp[i][j] = 0
            else if (v1[i - 1] == v2[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1
            else
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
        }
    }
    return dp[m][n]
}

fun kmpSearch(pat: String, txt: String, func: (Int) -> Unit) {
    val m = pat.length
    val n = txt.length

    // create lps[] that will hold the longest
    // prefix suffix values for pattern
    val lps = IntArray(m)
    var j = 0 // index for pat[]

    // Preprocess the pattern (calculate lps[]
    // array)
    computeLPSArray(pat, m, lps)

    var i = 0 // index for txt[]
    while (i < n) {
        if (pat[j] == txt[i]) {
            j++
            i++
        }
        if (j == m) {
            println("Found pattern at index " + (i - j))
            func(i - j)
            j = lps[j - 1]
        } else if (i < n && pat[j] != txt[i]) {
            // Do not match lps[0..lps[j-1]] characters,
            // they will match anyway
            if (j != 0)
                j = lps[j - 1]
            else
                i += 1
        }// mismatch after j matches
    }
}

fun computeLPSArray(pat: String, m: Int, lps: IntArray) {
    // length of the previous longest prefix suffix
    var len = 0
    var i = 1
    lps[0] = 0 // lps[0] is always 0

    // the loop calculates lps[i] for i = 1 to m-1
    while (i < m) {
        if (pat[i] == pat[len]) {
            len++
            lps[i] = len
            i++
        } else {
            if (len != 0) {
                len = lps[len - 1]
            } else {
                lps[i] = len
                i++
            }
        }
    }
}