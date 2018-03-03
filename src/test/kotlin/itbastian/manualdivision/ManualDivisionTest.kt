package itbastian.manualdivision

import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

class ManualDivisionTest {
    @Test
    fun divide_by_1() {
        val division = ManualDivision()
        Assert.assertEquals("1", division.divide("1", "1"))
        Assert.assertEquals("2", division.divide("2", "1"))
        Assert.assertEquals("3", division.divide("3", "1"))
        Assert.assertEquals("4", division.divide("4", "1"))
        Assert.assertEquals("5", division.divide("5", "1"))
        Assert.assertEquals("10", division.divide("10", "1"))
        Assert.assertEquals("100", division.divide("100", "1"))
        Assert.assertEquals("3333", division.divide("3333", "1"))
        Assert.assertEquals("15000", division.divide("15000", "1"))
    }

    @Test
    fun divide_1() {
        val division = ManualDivision()
        Assert.assertEquals("0", division.divide("1", "2"))
        Assert.assertEquals("0", division.divide("1", "3"))
        Assert.assertEquals("0", division.divide("1", "10"))
        Assert.assertEquals("0", division.divide("1", "100"))
        Assert.assertEquals("0", division.divide("1", "1000"))
        Assert.assertEquals("0", division.divide("1", "55"))
        Assert.assertEquals("0", division.divide("1", "57631"))
        Assert.assertEquals("0", division.divide("1", "421"))
        Assert.assertEquals("0", division.divide("1", "9999"))
    }

    @Test
    fun divide_clean() {
        val division = ManualDivision()
        Assert.assertEquals("4", division.divide("8", "2"))
        Assert.assertEquals("4", division.divide("16", "4"))
        Assert.assertEquals("4", division.divide("88", "22"))
        Assert.assertEquals("33", division.divide("9900", "300"))
        Assert.assertEquals("13", division.divide("117", "9"))
    }

    @Test
    fun divide_rest() {
        val division = ManualDivision()
        Assert.assertEquals("4", division.divide("9", "2"))
        Assert.assertEquals("4", division.divide("19", "4"))
        Assert.assertEquals("4", division.divide("101", "22"))
        Assert.assertEquals("33", division.divide("10156", "300"))
        Assert.assertEquals("13", division.divide("121", "9"))
    }

    @Test
    fun count_multiples() {
        Assert.assertEquals(1, ManualDivision.countMultiples(1, 1))
        Assert.assertEquals(2, ManualDivision.countMultiples(2, 1))
        Assert.assertEquals(3, ManualDivision.countMultiples(3, 1))
        Assert.assertEquals(4, ManualDivision.countMultiples(4, 1))
        Assert.assertEquals(10, ManualDivision.countMultiples(10, 1))
        Assert.assertEquals(4, ManualDivision.countMultiples(24, 5))
        Assert.assertEquals(5, ManualDivision.countMultiples(25, 5))
        Assert.assertEquals(5, ManualDivision.countMultiples(26, 5))
        Assert.assertEquals(5, ManualDivision.countMultiples(27, 5))
        Assert.assertEquals(5, ManualDivision.countMultiples(28, 5))
        Assert.assertEquals(5, ManualDivision.countMultiples(29, 5))
        Assert.assertEquals(6, ManualDivision.countMultiples(30, 5))
        Assert.assertEquals(17, ManualDivision.countMultiples(7893, 456))
        Assert.assertEquals(0, ManualDivision.countMultiples(0, 1))
        Assert.assertEquals(0, ManualDivision.countMultiples(0, 43432))
        Assert.assertEquals(0, ManualDivision.countMultiples(0, 2))
    }
}

private fun ManualDivision.Helpers.countMultiples(dividend: Int, divisor: Int): Int {
    val divider = CountingDivider(dividend, divisor)
    divider.divide()
    return divider.getQuotient()
}
