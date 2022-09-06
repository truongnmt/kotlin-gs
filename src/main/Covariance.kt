package main

// generic: using type and subtype is more accurate than using class and subclass
// eg: List is a class, List<String> is type

// immutable list is covariant, covariant: subtype is preserved, eg: List<Short> is subtype of List<Number>
// mutable list is invariance, MutableList<Short> is not subtype of MutableList<Number>

// use covariance when want subtype to be preserved so that can pass an instance of the type or subtype
// however, lose ability to write to an instance to change an instance
fun main() {
    val shortList: MutableList<Short> = mutableListOf(1,2,3,4,5)
    // convertToIntV2(shortList) // Required: MutableList<Number>  Found: MutableList<Short>
}

fun tendGarden(roseGarden: Garden<Rose>) {
    // Rose inherit Flower
    // however subclass is not accepted
    waterGarden(roseGarden) // Required: Garden<Flower>  Found: Garden<Rose>
}

fun waterGarden(garden: Garden<Flower>) {

}

fun convertToIntV2(collection: MutableList<Number>) {
    for (num in collection) {
        println("${num.toInt()}")
    }
}

open class Flower {

}

class Rose: Flower() {

}

// covariance, allow subtype
// cons: can't edit, like immutable collection which is also has out keyword in definition
class Garden<out T: Flower>(private var  something: T) {
    val flowers: List<T> = listOf()

    fun pickFlower(i: Int): T = flowers[i]
    // Type parameter T is declared as 'out' but occurs in 'in' position in type T
    // 'in' is func param
    // 'out' return type of a func
    // covariance: only can use T in out position
    // why? can call this method with a daisy when we have a rose garden
    // fun plantFlower(flower: T) {}
}
