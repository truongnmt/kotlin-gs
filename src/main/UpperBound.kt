package main

// in kotlin generic are compile time feature, generic doesn't make it to compiled application, it got erased
// at runtime all the JVM knows is that if it has a collection, then it has a collection

fun main() {
    val ints = listOf(1,2,3,4,5)
    val shorts: List<Short?> = listOf(10, 20, 30, 40)
    val floats: List<Float?> = listOf(10.3f, -20.2f, -33.20f, 41.09f)
    val strings = listOf("1", "2", "3")

    convertToInt(ints)
    convertToInt(shorts)
    convertToInt(floats)
    // convertToInt(strings)

    append(StringBuilder("String1"), StringBuilder("String 2"))

    // printCollection(shorts)
    printCollection(strings)

    if (strings is List<String>) {
        println("This list contains strings")
    }

    var listAny: Any = listOf("str1", "str2")
    // if (listAny is List<String>) // Cannot check for instance of erased type: List<String>
    if (listAny is List<*>) {
        println("Yes, this is a list")
    }

    listAny = listOf(1,2,3)
    if (listAny is List<*>) {
        println("this list contains strings")
        val strList = listAny as List<String> // warning: unchecked cast Any to List<String>
        println(strList[1].replace("str", "string"))
    }
    // exception class java.lang.Integer cannot be cast to class java.lang.String

}

// restrict a func to accept only non nullable type is use T: Any
fun <T: Any> printCollection(collection: List<T>) {
    for (i in collection) {
        print(i)
    }
}

// want more than 1 upper bound, use where clause
// where item is type appendable and implement CharSequence
fun <T> append(item1: T, item2: T)
    where T: CharSequence, T: Appendable {
    println("Result is ${item1.append(item2)}")
}

fun <T: Number?> convertToInt(collection: List<T>) {
    for (num in collection) {
        println("${num!!.toInt()}")
    }
}
