package org.scala.maven.practice.bookexercises

// exercise 2.2
object GenericIsSorted extends App {

 /*
 * method accepts an array of type A and a HOF ordered that compares two elements of type
 * A and returns boolean. isSorted method checks if the given array is sorted according
 * to the given comparison function.
 * */
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean) : Boolean = {
    @scala.annotation.tailrec
    def loop(index: Int): Boolean = {
          if (index >= as.length - 1) true
          else if (ordered(as(index), as(index + 1))) (loop(index + 1))
          else false
    }
    loop(0)
  }

  val ascendingIntArray = isSorted(Array(1, 2, 3, 4), (x: Int, y: Int) => y > x);
  val descendingIntArray = isSorted(Array(4, 3, 2, 1), (x: Int, y: Int) => x > y)

  val ascendingStrArray = isSorted(Array("A", "B", "C", "D"), (x: String, y: String) => y > x)
  val descendingStrArray = isSorted(Array("A", "B", "C", "D").reverse, (x: String, y: String) => x > y)

  println(s"ascendingIntArray: $ascendingIntArray")
  println(s"descendingIntArray: $descendingIntArray")
  println(s"ascendingStrArray: $ascendingStrArray")
  println(s"descendingStrArray: $descendingStrArray")

}
