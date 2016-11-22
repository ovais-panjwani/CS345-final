package clock

import scala.language.implicitConversions

// overwrites order operations
/*trait Ord {
  def < (that: Any): Boolean
  def <=(that: Any): Boolean =  (this < that) || (this == that)
  def > (that: Any): Boolean = !(this <= that)
  def >=(that: Any): Boolean = !(this < that)
}*/


class Time(hour: Int, minute: Int, second: Int, period: Period) {
	override def toString() : String = (s"TIME $hour:$minute:$second $period")	    
}

abstract class Period {
    case object AM extends Period
    case object PM extends Period
}

object Period extends Period {
    def parse(s: String): Period = s match {
      case "am" => AM
      case "pm" => PM
      case _    => null
    }
}
