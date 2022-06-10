package org.scala.maven.practice.collections

object RecursiveMethodsWithPatternMatching extends App {

  // recursively sums all ints in a list
  def sum(list: List[Int]): Int = {
    list match {
      // Nil here represents an empty list, so when we match on that we return
      // 0 and end or recursive chain
      case Nil            => 0

      // takes the first element and calls the same
      // function with the remaining elements
      //    case ::(head, tail) => head + sum(tail)
      case head :: tail => head + sum(tail)
    }
  }

  /**
   * the recursive sum method above can be written as below to
   * apply tail recursive optimization. Tail rec methods avoid
   * a possibility of a stack overflow error by keeping all of the method
   * calls in the same stack which is similar to regular iterations
   *
   * tail rec requires the recursive call to be the last call in the
   * implementation. In the sum method above the implementation, the recursive
   * call is evaluated before the summing calculation. In order for this
   * to be tail rec, we need to be able to calculate the summation of the
   * elements in each iteration/rec execution before evaluating the rec call.
   * This is achieved by use of an additional arg on the rec method sig called
   * the accumulator which holds the sum of the elements in scope for each call
   *
   * the @tailrec annotation tells the compiler to evaluate the method below as
   * loop
   * @param list
   * @return
   */
  @scala.annotation.tailrec
  def tailRecursiveSum(list: List[Int], accumulator: Int): Int = {
    list match {
      case Nil            => 0
      case head :: tail => tailRecursiveSum(tail, head + accumulator)
    }
  }

}
