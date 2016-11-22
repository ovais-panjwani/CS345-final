package clock

// for the random number generator
import scala.util.Random
import scala.language.implicitConversions

// The class that holds all of the keywords for Clock and does the parsing
class Clock extends App{
	// a random number generator for when the user requests a random number
	val rnd = new Random()

	implicit def string2Time(s: String): Time = {
	    val pattern = "(\\d\\d):(\\d\\d):(\\d\\d) ([ap]m)".r
	    val pattern(hour, minute, second, period) = s;

	    new Time(hour.toInt, minute.toInt, second.toInt, Period.parse(period))
  	}

	// the keyword AT sets the Time and therefore the order of execution for the instruction
	object AT {
		def apply(t: Time): Unit = {
	      println(t)
	    }
	}

	// print something
	def PRINT(a: Any) = {
		println(a)
	}

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
}