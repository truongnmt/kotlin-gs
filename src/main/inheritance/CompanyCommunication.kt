package main.inheritance

import java.time.Year

fun main() {
    println(CompanyCommunication.getTagLine())
    println(CompanyCommunication.getCopyrightLine())
}

// declare the class and it's instance at the same time => object keyword
// usage: singleton, companion object, object expression

// singleton
object CompanyCommunication {
    val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."
}