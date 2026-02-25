package org.dicio.skill.standard.construct

import org.dicio.numbers.parser.param.ParserParams
import org.dicio.numbers.unit.Duration
import org.dicio.skill.standard.util.MatchHelper

/**
 * For [shortScale] parameter description, see
 * [org.dicio.numbers.parser.param.ExtractDurationParams].
 */
class DurationConstruct(
    name: String,
    weight: Float,
    bonusIfLargestPossible: Float,
    private val shortScale: Boolean,
) : RangesConstruct<Duration>(name, weight, bonusIfLargestPossible) {

    override fun parserParams(helper: MatchHelper): ParserParams<Duration>? {
        return helper.parserFormatter
            ?.extractDuration(helper.userInput)
            ?.shortScale(shortScale)
    }

    override fun uniqueKeyForCaching(): String {
        return "${this::class.simpleName}: shortScale=$shortScale"
    }
}
