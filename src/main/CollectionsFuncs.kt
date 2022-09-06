package main

fun main() {
    val setInts = setOf(10, 15, 19, 5, 3, -22)
    println(setInts.filter { it % 2 != 0 })

    val immutableMap = mapOf<Int, Car>(1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2013),
        17 to Car("red", "BMW", 2013),
        8 to Car("green", "Ford", 2010),
    )
    println(immutableMap.filter { it.value.year == 2016 })
    println(immutableMap.filter { it.value.model == "Ford"} // 2 8
        .map { it.value.color }) // red green
    println(immutableMap.all { it.value.year > 2014 }) // all: want all must match, false
    println(immutableMap.any { it.value.year > 2014 }) // any: at least 1 match, true
    println(immutableMap.count { it.value.year > 2014 }) // 2

    val cars = immutableMap.values
    println(cars.find { it.year > 2014 })
    println(cars.groupBy { it.color }) // green [Car(), ...], red [Car()...]
    println(cars.sortedBy { it.year })

    println(immutableMap.toSortedMap()) // sorted by key



    val mutableMap = mutableMapOf<Int, Car>(1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2013),
    )
    mutableMap.filter { it.value.color == "silver"}
    println("The filters map is $mutableMap")

    val ints = arrayOf(1,2,3,4,5)
    val add10List: MutableList<Int> = mutableListOf()
    for (i in ints) {
        add10List.add(i + 10)
    }
    println(add10List)

    // map function
    val add10ListV2 = ints.map { it + 10 }
    println(add10ListV2)
}
