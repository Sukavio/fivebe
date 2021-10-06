package de.taichj.charakter.roll

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.RepeatedTest

class RollResultTest {

    @RepeatedTest(100)
    fun `Test Success Rate with 100 max Dices`() {
        var times = 1000
        var maxWithStarsign = IntRange(0, 100).count { RollResult(5, 6, 5, 2, sternzeichen = true).success }
        var maxWithOutStarsign = IntRange(0, 100).count { RollResult(5, 6, 5, 2).success }
        var halfWithStarsign = IntRange(0, 100).count { RollResult(3, 4, 2, 0, sternzeichen = true).success }
        var halfWithOutStarsign = IntRange(0, 100).count { RollResult(3, 4, 2, 0).success }
        var minWithStarsign = IntRange(0, 100).count { RollResult(1, 0, 0, 0, sternzeichen = true).success }
        var minWithOutStarsign = IntRange(0, 100).count { RollResult(1, 0, 0, 0).success }
        repeat(times) {
            maxWithStarsign += IntRange(0, 100).count { RollResult(5, 6, 5, 2, sternzeichen = true).success }
            maxWithOutStarsign += IntRange(0, 100).count { RollResult(5, 6, 5, 2).success }
            halfWithStarsign += IntRange(0, 100).count { RollResult(3, 4, 2, 0, sternzeichen = true).success }
            halfWithOutStarsign += IntRange(0, 100).count { RollResult(3, 4, 2, 0).success }
            minWithStarsign += IntRange(0, 100).count { RollResult(1, 0, 0, 0, sternzeichen = true).success }
            minWithOutStarsign += IntRange(0, 100).count { RollResult(1, 0, 0, 0).success }
        }
        maxWithStarsign /= ++times
        maxWithOutStarsign /= ++times
        halfWithStarsign /= ++times
        halfWithOutStarsign /= ++times
        minWithStarsign /= ++times
        minWithOutStarsign /= ++times
        println(" * Max With Starsign $maxWithStarsign")
        println(" * Max Without Starsign $maxWithOutStarsign")
        println(" * Half With Starsign $halfWithStarsign")
        println(" * Half Without Starsign $halfWithOutStarsign")
        println(" * Min With Starsign $minWithStarsign")
        println(" * Min Without Starsign $minWithOutStarsign")
        Assertions.assertTrue(maxWithStarsign == 98)
        Assertions.assertEquals(maxWithOutStarsign, 88)
        Assertions.assertTrue(halfWithStarsign in 79..80)
        Assertions.assertTrue(halfWithOutStarsign in 57..58)
        Assertions.assertEquals(minWithStarsign, 25)
        Assertions.assertTrue(minWithOutStarsign in 13..14)
    }

    @RepeatedTest(100)
    fun `Test Story Rate with 100 max Dices`() {
        var times = 10000
        var maxWithStarsign = IntRange(0, 100).count { RollResult(5, 6, 5, 2, sternzeichen = true).story }
        var maxWithOutStarsign = IntRange(0, 100).count { RollResult(5, 6, 5, 2).story }
        var halfWithStarsign = IntRange(0, 100).count { RollResult(3, 4, 2, 0, sternzeichen = true).story }
        var halfWithOutStarsign = IntRange(0, 100).count { RollResult(3, 4, 2, 0).story }
        var minWithStarsign = IntRange(0, 100).count { RollResult(1, 0, 0, 0, sternzeichen = true).story }
        var minWithOutStarsign = IntRange(0, 100).count { RollResult(1, 0, 0, 0).story }
        repeat(times) {
            maxWithStarsign += IntRange(0, 100).count { RollResult(5, 6, 5, 2, sternzeichen = true).story }
            maxWithOutStarsign += IntRange(0, 100).count { RollResult(5, 6, 5, 2).story }
            halfWithStarsign += IntRange(0, 100).count { RollResult(3, 4, 2, 0, sternzeichen = true).story }
            halfWithOutStarsign += IntRange(0, 100).count { RollResult(3, 4, 2, 0).story }
            minWithStarsign += IntRange(0, 100).count { RollResult(1, 0, 0, 0, sternzeichen = true).story }
            minWithOutStarsign += IntRange(0, 100).count { RollResult(1, 0, 0, 0).story }
        }
        maxWithStarsign /= ++times
        maxWithOutStarsign /= ++times
        halfWithStarsign /= ++times
        halfWithOutStarsign /= ++times
        minWithStarsign /= ++times
        minWithOutStarsign /= ++times
        println(" * Max With Starsign $maxWithStarsign")
        println(" * Max Without Starsign $maxWithOutStarsign")
        println(" * Half With Starsign $halfWithStarsign")
        println(" * Half Without Starsign $halfWithOutStarsign")
        println(" * Min With Starsign $minWithStarsign")
        println(" * Min Without Starsign $minWithOutStarsign")
        Assertions.assertTrue(maxWithStarsign == 31)
        Assertions.assertTrue(maxWithOutStarsign == 25)
        Assertions.assertTrue(halfWithStarsign == 28)
        Assertions.assertTrue(halfWithOutStarsign == 25)
        Assertions.assertTrue(minWithStarsign == 18)
        Assertions.assertTrue(minWithOutStarsign == 25)
    }
}
