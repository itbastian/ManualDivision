package itbastian.manualdivision

fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
    return c.toInt() - '0'.toInt() // Explicit conversions to numbers
}

fun toZeroIfEmpty(s: String): String {
    if (s.isEmpty()) {
        return "0"
    } else {
        return s
    }
}