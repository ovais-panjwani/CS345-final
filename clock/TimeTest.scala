import scala.language.implicitConversions

object TimeTest extends App {

  implicit def string2Time(s: String): Time = {
    val pattern = "(\\d\\d):(\\d\\d):(\\d\\d) ([ap]m)".r
    val pattern(hour, minute, second, period) = s;

    new Time(hour.toInt, minute.toInt, second.toInt, Period.parse(period))
  }
  
  AT ("12:00:00 am")
  
  object AT {

    def apply(t: Time): Unit = {
      println(t)
    }

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