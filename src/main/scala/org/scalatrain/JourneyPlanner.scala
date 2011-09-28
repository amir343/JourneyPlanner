package org.scalatrain

/**
 * @author Amir Moulavi
 */

case class JourneyPlanner(trains:Set[Train]) {

  val stations:Set[Station] = trains.flatMap { _.stations }

  def trainsAt(st:Station) = {
    trains.filter( _.stations.contains(st) )
  }

}