package de.taichj.charakter.roll

import kotlin.math.min
import kotlin.random.Random

/**
 * Wahrscheinlichkeiten (Erfolg):
 * Max With Starsign 98%
 * Max Without Starsign 88%
 * Half With Starsign 79%
 * Half Without Starsign 58%
 * Min With Starsign 25%
 * Min Without Starsign 13%
 *
 * Wahrscheinlichkeit (Story):
 * Max With Starsign 31
 * Max Without Starsign 25
 * Half With Starsign 28
 * Half Without Starsign 25
 * Min With Starsign 18
 * Min Without Starsign 25
 */
class RollResult(
    xd6Attr: Int = 0,
    xd6Fert: Int = 0,
    xd6Bonus: Int = 0,
    xd6Item: Int = 0,
    var d12: Int = Random.nextInt(1, 13),
    sternzeichen: Boolean = false
) {
    var sternzeichenD12: Int? = null
    var d6 = arrayListOf<Int>()
    var d6Render: List<RenderDice>
    var successes = 0
    var schaden = 0
    var zerstoerung = 0
    var success = false
    var story = false

    init {
        repeat(xd6Attr + xd6Bonus + xd6Fert + xd6Item) {
            d6.add(Random.nextInt(1, 7))
        }
        schaden = d6.take(xd6Attr).count { it == 1 }
        zerstoerung = d6.takeLast(xd6Item).count { it == 1 }
        successes = d6.count { it >= 4 }
        successes += d6.count { it == 5 }

        d6Render = d6.mapIndexed { wert, pos ->
            RenderDice(
                wert, when (pos) {
                    in 0..xd6Attr -> "red"
                    in xd6Attr..xd6Fert + xd6Attr -> "blue"
                    in xd6Attr + xd6Fert..xd6Attr + xd6Fert + xd6Bonus -> "orange"
                    else -> "green"
                }, when (wert) {
                    4, 6 -> "red"
                    5 -> "yellow"
                    else -> "black"
                }
            )
        }

        if (sternzeichen) {
            sternzeichenD12 = Random.nextInt(1, 13)

            d12 = if (sternzeichenD12 == 5 || d12 == 5) {
                if (successes >= 5) {
                    5
                } else {
                    if (sternzeichenD12 == 5) d12 else sternzeichenD12!!
                }
            } else if (sternzeichenD12 == 12 || d12 == 12) {
                12
            } else {
                min(d12, sternzeichenD12!!)
            }
        }
        success = (successes >= d12 || d12 == 12) && d12 != 11
        if (d12 in arrayOf(5, 11, 12)) {
            story = true
        }
    }
}
