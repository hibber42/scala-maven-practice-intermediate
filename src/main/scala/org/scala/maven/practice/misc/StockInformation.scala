package org.scala.maven.practice.misc

case class StockInformation(records: Vector[StockRecord]) {

  def extractOpenClosePrice(): Vector[(String, Float)] = {
    for (record <- records) yield (record.date, record.close)
  }

  def extractInfo(extractFunction: () => Vector[(String, Float)]): Vector[(String, Float)] = extractFunction()
}
