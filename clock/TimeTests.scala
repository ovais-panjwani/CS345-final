package clock

import scala.language.implicitConversions
import scala.language.postfixOps

object TimeTests extends Clock{
	AT ("12:11 am") ADD 2 FOR 3 MINUTES;

	AT ("12:45 am") ADD (8.5 + 1.5);

	AT ("12:30 am") MULTIPLY_BY_RANDOM() BETWEEN 5 AND 10;

	AT ("01:30 pm") DIVIDE_BY 2;

	AT ("05:00 pm") OUTPUT_DOUBLE;

	AT ("12:40 am") OUTPUT_INT() FOR 4 MINUTES;

	AT ("12:50 am") OUTPUT_DOUBLE;

	AT ("01:01 pm") OUTPUT_DOUBLE;

	AT ("01:45 pm") RAISE_TO_POWER 3.0;

	AT ("01:40 pm") OUTPUT_INT;

	AT ("02:00 am") MODULUS 5;

	AT ("02:02 am") OUTPUT_DOUBLE;

	AT ("02:01 am") NEGATE;
	
	AT ("03:15 am") GREATER_THAN 10;
	
	AT ("03:45 am") LESS_THAN_EQUAL 10.0;
	
	AT ("03:30 am") OUTPUT_BOOLEAN;
	
	AT ("04:00 am") OUTPUT_BOOLEAN() UNTIL ("04:05 am");
	
	AT ("04:15 am") NOT_CURRENT;
	
	AT ("04:30 am") OUTPUT_BOOLEAN;
	
	AT ("04:45 am") NOT true;
	
	AT ("05:00 am") OUTPUT_BOOLEAN;
	
	AT ("05:15 am") OR (true || false);
	
	AT ("05:30 am") OUTPUT_BOOLEAN;
	
	AT ("02:00 pm") APPEND_STRING "is ";
	
	AT ("02:20 pm") PREPEND_STRING "This ";
	
	AT ("02:10 pm") APPEND_STRING "a string, yo";
	
	AT ("02:15 pm") REMOVE_STRING_END 4;
	
	AT ("02:05 pm") PREPEND_STRING "sure ";
	
	AT ("02:30 pm") OUTPUT_STRING() FOR 5 MINUTES;

	AT ("02:22 pm") PREPEND_STRING "Yes, ";

	AT ("02:26 pm") REMOVE_STRING_BEGINNING 5;

	AT ("02:25 pm") OUTPUT_STRING;

	AT ("03:00 pm") APPEND_STRING "This is a new string" IF_NUMBER_LESS_THAN 1 ELSE() REMOVE_STRING_END 7 FOR 2 MINUTES;

	AT ("03:05 pm") OUTPUT_STRING() FOR 2 MINUTES;
	
	RUN;
	/*val a = new Time(12, 1, Period.parse("am"))
	val b = new Time(12, 2, Period.parse("am"))
	val c = new Time(12, 1, Period.parse("pm"))
	val d = new Time(11, 59, Period.parse("am"))
	println(a < b)
	println(b < c)
	println(a == c)
	println(c <= d)
	println(d < c)
	println(a < d)
	println(d <= b)*/
}

