package com.jayway

/**
 * @author Amir Moulavi
 */

case class Station(name:String)

case class Train(kind:String, number:String, schedule:Seq[(Time, Station)]) {
  require(schedule.size >= 2, "Schedule must contain 2 stations")

  require( isMonoticallyOrdered (schedule) )

  def isMonoticallyOrdered(schedule:Seq[(Time, Station)]):Boolean = {
    schedule.sliding(2).toList.forall { p => p(0)._1 < p(1)._1 }
  }

  val stations: Seq[Station] = schedule map { _._2 }

}


