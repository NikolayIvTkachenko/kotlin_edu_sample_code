package org.example.algoriyhms

fun main() {
    program8001()
    program8002()
}

fun program8001() {
    println("==> program8001")
    println()
    val num = 3749
    var result = intToRomanV2(num)
    println("result = $result")
}

fun program8002() {
    println("==> program8002")
    println()
    val num = 58
    var result = intToRomanV2(num)
    println("result = $result")
}


//Seven different symbols represent Roman numerals with the following values:
//
//Symbol	Value
//I	1
//V	5
//X	10
//L	50
//C	100
//D	500
//M	1000
//Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:
//
//If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
//If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
//Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
//Given an integer, convert it to a Roman numeral.
//
//
//
//Example 1:
//
//Input: num = 3749
//
//Output: "MMMDCCXLIX"
//
//Explanation:
//
//3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
//700 = DCC as 500 (D) + 100 (C) + 100 (C)
//40 = XL as 10 (X) less of 50 (L)
//9 = IX as 1 (I) less of 10 (X)
//Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
//Example 2:
//
//Input: num = 58
//
//Output: "LVIII"
//
//Explanation:
//
//50 = L
//8 = VIII
//Example 3:
//
//Input: num = 1994
//
//Output: "MCMXCIV"
//
//Explanation:
//
//1000 = M
//900 = CM
//90 = XC
//4 = IV

fun intToRoman(request: Int): String {
    var num = request
    val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val strs = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

    val sb = StringBuilder()

    for (i in values.indices) {
        while (num >= values[i]) {
            num -= values[i]
            sb.append(strs[i])
        }
    }
    return sb.toString()
}

fun intToRomanV2(request: Int): String {
    var num = request
    var roman = StringBuilder()

    while(num > 0) {

        var valueChange = 0;
        var chars = "";

        if(num >= 1000) {
            valueChange = 1000;
            chars = "M";
        }
        else if(num >= 900) {
            valueChange = 900;
            chars = "CM";
        }
        else if(num >= 500) {
            valueChange = 500;
            chars = "D";
        }
        else if(num >= 400) {
            valueChange = 400;
            chars = "CD";
        }
        else if(num >= 100) {
            valueChange = 100;
            chars = "C";
        }
        else if(num >= 90) {
            valueChange = 90;
            chars = "XC";
        }
        else if(num >= 50) {
            valueChange = 50;
            chars = "L";
        }
        else if(num >= 40) {
            valueChange = 40;
            chars = "XL";
        }
        else if(num >= 10) {
            valueChange = 10;
            chars = "X";
        }
        else if(num >= 9) {
            valueChange = 9;
            chars = "IX";
        }
        else if(num >= 5) {
            valueChange = 5;
            chars = "V";
        }
        else if(num >= 4) {
            valueChange = 4;
            chars = "IV";
        }
        else {
            valueChange = 1;
            chars = "I";
        }

        // No. of times 'chars' string needs to be added to 'roman' string
        var t = (num / valueChange)

        for (i in 0..<t) {
            roman.append(chars)
        }

        num -= (t * valueChange)
    }

    return roman.toString();
}