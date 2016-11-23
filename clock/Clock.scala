package clock

// for the random number generator
import scala.util.Random
import scala.language.implicitConversions

// The class that holds all of the keywords for Clock and does the parsing
class Clock{

	// an implicit conversion from string to Time object
	implicit def string2Time(s: String): Time = {
	    val pattern = "(\\d\\d):(\\d\\d) ([ap]m)".r
	    val pattern(hour, minute, period) = s;

	    new Time(hour.toInt, minute.toInt, Period.parse(period))
  	}

	// the keyword AT sets the Time and therefore the order of execution for the instruction
	object AT {
		def apply(t: Time): Unit = {
	      val hour: Int = t.hour
	      val minute: Int = t.minute
	      val period: Period = t.period
	      println(hour + ":" + minute + " " + period)
	    }
	}

	// print something
	def PRINT(a: Any) = {
		println(a)
	}

	class Time(h: Int, m: Int, p: Period) {
		val hour: Int = h
		val minute: Int = m
		val period: Period = p
		override def toString() : String = (s"TIME " + hour + ":" + minute + " " + period)	    
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
}