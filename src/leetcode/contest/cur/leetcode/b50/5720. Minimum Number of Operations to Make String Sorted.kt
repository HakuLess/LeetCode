package leetcode.contest.cur.leetcode.b50

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution5720()
    s.makeStringSorted("cba").print()
//    s.makeStringSorted("cab").print()
//    s.makeStringSorted("bac").print()
//    s.makeStringSorted("cdbea").print()
    s.makeStringSorted("aabaa").print()
    s.makeStringSorted("cdbea").print()
    s.makeStringSorted("leetcodeleetcodeleetcode").print()
    s.makeStringSorted("mvxwnroyyttrkmilzcotwxmutmgerapwruvpipuzyunppbohiiahwifyljdhuwgrxkvrsynyvvjzfiyshafrrnkdhdzoizramicykpwfhomlcrpyeukiqdzmbcsoxniwwnqxxccnkfryqapjynfntdlmmrqrmpaeqtohommzphdnatrgvefvcpxwkyrahrmdagfdxdwbpgmosdsiwyqbhpvjvteaizsfobqxtddetcgrrjmbaetekdwmykbeysmsairqptueltrnnlnqovsfpnrcveebpqwajfpatchdfysrgbinptwpudqkvknjmffidmxrnqsekxjstvondnktkaceblkggagxduubxrdotayemdumezpdxgwgdaergwlgihskjwfggclpxucsjmlrtgihnfvpygfmakmouiqxgbarxoodxggykccakcifipmsyxntvdognhifybykfhgcogywndsgglzssymrradsgpseqksbbpywtkkvcxrrjrwiollpyamqhosegrmatgxjvimqmeyxmxxuujxefrudkuklbadeowgvduhefkkatejophaoefyyhyjpynjyqcyhrwyeeoqmjojglqzzhsonzwhkgwlqtuwartcqmzertrgdhmsxynpgwikhiiuwqcphmadtmzuxzeqvyaqidvtzggmiontdkxyznojimdwjkrmqxzwjkpqjaiwmrxzxilkjbgnpernkksouqbsvefrgpnsyqncdflrbldzischmrhufsaacqwjzhctqeqkzlrobwihldfeppdezzimepuorzrjkltygpzajeuazpvishqdeyhxacylbdftojtfipzdouqeorqzwujksqtezvacuyhmenlbcxbdtdiogqbqnslttlugmwbwogfvlznvnfoguzjknjpaqjnmyaqkwnpacavnyfpxbfvsaplcaqvvhypsztyiplkhmzzlamxnqpyealqhwygsgnjyabdagrtovshyulabkdviktpdgxrxtarflmljjhbxoyhdtyqzesivfiuvgzcqkameoxgbqsmnbzvnbspqdkoecnjzeolbxhxzptuanhipndsgtrhnnefohxcwyyullokuplbblyqmgpxquhuuqluzheivphtibsqgtwxkhhcsdcdmmaxwgcmieygybqbdxogqxtkfkhvfenmqfdxgmnudohegfnbzsqtufymbbjqkxqexyoaisrvsnlduacofpabwtianvjtymflrejxyexqvxmkqtesnvwoizotmbcemnnfzohhxqdtysahcapsoegmlfiujskljwyueunuzkftavwvxvydbiokxusgrvblrvnfmjivbsqvjzoyjzlpkbekigephxcmkhovkdltzweqvvcduocbcsjmoniuevltyvkowgnfnekptcfylhfjiluthsxuburqprcjdjwopsnmxazmideswrvswntxxyidbaunmdtoxvtkoiuifxxlqramvgvaiowdnsmobtqkypeklckstlhbaahluurbozryjtzdwxsuxexknbsvkkqyrsmmzkrfzqzbfdyezdcoplvdvzauclnbigvnrvnwxtuyghuvbbnpgdjmntskgdoppmclbfsdvhicegzwzmuhkliqhqmdavcwrfumosxzyvglnodzzlkviuhebtstjrilxaxvqyohulqzgktzxncujhbckvtrdgtwebemqacsueujorucftyngmrnpskgwxxnsgzqiysigmfksyjryntnqoslzuyeoivndspgmmtrbpphbmpezbkildfwehespqvqnrskbgkisqupnxlgcngwmoeghpulgoepxblmlentbyltdyyacnkeevgqqpyyzinshqsvkheuotabhjjlfjmzfyyttrjqpwmay").print()
}

class Solution5720 {
    fun makeStringSorted(s: String): Int {
        val mod = 1000000007L
        return ((GFG.lexRank(s) - 1) % mod).toInt()
    }
}

internal object GFG {
    val mod = 1000000007L.toBigInteger()

    val seen = HashMap<BigInteger, BigInteger>()

    fun fac(n: BigInteger): BigInteger {
        if (n in seen) return seen[n]!!
        return (if (n == BigInteger.ZERO || n == BigInteger.ONE) BigInteger.ONE else (n * fac(n - BigInteger.ONE))).also {
            seen[n] = it
        }
    }

    fun lexRank(s: String): Int {
        val n = s.length.toLong()
        var t_count: BigInteger = BigInteger.ONE
        for (i in 0 until n) {
            var less_than: Long = 0
            for (j in i + 1 until n) {
                if (s[i.toInt()] > s[j.toInt()]) {
                    less_than += 1
                }
            }
            val d_count = IntArray(26)
            for (j in i until n) {
                val c = s[j.toInt()] - 'a'
                d_count[c]++
            }
            var d_fac: BigInteger = 1L.toBigInteger()
            for (ele in d_count) {
                d_fac *= fac(ele.toBigInteger())
            }
            t_count += ((fac((n - i - 1).toBigInteger()) * less_than.toBigInteger()) / d_fac).mod(mod)
            t_count = t_count.mod(mod)
        }
        return t_count.mod(mod).toInt()
    }
}

