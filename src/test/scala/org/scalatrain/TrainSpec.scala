package org.scalatrain

import org.specs2.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import java.lang.{IllegalArgumentException => IAE}


/**
 * User: amir
 */

@RunWith(classOf[JUnitRunner])
class TrainSpec extends Specification { def is =

  "Specification for Train class" ^
    "One station in schedule is not enough and it fails" ! testOneStation
    "Two stations in schedule is ok" ! testTwoStations
  end

  def testOneStation = Train("Nighttrain", "Kgfer33", IndexedSeq( (Time(12,30),Station("Stockholm")) )) must throwAn[IAE]

  def testTwoStations = Train("Nighttrain", "fdsfsgf", IndexedSeq( (Time(12,30),Station("Stockholm")), (Time(14,30),Station("Lund")) )) must not(throwAn[IAE])

}