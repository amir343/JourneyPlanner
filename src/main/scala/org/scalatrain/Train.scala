package org.scalatrain


case class Station(name:String)

case class Train(kind:String, number:String, schedule:Seq[(Time, Station)]) {
  require(schedule.size >= 2, "Schedule must contain 2 stations")

  require( check(schedule))

  def check(schedule:Seq[(Time, Station)]):Boolean = {
    //TODO complete this!
    for (el <- schedule.sliding(2) if (el(0)._1 < el(1)._1) ) yield l

  }

  val stations: Seq[Station] = schedule map { _._2 }

}


