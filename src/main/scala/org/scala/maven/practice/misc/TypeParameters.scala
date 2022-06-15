package org.scala.maven.practice.misc

object TypeParameters extends App {

  // method that accepts generic type of seq of elems
  def randomElementFromAnyTypeOfSequenceMethod[A](elements: Seq[A]): A = {
    val randIndex = util.Random.nextInt(elements.length)
    elements(randIndex)
  }

}
