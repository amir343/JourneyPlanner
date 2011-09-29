package com.jayway

import org.specs2.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

/**
 * @author Amir Moulavi
 */
@RunWith(classOf[JUnitRunner])
class JourneyPlannerSpec extends Specification { def is =

  "JourneyPlanner specification" ^
    "Stations should be initialized properly" ! testStations ^
    "Should check the existence of a station" ! testStationExistence ^
    "Should return the (time, train) for a specific station" ! testStopsAt
  end

  val train1 = Train(TrainKind.Ice, "fddskj", Seq( (Time(12,30),Station("Stockholm")), (Time(18,45), Station("Lund")) ))
  val train2 = Train(TrainKind.Ice, "fd3gdgj", Seq( (Time(2,30),Station("Malmo")), (Time(7,45), Station("Lund")) ))

  def testStations = JourneyPlanner(
    Set( train1, train2 )
  ).stations mustEqual Set(Station("Stockholm"), Station("Lund"), Station("Malmo"))


  def testStationExistence = JourneyPlanner(
    Set( train1, train2 )
  ).trainsAt(Station("Malmo")).size mustEqual 1

  def testStopsAt = JourneyPlanner(
    Set( train1, train2 )
  ).stopsAt(Station("Stockholm")).size mustEqual 1


}