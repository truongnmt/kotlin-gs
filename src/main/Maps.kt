package main


fun main() {
    val setInts = setOf(10, 15, 19, 5, 3, -22)
    // set can't contains duplicate element
    // setOf is immutable
    // plus return a new set
    println(setInts.plus(20)) // [10, 15, 19, 5, 3, -22, 20]
    println(setInts.plus(10)) // [10, 15, 19, 5, 3, -22, 20]
    println(setInts.minus(19)) // [10, 15, 5, 3, -22]
    println(setInts.minus(100)) // [10, 15, 19, 5, 3, -22]
    println(setInts.average()) // 5.0
    println(setInts.drop(3)) // drop first 3 el from the set // [5, 3, -22]

    val immutableMap = mapOf<Int, Car>(1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2013),
    )

    println(immutableMap.javaClass) // class java.util.LinkedHashMap
    println(immutableMap) // {1=main.Car@79698539, 2=main.Car@73f792cf, 3=main.Car@2ed94a8b}

    val mutableMap = mutableMapOf<String, Car>("John's car" to Car("red", "range rover", 2010),
        "Jane's car" to Car("blue", "hyndai", 2012))
    println(mutableMap.javaClass) // class java.util.LinkedHashMap
    println(mutableMap) // {John's car=main.Car@38082d64, Jane's car=main.Car@dfd3711}

    // both mapOf and mutableMapOf has class of LinkedHashMap because linked hash map has a predictable iteration order

    // explicitly create a hashmap
    val hashMap = hashMapOf<String, Car>("Mary's car" to Car("red", "corvette", 1954))
    hashMap.put("Bob's car", Car("white", "Honda", 1999))
    hashMap["Bob's car"] = Car("white", "Honda", 1999)

    val pair = Pair(10, "ten") // Pair is a data class, already has component1 component2 function
    // val firstValue = pair.first
    // val secondValue = pair.second
    val (firstValue, secondValue) = pair // destructuring declaration, take an instance and destructuring it
    println(firstValue)
    println(secondValue)

    for ((k, v) in mutableMap) {
        println(k)
        println(v)
    }

    val car = Car("blue", "Corvette", 1999)
    val (color, model, year) = car
    println("color = $color, model = $model, year = $year")

}

data class Car(val color: String, val model: String, val year: Int) {
    // data class already has component_ function
//    operator fun component1() = color
//    operator fun component2() = model
//    operator fun component3() = year
}
