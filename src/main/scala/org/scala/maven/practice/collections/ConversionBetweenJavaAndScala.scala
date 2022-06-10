package org.scala.maven.practice.collections

import java.util
import scala.collection.mutable
import scala.jdk.CollectionConverters._

object ConversionBetweenJavaAndScala extends App {

  val listInJava = new util.ArrayList[Int]()

  listInJava.add(10)

  val sameListInScala : mutable.Seq[Int] = listInJava.asScala

  for (element <- sameListInScala) {

  }

//  transformations

  val even: Int => Boolean = _ % 2 == 0
//  val odd: Int => Boolean = _ % 2 != 0

  val numbers = Seq(10, 11, 25, 42, 66, 84)

  println(s"print even numbers: ${numbers.filter(even)}")
  println(s"print odd numbers: ${numbers.filterNot(even)}")

  // partition function returns elems in two collections, one
  // with elems that satisfy the pred and one that does not
  val twoCollections = numbers.partition(_ % 2 == 0)
  println(twoCollections.toString())

//  val words = "The quick brown fox jumps over the dog".split(" ").toList.find(_ == "lazy")
  val words = "The quick brown fox jumps over the dog".split(" ")

  println(words.takeWhile(_ == "dog"))

}
