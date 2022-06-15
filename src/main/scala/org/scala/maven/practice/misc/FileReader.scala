package org.scala.maven.practice.misc

import scala.io.{BufferedSource, Source}
import scala.util.{Failure, Success, Try}

// TODO: Figure out how to pass file name as an arg to the `readFileSource` public f
object FileReader extends App {


  def readData: Vector[StockRecord] = {
    val source = Source.fromFile("src/main/resources/data.csv")

    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(
      cols(0),
      cols(1).toFloat,
      cols(2).toFloat,
      cols(3).toFloat,
      cols(4).toFloat,
      cols(5).toFloat,
      cols(6).toDouble)
  }

  private def readFile(name: String): Try[BufferedSource] = {
    Try(Source.fromFile(name))
  }

  val readFileSource = readFile("src/main/resources/data.csv")

  readFileSource match {
    case Success(readFileSource) => {
      for {
        line <- readFileSource.getLines().drop(1).toVector
        cols = line.split(",").map(_.trim)
      } yield StockRecord(
        cols(0),
        cols(1).toFloat,
        cols(2).toFloat,
        cols(3).toFloat,
        cols(4).toFloat,
        cols(5).toFloat,
        cols(6).toDouble)
    }

    case Failure(exception) => println(exception.getMessage)
  }

}
