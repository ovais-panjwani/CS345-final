package clock

import java.text.SimpleDateFormat

// overwrites order operations
trait Ord {
  def < (that: Any): Boolean
  def <=(that: Any): Boolean =  (this < that) || (this == that)
  def > (that: Any): Boolean = !(this <= that)
  def >=(that: Any): Boolean = !(this < that)
}

// class that defines Time objects which are used to control execution order
class TimeFormat(pattern: String) {
  private val format = new SimpleDateFormat(pattern)

  def parse(str: String): Time = {
    // SimpleDateFormat is not thread-safe
    val date = format.synchronized(format.parse(str))
    if (date == null) {
      throw new Exception("Unable to parse date-time: " + str)
    } else {
      Time.fromMilliseconds(date.getTime())
    }
  }

  def format(time: Time): String = {
    format.synchronized(format.format(time.toDate))
  }
}