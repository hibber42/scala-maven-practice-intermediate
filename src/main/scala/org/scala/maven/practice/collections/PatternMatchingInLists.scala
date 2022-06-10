package org.scala.maven.practice.collections

object PatternMatchingInLists extends App {

  // extractor pattern matching
  val names = List("Roy", "Charlie", "Deepa", "Soumya", "Kelly")
  names match {
    case List("Roy", _) => println("Found roy - should not work")
    case List(_, "Deepa", _*) => println("Found Deepa - should not work")
    //case List(_, _, "Deepa", _*) => println("Found Deepa - should work")
    case List(x, "Charlie", _*) => println(s"Before Charlie is $x")
    case _ => println("no match :)")




  }
  val roy: String => Boolean = name => if (name == "Roy") true else false
  println(names.find(roy))

  println(names.find(_ == "Roy"))
}
