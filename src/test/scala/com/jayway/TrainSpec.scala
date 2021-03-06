package com.jayway

import org.specs2.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import java.lang.{IllegalArgumentException => IAE}
/**
 * @author Amir Moulavi
 */

@RunWith(classOf[JUnitRunner])
class TrainSpec extends Specification { def is =

  "Specification for Train class" ^
    "One station in schedule is not enough and it fails" ! testOneStation ^
    "Two stations in schedule is ok" ! testTwoStations ^
    "Monotically sorted times does not throw an exception" ! testTime1 ^
    "Non-monotically sorted times does throw an exception" ! testTime2
  end

  val BRB = TrainInfo.Brb("Kgfsdfsdf")
  val RE = TrainInfo.Re("sffdsddsf")

  def testOneStation = Train(BRB, IndexedSeq( (Time(12,30),Station("Stockholm")) )) must throwAn[IAE]
  def testTwoStations = Train(BRB, IndexedSeq( (Time(12,30),Station("Stockholm")), (Time(14,30),Station("Lund")) )) must not(throwAn[IAE])
  def testTime1 = Train(RE, IndexedSeq( (Time(12,30),Station("Stockholm")), (Time(14,30),Station("Lund")) )) must not(throwAn[IAE])
  def testTime2 = Train(RE, IndexedSeq( (Time(2,30),Station("Stockholm")), (Time(1,30),Station("Lund")) )) must throwAn[IAE]

}