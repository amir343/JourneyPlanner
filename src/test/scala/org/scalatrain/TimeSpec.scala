package org.scalatrain

import org.junit.runner.RunWith
import org.specs2.Specification
import org.specs2.runner.JUnitRunner
import java.lang.{ IllegalArgumentException => IAE }

/**
 * User: amir
 */
@RunWith(classOf[JUnitRunner])
class TimeSpec extends Specification { def is =

  "Specification to check Time class" ^
    "Should fail with Time(-23, 34)" ! illegalHour ^
    "Should fail with wrong minutes Time(23, 90)" ! illegalMinutes ^
    "Should return the correct difference" ! testMinus ^
    "Should return the time in minutes" ! testAsMinutes
  end

  def illegalHour = Time(-23, 34) must throwAn[IAE]
  def illegalMinutes = Time(23, 90) must throwAn[IAE]
  def testMinus = Time(12, 30) minus Time(11,30) mustEqual 60
  def testAsMinutes = Time(1, 30).asMinutes mustEqual 90

}