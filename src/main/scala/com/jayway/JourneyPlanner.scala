package com.jayway

/**
 * @author Amir Moulavi
 */

case class JourneyPlanner(trains:Set[Train]) {

  val stations:Set[Station] = trains.flatMap { _.stations }

  def trainsAt(st:Station):Set[Train] = {
    trains.filter { _.stations.contains(st) }
  }

  def stopsAt(st:Station):Set[(Time, Train)] = {
    for { train <- trains
          (time, station) <- train.schedule if station == st
        } yield (time, train)
  }

}