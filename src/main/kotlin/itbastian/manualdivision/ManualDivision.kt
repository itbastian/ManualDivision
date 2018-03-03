package itbastian.manualdivision

class ManualDivision {
    companion object Helpers{

        //This is a little shortcut: Using multiplication to skip string concatenations.
        fun addDigit(number: Int, digit: Char): Int {
            return number * 10 + decimalDigitValue(digit)
        }

        fun appendDigits(quotient: String, multiplesInIncrementedChunk: Int)  =
                quotient + multiplesInIncrementedChunk.toString()
    }

    var remainder: String = ""

    fun divide(dividend: String, divisor: String): String {
        return divide(0, dividend.iterator(), divisor.toInt(), "")
    }

    //Using the Iterator is dangerous since the deeper recursions change the object for all recursions.
    //An immutable object should be created for each step.
    fun divide(chunk: Int, dividend: Iterator<Char>, divisor: Int, quotient: String): String {
        if (!dividend.hasNext()) {
            remainder = chunk.toString()
            return toZeroIfEmpty(quotient)
        }

        var incrementedChunk = addDigit(chunk, dividend.next())

        if (incrementedChunk == 0) {
            return divide(0,dividend,divisor, appendDigits(quotient, 0))
        }

        if (incrementedChunk < divisor) {
            return divide(incrementedChunk, dividend, divisor, quotient)
        }

        val countingDividerForIncrementedChunk:CountingDivider= CountingDivider(incrementedChunk,divisor)
        countingDividerForIncrementedChunk.divide()
        return divide(
                countingDividerForIncrementedChunk.getRemainder(),
                dividend,
                divisor,
                appendDigits(quotient, countingDividerForIncrementedChunk.getQuotient())
        )
    }

}