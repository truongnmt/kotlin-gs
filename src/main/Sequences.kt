package main

fun main() {
    val immutableMap = mapOf<Int, Car>(1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2013),
        17 to Car("red", "BMW", 2013),
        8 to Car("green", "Ford", 2010),
    )

    // filter and map create an intermediate instance and pass it to the next
    // if the map is huge or many chained func, have perf concern
    // => use sequences
    println(immutableMap.asSequence().filter { it.value.model == "Ford"}
        .map { it.value.color })

    // use sequences when don't know how large a collection will be
    // sequence is the same as streams in java
    // put each individual item run in the whole chain, run each element one by one
    // intermediate ops return sequences, terminal ops not return sequences
    // are lazy
    listOf("Joe", "Mary", "Jane").asSequence()
        .filter { println("filtering $it"); it[0] == 'J' }
        // need semicolon when writing predicates on the fly and want to do more than one statement
        .map { println("mapping $it"); it.toUpperCase() }
        .find { it.endsWith('E') }
        //.toList() // terminal ops
}
