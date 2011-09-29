package com.jayway

/**
 * @author Amir Moulavi
 */

class Time(val hours:Int = 0, val minutes:Int = 0) extends Ordered[Time] {

  require(hours >= 0 && hours < 24)
  require(minutes >= 0 && minutes < 60)

  lazy val asMinutes:Int = 60 * hours + minutes

  def minus(that:Time):Int = this.asMinutes - that.asMinutes

  def -(that:Time):Int = minus(that)

  def compare(that:Time):Int = this.asMinutes - that.asMinutes

  override val toString:String = "%02d:%02d".format(hours, minutes)

}

object Time {

  def apply(m:Int):Time = {
    new Time(m/60, m % 60)
  }

  def apply(h:Int, m:Int):Time = {
    new Time(h, m)
  }

}