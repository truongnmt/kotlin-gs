package main

fun main() {
    val strings = listOf("spring", "summer", "fall", "winter")
    println(strings.javaClass) // java.util.Arrays$ArrayList - Immutable list

    val emptyList = emptyList<String>()
    println(emptyList.javaClass) // kotlin.collections.EmptyList

    val nullExcludedList = listOfNotNull("hello", null, "bye")
    println(nullExcludedList) // hello, bye

    val arrayList = arrayListOf(1, 2, 4)
    println(arrayList.javaClass) // java.util.ArrayList - Mutable list

    val mutableList = mutableListOf(1, 2, 3)
    println(mutableList.javaClass) // java.util.ArrayList - Mutable list

    val array = arrayOf("black", "white", "green")
    var colorList = listOf(*array) // spread operator
    colorList = array.toList()
    println(colorList)
}