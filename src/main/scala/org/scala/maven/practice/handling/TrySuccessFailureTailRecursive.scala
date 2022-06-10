package org.scala.maven.practice.handling

import scala.io.StdIn
import scala.util.{Failure, Success, Try}

object TrySuccessFailureTailRecursive extends App {

  def readFile(path: String): Seq[DividendRecord] = {
    val source = io.Source.fromFile(path)

    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield DividendRecord(cols(0), cols(1), cols(2).toFloat, cols(3).toFloat)
  }

  val records = readFile("src/main/resources/dividendStocks.csv")

  println(s"Extracted records $records")

  // now lets calculate the dividend
  @scala.annotation.tailrec
  def calculateDividend(): Try[Double] = {
    // prompt user to enter stock name & its current price
    val ticker = StdIn.readLine("Enter Ticker: ")
    val currentPrice = Try(StdIn.readLine("Enter price for ticker: ").toDouble)

    //function literal wrapped with try to extract/calculate face value & dividend rate of the user provided ticker name
    val faceValue = Try(records.filter(_.ticker == ticker).map(_.face_value).head.toDouble)
    val dividendRate = Try(records.filter(_.ticker == ticker).map(_.dividend).head * 0.01)

    /**
     *     use the extracted fv & dr to determine dps
     *     use calculated dps & cp to calculate dy
     *
     *     notice use of flatmap & map to apply linear nested loop operations - TODO read more about this
      */
    val dividendPerShare: Try[Double] = faceValue.flatMap(fv => dividendRate.map(dr => fv * dr))
    val dividendYield: Try[Double] = dividendPerShare.flatMap(dps => currentPrice.map(cp => dps / cp * 100))

    dividendYield match {
      case Success(dy) =>
        println(s"Dividend yield for ticker: $ticker is = $dy%")
        Success(dy)
        
      case Failure(exception) =>
        println(s"Encountered error with message: ${exception.getMessage}")
        calculateDividend()
    }
  }
  calculateDividend()
}
