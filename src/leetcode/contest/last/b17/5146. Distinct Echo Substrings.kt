package leetcode.contest.last.b17

import leetcode.contest.utils.print

// 滚动Hash
// 前缀和
// Rabin-Karp
fun main(args: Array<String>) {
    val s = Solution5146()
//    s.distinctEchoSubstrings("abcabcabc").print()
    s.distinctEchoSubstrings("leetcodeleetcode").print()
//    s.distinctEchoSubstrings("yexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzltyexodmnzlt").print()
//    s.distinctEchoSubstrings("ibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynocibnlogcpqhuabiqtjmcpmjzzgxslnekyaiovaidcbbblnywdchfcefzbfoczkoxpypszpfptirigscjhduhysnhydtirynowynoc").print()
//    s.distinctEchoSubstrings("wdyihepunnmlqjkpnrrzjdnysubneoiafptyurqyoiglsodisssyouhcjpwvdwfnboodwukaizlsifotxxavqybwmxpanaswhhfikcucnmdeqiyttkdqyhomzpfasrmmiurrouxbotovucdmqesiyrdkhlxbnbowwuetdyzhbkimokqqpwhdlxxdbktstkvseiylcrfgmyiatkjqsuwhbkbxuatiolxnhespqvgppzczakrzvhmkxakyipjtsaiyfbxwgrbqqfdrebrtryxdzghlnqgttldoiwezugexbdqikooyccjbflfmowgugwnizlmbtlruldgjriyngfhcigonvdgtjclopdzzwslglnwxjnxepcxcxwofmnkbkpcntxxmoomluhzkjidzxbchtbctinlqrlgihrnppvvqhkeasftmsijgqgntpoxsfszuzpvhvrxbxpfqrlgafxssaiyiismmjiuopbslrdxdzcnupdaeprmgzujmznhmecpzppbkjhlueynamrjgpxqwsvoyyhbmtnexylmfuemcduusueuxpsgfooultqfeuzhlxiyjquagryzsxpabbtmmypbgjzqewsrvtnxvmoamnuamixublfcxlecdpjpdmcztdrygvukldkiooenwkuqkmgllhppvqiqbawddynaqaejvqaqdeuwtqtcfxvbydhiwkrkekazxaftzeqrwsjqrrtorjfsonshmkzwdvexfobceyclpurtdaotjoozawhhvxkesbnauvbfafrvoewmxamxsxdkvhfywfzqbwnuoyqotmyuyveuallhrwuwimuefmzprwmwhasarytunalgebijmlupxchiiqvzeeelprgwbdsgwnjzjhkvehlsgwynuocjhtjehuidszgqbiuvhtbxsegogbffekerpidkuqqvmpwlsaneqanzwwqdjvskamjmdrjzwkugzvppfenlbrapsnnaozqiwqatkqqnfmnxbdgfztoticwvjzcwolzcrucposxjacpafzbvbcmgugtpdkqfdyrpjxnzpnycbqqxwrvnpoerkutiucekgyfyddfpddqegauyuaarmqarwizvswquybdhirqincciydlqeuvlkiivqudnyuqsgrquiupwhpgvwltwzsqtiaqixnvtvqgbsmauditfeqevpinlxmdmjsnczuukbihgovjnejeknwywnneuhjtumujlhpeikfvnbscwmfzhltswbnqkqkrqfqfdzyvnlcpuevhjcyglshlvblochtqcfjjeqeowkowtwoysvvzraxgmvaeuogoahndfgzwohqbiuhlofablccghrcahygjhjiboufjhtznxxdewlsagxhbjmqrygvkikpnoxuubzwqjrnprzpggreqfpawnynqmmzkhexjjcrhzckgfmpkwyuwsqkspjylnzteirhqlbnecejifjliygjxoepvzterssaplerwbnppbivevuhsxuiczmyiuvdsovqnrazsuyuufiaksphalquhoxwwsmoyicmklqcqstorqhemmqsnwfcaznodlogqwhgdkvfnxkgwmlidtxfoulzqbpxjdrzmfgnvcvghwwtznqkvxtcvpfhxykqwclocogyqqdqbjoqvrwgxrflnnzealdadyayxxpnyhkkiueejbysiggloswuydlpvskkdcytwbbdkcmtpzrglxgxilmnkkqxzweimvrcqflqjmcweqbjztwuutzqnninjremjrshckfcycxhgxxpbzulubrjhiiighpzbqwltlfcqbxqdgumwsfcztsgnkbsxojeefeddtbtyztseebyqhqcfeacndmixmlcbnpproynpgiqbktzlawzrgjzqlbnnaskrxywwaikjfdztqnqvigpnvmtqtuzrgnkzbfmigykhvsuabstexeqmmywbaospgtfggqgxdfmgtnrwzxzqbqctnezkbfjsmvknqm").print()
//    s.distinctEchoSubstrings("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").print()
//    s.distinctEchoSubstrings("tkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnratkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnra").print()
}

class Solution5146 {
    fun distinctEchoSubstrings(text: String): Int {
        val n = text.length
        val mod = 1000000007
        val base = 31
        val pre = LongArray(n + 1) { 0 }
        val mul = LongArray(n + 1) { 0 }
        mul[0] = 1
        for (i in 1..n) {
            pre[i] = (pre[i - 1] * base + text[i - 1].toInt()) % mod
            mul[i] = mul[i - 1] * base % mod
        }

        fun getHash(l: Int, r: Int): Long {
            return (pre[r + 1] - pre[l] * mul[r - l + 1] % mod + mod) % mod
        }

        val ans = hashSetOf<Long>()
        for (i in 0 until n) {
            for (j in i + 1..n) {
                val l = j - i
                if (j + l <= n) {
                    println("$i, ${j - 1} : ${getHash(i, j - 1)} && $j , ${j + l - 1} : ${getHash(j, j + l - 1)}")
                    if (getHash(i, j - 1) == getHash(j, j + l - 1)) {
                        ans.add(getHash(i, j - 1))
                    }
                }
            }
        }
        return ans.size
    }

//    fun distinctEchoSubstrings(text: String): Int {
//        val ans = HashSet<String>()
//        for (i in text.indices) {
//            for (j in i + 1 until text.length step 2) {
//                val a = text.substring(IntRange(i, j))
//                if (check(a)) {
//                    ans.add(a)
//                }
//            }
//        }
//        return ans.size
//    }
//
//    private fun check(a: String): Boolean {
//        var i = 0
//        var j = a.length / 2
//        while (a[i] == a[j]) {
//            i++
//            j++
//            if (j > a.lastIndex) {
//                return true
//            }
//        }
//        return false
//    }
}