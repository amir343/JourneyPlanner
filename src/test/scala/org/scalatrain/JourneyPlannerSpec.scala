package org.scalatrain

import org.specs2.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

/**
 * User: amir
 */
@RunWith(classOf[JUnitRunner])
class JourneyPlannerSpec extends Specification { def is =

  "JourneyPlanner specification" ^
    "Stations should be initialized properly" ! testStations ^
    "Should check the existence of a station" ! testStationExistence
  end

  def testStations = JourneyPlanner(
    Set( Train("Nighttrain", "fddskj", Seq( (Time(12,30),Station("Stockholm")), (Time(18,45), Station("Lund")) )),
         Train("Nighttrain", "fd3gdgj", Seq( (Time(2,30),Station("Malmo")), (Time(7,45), Station("Lund")) )))
  ).stations mustEqual Set(Station("Stockholm"), Station("Lund"), Station("Malmo"))


  def testStationExistence = JourneyPlanner(
    Set( Train("Nighttrain", "fddskj", Seq( (Time(12,30),Station("Stockholm")), (Time(18,45), Station("Lund")) )),
         Train("Nighttrain", "fd3gdgj", Seq( (Time(2,30),Station("Malmo")), (Time(7,45), Station("Lund")) )))
  ).trainsAt(Station("Malmo")).size mustEqual 1



}