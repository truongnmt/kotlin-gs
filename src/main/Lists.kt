package main

fun main() {
    val strings = listOf("spring", "summer", "fall", "summer", "winter")
    val colorList = arrayOf("black", "white", "green", "black", "red")

    println(strings.last())
    println(strings.asReversed())

    println(strings.getOrNull(5))

    println(colorList.zip(strings)) // [black, spring], [white, summer], [green, fall]

    val mergedList = listOf(colorList, strings) // [[black, white, green], [spring ... winter]]
    println(mergedList)

    val combinedList = colorList + strings
    println(combinedList) // [black, white, green, spring, summer, fall, winter]

    val noDupList = colorList.union(strings)
    println(noDupList) // [black, white, green, red, spring, summer, fall, winter]

    val noDupColors = colorList.distinct() // return a new list
    println(noDupColors) // [black, white, green, red]

}