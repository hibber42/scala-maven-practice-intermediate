package org.scala.maven.practice.misc

object FibonacciCalculator extends App {
  // fibonacci till nth using tail recursion
  def fibonacci(n: Int): Int = {
    println("sequence: ")
    // inner func
    @scala.annotation.tailrec
    def go(x: Int, sum: Int): Int = {
      println(s"$x ")
      if (x == n) sum
      else go(sum, x + sum)
    }
    go(0, 1)
  }
  val sum = fibonacci(5) // pass desired n here
  println(s"sum: $sum")

}
