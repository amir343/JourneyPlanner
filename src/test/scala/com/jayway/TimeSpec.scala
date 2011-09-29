package com.jayway

import org.junit.runner.RunWith
import org.specs2.Specification
import org.specs2.runner.JUnitRunner
import java.lang.{ IllegalArgumentException => IAE }

/**
 * @author Amir Moulavi
 */
@RunWith(classOf[JUnitRunner])
class TimeSpec extends Specification { def is =

  "Specification to check Time class" ^
    "Should fail with Time(-23, 34)" ! illegalHour ^
    "Should fail with wrong minutes Time(23, 90)" ! illegalMinutes ^
    "Should return the correct difference" ! testMinus ^
    "Should return the time in minutes" ! testAsMinutes ^
    "LessThan: Time with equal hour and different minutes -> true" ! testLessThan1 ^
    "LessThan: Time with non-equal hour -> true" ! testLessThan2 ^
    "LessThan: Time which is not less than" ! testLessThan3 ^
    "GreaterThan: Time with equal hour and different minutes -> true" ! testGreaterThan1 ^
    "toString method should return in the format HH:mm" ! testToString
    "Serialization and deserializations test" ! testXml
  end

  def illegalHour = Time(-23, 34) must throwAn[IAE]
  def illegalMinutes = Time(23, 90) must throwAn[IAE]
  def testMinus = Time(12, 30) minus Time(11,30) mustEqual 60
  def testAsMinutes = Time(1, 30).asMinutes mustEqual 90
  def testLessThan1 = Time(2,30) < Time(2,34) mustEqual true
  def testLessThan2 = Time(2,30) < Time(12,34) mustEqual true
  def testLessThan3 = Time(12,30) < Time(1,34) mustEqual false
  def testGreaterThan1 = Time(12,30) > Time(11,34) mustEqual true
  def testToString = Time(12,40).toString mustEqual "12:40"
  def testXml = {
    val serializedTime = Time(12,40)
    val deserializedTime = Time.fromXml(serializedTime.toXML)
    serializedTime mustEqual Some(deserializedTime)
  }


}