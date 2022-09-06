package main.loop

fun main() {
    for (i in 1..5) {
        println(i)
    }
    // 1 2 3 4 5

    val backwardRange = 5.downTo(1)

    val stepThree = (3..15).step(3)
    for (i in stepThree) {
        println(i)
    }
    // 3 6 9 12 15

    for (n in 1..20 step 5) {
        println(n)
    }
    // 1 6 11 16

    for (i in 1 until 5) {
        println(i)
    }
    // until 5: exclude 5
    // 1 2 3 4

    val seasons = arrayOf("spring", "summer", "winter", "fall")
    for (s in seasons) {
        println(s)
    }

    println("watever" !in seasons) // true, watever not in seasons array

    for (i in 1..3 ) {
        println("i = $i")
        jloop@ for (j in 1..4) {
            println("j = $j")
            for(k in 5..10) {
                println("k = $k")
                if (k == 7) {
                    break@jloop
                    // break not only the neareast loop but in the named loop

                    continue@jloop
                    // continue to the named loop
                }
            }
        }
    }
}


