package com.techlads.swvl.utils.mappers


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.utils.mappers
 */


interface Mapper<I, O> {
    fun map(input: I?): O
}