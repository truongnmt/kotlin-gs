package main

fun main() {
    val cars1 = mutableListOf(CarV2(), CarV2())
    val cars2: MutableList<CarV2> = mutableListOf()
    copyCars(cars1, cars2)

    val fords1 = mutableListOf(Ford(), Ford())
    val fords2: MutableList<Ford> = mutableListOf()
    copyCars(fords1, fords2)

    copyCars(fords1, cars2)

    val cars3: MutableList<CarV2> = mutableListOf(Ford(), Ford())
}

// parameter type covariant
fun <T: CarV2> copyCars(source: MutableList<out T>, destination: MutableList<in T>) {
    for (car in source) {
        destination.add(car)
    }
}

open class CarV2 {

}

class Toyota: CarV2() {}

class Ford: CarV2() {}