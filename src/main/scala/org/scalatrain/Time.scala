package org.scalatrain

/**
 * User: amir
 */

class Time(val hours:Int = 0, val minutes:Int = 0) {

  require(hours >= 0 && hours < 24)
  require(minutes >= 0 && minutes < 60)

  lazy val asMinutes:Int = 60 * hours + minutes

  def minus(that:Time):Int = this.asMinutes - that.asMinutes

  def -(that:Time):Int = minus(that)

  def <(that:Time):Boolean = (this.hours < that.hours) || ( (this.hours >= that.hours) ) // TODO

}

object Time {

  def apply(m:Int):Time = {
    new Time(m/60, m % 60)
  }

  def apply(h:Int, m:Int):Time = {
    new Time(h, m)
  }

}