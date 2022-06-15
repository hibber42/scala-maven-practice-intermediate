package org.scala.maven.practice.bookexercises

/**
 * [Currying] is named after the mathematician (Haskel Curry), who discovered this principle. It was independently
 * discovered earlier by (Moses Schoenfinkel), but Schoenfinkelization did not catch on ^_^
 *
 * TODO: Add definition for partial application and currying here
 *
 * Exercise 2.3
 */
class Currying extends App {

  /**
   * Curry func has types A, B & C
   * Curry func
   *  1. Takes one argument - which is another function that takes A & B as arguments and returns C
   *  2. Returns a result -
   *    2.1 which is another function that takes A as an argument
   *    2.2 returns another func that takes B as an and returns C...phew
   *
   * There is only one implementation for this signature (shown below after '=')
   */
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = (a: A) => (b: B) => f(a, b)


}
