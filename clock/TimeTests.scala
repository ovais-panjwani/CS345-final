package clock

import scala.language.implicitConversions
import scala.language.postfixOps

object TimeTests extends Clock{
	AT ("12:11 am") ADD 2;
	AT ("12:45 am") ADD 8.5;
	AT ("12:30 am") MULTIPLY_BY 3.2;
	AT ("01:30 pm") DIVIDE_BY 7;
	AT ("05:00 pm") OUTPUT_DOUBLE;
	AT ("12:40 am") OUTPUT_INT;
	AT ("01:01 pm") OUTPUT_DOUBLE;
	AT ("01:45 pm") RAISE_TO_POWER 3.0;
	AT ("01:40 pm") OUTPUT_INT;
	RUN;
	val a = new Time(12, 1, Period.parse("am"))
	val b = new Time(12, 2, Period.parse("am"))
	val c = new Time(12, 1, Period.parse("pm"))
	val d = new Time(11, 59, Period.parse("am"))
	println(a < b)
	println(b < c)
	println(a == c)
	println(c <= d)
	println(d < c)
	println(a < d)
	println(d <= b)
}

