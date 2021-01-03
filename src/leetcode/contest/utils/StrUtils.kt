package leetcode.contest.utils

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