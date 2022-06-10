package org.scala.maven.practice

object HigherOrderFunctionsAndClosures extends App {

  //val getDecisionMaker = (records: Vector[StockRecord], date:String) => {
  val getDecisionMaker = (records: Vector[StockRecord]) => {

    /**
     * local variables defined within the getDecisionMaker function scope
     *
     * note - these do not need to be defined locally within this function scope
     */
//    val currDate = date
//    val currRecords = records

    // inner function
    val makeDecision = (percentDelta: Float) => {

  /**
   * notice how the date variable used in the filter predicate below has not been
   * defined in either of the functions (makeDecision & getDecisionMaker) nor in the
   * global scope of this object - see lines 66-72
   */
  val filteredRecords = records.filter(_.date == date)
      // what happens if assert fails??
      assert(filteredRecords.length == 1)

      // head of the vector tree, should be the only element in the vector
      val record = filteredRecords.head

      // calculate the percentage of move between open & close
      val percentageMove = ((record.close - record.open) / record.open) * 100

      // compare the move with the provided arg of percent delta and print decision
      if (percentageMove > percentDelta) {
          println(s"Buy based on date: ${record.date}, " + s" with a percent move of: $percentageMove")
      } else if (percentageMove < -percentDelta) {
          println(s"Sell based on date: ${record.date}, " + s" with a percent move of: $percentageMove")
      } else {
        println(s"No calls based on date: ${record.date}, " + s" with a percent move of: $percentageMove")
      }
    }
    makeDecision
  }

  println("----------------------------------------------------------------------------------------------")
  val decisionMaker1 = getDecisionMaker(FileReader.readData)

  /**
   * As long as the date variable is defined before the function that
   * needs the variable when executed, the implementation of that function does
   * not need that value defined within its accessible scope - READ MORE ON CLOSURE
   */
  val date = "2014-03-8"
  decisionMaker1(-11)

  /**
   * You can also use an expression block in place of provided a reference to the
   * input argument of a function
   */
  val randomPercentDeltaDecision = decisionMaker1 {
    val randomPercentDeltas = List(2, 10, 11, -10)
    val selectedDelta = util.Random.nextInt(randomPercentDeltas.length)
    randomPercentDeltas(selectedDelta)
  }

  println(randomPercentDeltaDecision)

}
