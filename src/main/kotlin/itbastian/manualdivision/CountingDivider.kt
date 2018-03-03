package itbastian.manualdivision

class CountingDivider(dividend: Int, divisor: Int) {
    private val dividend = dividend
    private val divisor = divisor

    private var quotient: Int = -1
    private var remainder: Int = -1

    fun getQuotient(): Int {
        if (quotient == -1) throw IllegalStateException("Allways call divide() first!")
        return quotient
    }

    fun getRemainder(): Int {
        if (remainder == -1) throw IllegalStateException("Allways call divide() first!")
        return remainder
    }

    //this could also be done recursively
    fun divide() {
        var multiple = divisor
        var factor = 1
        while (dividend >= multiple) {
            factor++
            multiple += divisor
        }
        quotient = (factor - 1)
        remainder = dividend - (multiple - divisor)
    }
}