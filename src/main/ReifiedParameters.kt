package main

import java.math.BigDecimal

fun main() {
    val mixedList: List<Any> = listOf("string", 1, BigDecimal(22.5), "fall", BigDecimal(-4442.2))
    val bigDecimalOnly = getElementsOfType<BigDecimal>(mixedList)
    for (i in bigDecimalOnly) {
        println(i)
    }

}

// declare a func as inline and type parameter as a reified
// => can check the generic type at runtime, type not erased anymore
// only use when want to check the type of T inside the func
inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {
    var newList: MutableList<T> = mutableListOf()
    for (e in list) {
        if (e is T) { // Cannot check for instance of erased type: T
            newList.add(e)
        }
    }

    return newList
}
