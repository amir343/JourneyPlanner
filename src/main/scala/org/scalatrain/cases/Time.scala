package org.scalatrain.cases

/**
 * User: amir
 */

case class Time(hours:Int = 0, minutes:Int = 0) {

  require(hours >= 0 && hours <= 24)
  require(minutes >= 0 && minutes <= 60)

  lazy val asMinutes:Int = 60 * hours + minutes

  def minus(that:Time):Int = this.asMinutes - that.asMinutes

  def -(that:Time):Int = minus(that)

}