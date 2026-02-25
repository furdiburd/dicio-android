package org.dicio.skill.standard.construct

import org.dicio.numbers.parser.param.ParserParams
import org.dicio.numbers.unit.Number
import org.dicio.skill.standard.util.MatchHelper

/**
 * For [shortScale], [preferOrdinal] and [integerOnly] parameter descriptions, see
 * [org.dicio.numbers.parser.param.ExtractNumberParams].
 */
class NumberConstruct(
    name: String,
    weight: Float,
    bonusIfLargestPossible: Float,
    private val shortScale: Boolean,
    private val preferOrdinal: Boolean,
    private val integerOnly: Boolean,
) : RangesConstruct<Number>(name, weight, bonusIfLargestPossible) {

    override fun parserParams(helper: MatchHelper): ParserParams<Number>? {
        return helper.parserFormatter
            ?.extractNumber(helper.userInput)
            ?.shortScale(shortScale)
            ?.preferOrdinal(preferOrdinal)
            ?.integerOnly(integerOnly)
    }

    override fun uniqueKeyForCaching(): String {
        return "${this::class.simpleName}: shortScale=$shortScale, preferOrdinal=$preferOrdinal, " +
                "integerOnly=$integerOnly"
    }
}
