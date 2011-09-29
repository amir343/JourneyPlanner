package com.jayway

/**
 * @author Amir Moulavi
 */

object TrainKind extends Enumeration {
  val Ice = Value("ICE")
  val Re = Value("RE")
  val Brb = Value("BRB")
}

case class Station(name:String)

case class Train(kind:TrainKind.Value, number:String, schedule:Seq[(Time, Station)]) {
  require(schedule.size >= 2, "Schedule must contain 2 stations")

  require( isMonoticallyOrdered (schedule) )

  def isMonoticallyOrdered(schedule:Seq[(Time, Station)]):Boolean = {
    schedule.sliding(2).toList.forall { p => p(0)._1 < p(1)._1 }
  }

  val stations: Seq[Station] = schedule map { _._2 }

}


