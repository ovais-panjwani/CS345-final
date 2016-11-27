package clock

import scala.language.implicitConversions

object TimeTests extends Clock{
	AT ("12:11 am") ADD 2;
	AT ("12:45 am") ADD 8;
	AT ("12:30 am") MULTIPLY_BY 3;
	AT ("1:30 pm") DIVIDE_BY 7;
	AT ("5:00 pm") OUTPUT_RESULT;
	RUN;
	/*val a: Time = new Time(12, 0, Period.parse("am"))
	val b: Time = new Time(12, 0, Period.parse("am"))
	val c: Time = new Time(11, 59, Period.parse("pm"))
	println(a == b)
	println(b == a)
	println(a == c)
	println(b == c)*/
}

