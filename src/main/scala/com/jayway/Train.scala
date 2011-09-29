package com.jayway

/**
 * @author Amir Moulavi
 */

sealed abstract class TrainInfo {
  def number:String
}

object TrainInfo {
  case class Ice(number:String, hasWifi:Boolean = false) extends TrainInfo
  case class Re(number:String) extends TrainInfo
  case class Brb(number:String) extends TrainInfo
}

case class Station(name:String)

case class Train(kind:TrainInfo, schedule:Seq[(Time, Station)]) {
  require(schedule.size >= 2, "Schedule must contain 2 stations")

  require( isMonoticallyOrdered (schedule) )

  def isMonoticallyOrdered(schedule:Seq[(Time, Station)]):Boolean = {
    schedule.sliding(2).forall { p => p(0)._1 < p(1)._1 }
  }

  val stations: Seq[Station] = schedule map { _._2 }

}


