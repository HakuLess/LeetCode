package leetcode.contest.cur.leetcode.b50

import leetcode.contest.utils.getFac
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5720()
    s.makeStringSorted("cba").print()
//    s.makeStringSorted("cab").print()
//    s.makeStringSorted("bac").print()
//    s.makeStringSorted("cdbea").print()
//    s.makeStringSorted("aabaa").print()
//    s.makeStringSorted("cdbea").print()
//    s.makeStringSorted("leetcodeleetcodeleetcode").print()
//    s.makeStringSorted("mvxwnroyyttrkmilzcotwxmutmgerapwruvpipuzyunppbohiiahwifyljdhuwgrxkvrsynyvvjzfiyshafrrnkdhdzoizramicykpwfhomlcrpyeukiqdzmbcsoxniwwnqxxccnkfryqapjynfntdlmmrqrmpaeqtohommzphdnatrgvefvcpxwkyrahrmdagfdxdwbpgmosdsiwyqbhpvjvteaizsfobqxtddetcgrrjmbaetekdwmykbeysmsairqptueltrnnlnqovsfpnrcveebpqwajfpatchdfysrgbinptwpudqkvknjmffidmxrnqsekxjstvondnktkaceblkggagxduubxrdotayemdumezpdxgwgdaergwlgihskjwfggclpxucsjmlrtgihnfvpygfmakmouiqxgbarxoodxggykccakcifipmsyxntvdognhifybykfhgcogywndsgglzssymrradsgpseqksbbpywtkkvcxrrjrwiollpyamqhosegrmatgxjvimqmeyxmxxuujxefrudkuklbadeowgvduhefkkatejophaoefyyhyjpynjyqcyhrwyeeoqmjojglqzzhsonzwhkgwlqtuwartcqmzertrgdhmsxynpgwikhiiuwqcphmadtmzuxzeqvyaqidvtzggmiontdkxyznojimdwjkrmqxzwjkpqjaiwmrxzxilkjbgnpernkksouqbsvefrgpnsyqncdflrbldzischmrhufsaacqwjzhctqeqkzlrobwihldfeppdezzimepuorzrjkltygpzajeuazpvishqdeyhxacylbdftojtfipzdouqeorqzwujksqtezvacuyhmenlbcxbdtdiogqbqnslttlugmwbwogfvlznvnfoguzjknjpaqjnmyaqkwnpacavnyfpxbfvsaplcaqvvhypsztyiplkhmzzlamxnqpyealqhwygsgnjyabdagrtovshyulabkdviktpdgxrxtarflmljjhbxoyhdtyqzesivfiuvgzcqkameoxgbqsmnbzvnbspqdkoecnjzeolbxhxzptuanhipndsgtrhnnefohxcwyyullokuplbblyqmgpxquhuuqluzheivphtibsqgtwxkhhcsdcdmmaxwgcmieygybqbdxogqxtkfkhvfenmqfdxgmnudohegfnbzsqtufymbbjqkxqexyoaisrvsnlduacofpabwtianvjtymflrejxyexqvxmkqtesnvwoizotmbcemnnfzohhxqdtysahcapsoegmlfiujskljwyueunuzkftavwvxvydbiokxusgrvblrvnfmjivbsqvjzoyjzlpkbekigephxcmkhovkdltzweqvvcduocbcsjmoniuevltyvkowgnfnekptcfylhfjiluthsxuburqprcjdjwopsnmxazmideswrvswntxxyidbaunmdtoxvtkoiuifxxlqramvgvaiowdnsmobtqkypeklckstlhbaahluurbozryjtzdwxsuxexknbsvkkqyrsmmzkrfzqzbfdyezdcoplvdvzauclnbigvnrvnwxtuyghuvbbnpgdjmntskgdoppmclbfsdvhicegzwzmuhkliqhqmdavcwrfumosxzyvglnodzzlkviuhebtstjrilxaxvqyohulqzgktzxncujhbckvtrdgtwebemqacsueujorucftyngmrnpskgwxxnsgzqiysigmfksyjryntnqoslzuyeoivndspgmmtrbpphbmpezbkildfwehespqvqnrskbgkisqupnxlgcngwmoeghpulgoepxblmlentbyltdyyacnkeevgqqpyyzinshqsvkheuotabhjjlfjmzfyyttrjqpwmay").print()
}

class Solution5720 {
    fun makeStringSorted(s: String): Int {
        val mod = 1000000007L
        val n = s.length

        // 乘法逆元
        val (fac, invFac) = getFac(n)

        val cnt = IntArray(26)
        for (c in s) cnt[c - 'a']++
        var ans = 0L
        for (i in 0 until n) {
            for (j in 0 until s[i] - 'a') {
                if (cnt[j] == 0) continue
                cnt[j]--
                var tot = fac[n - 1 - i]
                for (k in 0..25) {
                    tot = tot * invFac[cnt[k]] % mod
                }
                ans = (ans + tot) % mod
                cnt[j]++
            }
            cnt[s[i] - 'a']--
        }
        return ans.toInt()
    }
}