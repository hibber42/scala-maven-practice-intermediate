package org.scala.maven.practice.bookexercises

/**
 * [Currying] is named after the mathematician (Haskel Curry), who discovered this principle. It was independently
 * discovered earlier by (Moses Schoenfinkel), but Schoenfinkelization did not catch on ^_^
 *
 * TODO: Add definition for partial application and currying here
 */
object Currying extends App {

  /**
   * Exercise 2.3
   *
   * Curry func has types A, B & C
   * Curry func
   *  1. Takes one argument - which is another function that takes A & B as arguments and returns C
   *  2. Returns a result -
   *    2.1 which is another function that takes A as an argument
   *    2.2 returns another func that takes B as an and returns C...phew
   *
   * There is only one implementation for this signature (shown below after '=')
   *
   * Converts a function (f) of two args into a func of one arg that partially applies (f)
   */
  def curry[A, B, C](f: (A, B) => C): A => B => C = (a: A) => (b: B) => f(a, b)

  /**
   * Exercise 2.4
   *
   * Uncurry func (reverses the curry func)
   *  1. Takes one argument - which is another function that takes A as an arg and
   *                            returns another func that takes B as an arg and
   *                                returns C...PHEW
   *  2. Returns a function that takes A & B as args and returns C
   */
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a: A, b: B) => f(a)(b)

  /**
   * Exercise 2.5 Implement the HOF that composes two functions
   *
   * Compose func
   * 1. Takes two functions as args
   *    1.1 first arg func that takes B as an arg and returns C
   *    1.2 2nd arg func that takes A as an arg and returns B
   * 2. Returns a function that takes A as an arg and returns C
   */
  def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))
}
