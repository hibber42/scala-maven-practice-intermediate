package org.scala.maven.practice.classes

object CompanionObject {
  private val conversionTable: Map[String, Double] =  Map("CAD" -> 1/1.30, "NZD" -> 1/1.50)

  private def getCostInUSD(code: String, amount: Double) = {
    code match {
      case "USD" => amount
      case "NZD" => amount * conversionTable("NZD")
      case "CAD" => amount * conversionTable("CAD")
      case _ => throw new IllegalArgumentException("Unknown code")
    }
  }

  def apply(code: String, amount: Double) = new CompanionObject(code, amount, getCostInUSD(code, amount))
}

class CompanionObject(code: String, amount: Double, inUsd: Double) {
  private val _code = code
  private val _amount = amount
  private val _inUSD = inUsd

  // TODO: ask somewhere why the string expression is breaking
  //override def toString: String = s"$_code $_amount = $_inUSD in USD"
  override def toString: String = _code + " " +  _amount + " = " +  _inUSD + " in USD"
}

object ConversionRunner extends App {
  val nzdInUsd = CompanionObject("NZD", 56.87)
  val cadInUsd = CompanionObject("CAD", 56.87)
  val usdInUsd = CompanionObject("USD", 56.87)

  List(nzdInUsd, cadInUsd, usdInUsd).foreach(x => println(x))
  //rintln(CompanionObject("NZD", 10.00))
}