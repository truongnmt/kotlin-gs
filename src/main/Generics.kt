package main

import java.math.BigDecimal

fun main() {
    val list: MutableList<String> = mutableListOf("Hello")
    list.add("another string")
    list.printCollection()

    val bdList = mutableListOf(BigDecimal(-33.45), BigDecimal(393.92))
    bdList.printCollection()
}

// <T> after fun is type parameter declaration
fun <T> List<T>.printCollection() {
    for (i in this) {
        println(i)
    }
}
