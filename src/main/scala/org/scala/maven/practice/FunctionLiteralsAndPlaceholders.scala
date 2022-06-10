package org.scala.maven.practice

import scala.io.Source

object FunctionLiteralsAndPlaceholders extends App {

  var data = FileReader.readData;

  data.foreach(x => println(x))

  // another function - takes in two doubles and subtracts them
  val priceDelta = (_:Double) - (_:Double)

  // example of higher order function
  /**
   * takes in two args - openPrice, closePrice
   * higher order function "delta" as an argument, so when you invoke this you will pass in the definition that should get applied for the result
   * returns the application result of the passed higher order function implementation
   */
  val getDailyDelta = (openPrice:Double, closePrice:Double, delta:(Double, Double) => Double) => delta(openPrice, closePrice)

  // function literal that extracts a record by filtering on the hardcoded date
  val record = data.filter(_.date == "2012-10-8")

  /**
   * finally we invoke the "getDailyDelta" func and pass in the first record's open/close price as args and the
   * reference to the func implementation of "priceDelta" defined above
   */
  //println(getDailyDelta(record(0).open, record(0).close, priceDelta))

  // same with place holders coz scala is kewl :P
  println(getDailyDelta(record(0).open, record(0).close, _-_))

}
