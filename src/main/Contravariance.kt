package main

// contravariance: accept instance of T and its super class
// looking up the inheritance tree rather than down in covariance

// can't have read func

fun main() {
    val flowerTender = object: FlowerCare<FlowerV2> {
        override fun prune(flower: FlowerV2) {
            println("I'm tending a ${flower.name}")
        }
    }

//    val roseTender = object: FlowerCare<RoseV2> {
//        override fun prune(flower: RoseV2) {
//            println("I'm pruning a rose!")
//        }
//    }
    val roseGarden = GardenV2<RoseV2>(listOf(RoseV2(), RoseV2()), flowerTender)
    roseGarden.tendFlower(0)

//    val daffodilTender = object: FlowerCare<Daffodil> {
//        override fun prune(flower: Daffodil) = println("I'm pruning a daffodil!")
//    }
    val daffodilGarden = GardenV2<Daffodil>(listOf(Daffodil(), Daffodil(), Daffodil()), flowerTender)
    daffodilGarden.tendFlower(2)
}

class GardenV2<T: FlowerV2>(val flowers: List<T>, val flowerCare: FlowerCare<T>) {
    fun pickFlower(i: Int) = flowers[i]
    fun tendFlower(i: Int) {
        flowerCare.prune(flowers[i])
    }
}

open class FlowerV2(val name: String) {

}

class RoseV2: FlowerV2("Rose") {

}

class Daffodil: FlowerV2("Daffodil") {

}

interface FlowerCare<in T> {
    fun prune(flower: T)
    // not guarantee to get a type we expect since T might be superclass
    // fun pick(): T
}
