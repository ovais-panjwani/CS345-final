package clock

import scala.language.implicitConversions
import scala.language.postfixOps

object TimeTests extends Clock{
	// Math functions
	AT ("12:00 am") ADD 2 FOR 5 MINUTES;

	AT ("12:45 am") ADD (8.75 + 3.75);

	AT ("12:35 am") MULTIPLY_BY_RANDOM() BETWEEN 3 AND 5;

	AT ("12:15 am") ADD 1 THROUGH ("12:29 am");

	AT ("12:20 am") SUBTRACT 10;

	AT ("1:00 am") MODULUS 5;

	AT ("1:30 am") DIVIDE_BY 2;

	AT ("1:25 am") ADD_RANDOM() BETWEEN 10 AND 20;

	AT ("1:15 am") RAISE_TO_POWER 3.0;

	AT ("1:40 am") MULTIPLY_BY 2.5;

	AT ("2:03 am") NEGATE; // Command gets overwritten by loop at line 54

	AT ("2:00 am") NEGATE;

	AT ("2:15 am") ADD 2 FOR 2 HOURS;

	AT ("4:30 am") SUBTRACT 1 FOR 1 HOUR;

	AT ("12:06 am") OUTPUT_INT; // Result = 10

	AT ("12:30 am") OUTPUT_DOUBLE; // Result = 14.0

	AT ("12:40 am") OUTPUT_INT() FOR 3 MINUTES;

	AT ("12:50 am") OUTPUT_DOUBLE() UNTIL ("12:55 am");

	AT ("1:05 am") OUTPUT_INT;

	AT ("1:20 am") OUTPUT_DOUBLE;

	AT ("1:26 am") OUTPUT_INT;

	AT ("1:35 am") OUTPUT_DOUBLE;

	AT ("1:45 am") OUTPUT_DOUBLE;

	AT ("2:01 am") OUTPUT_INT() THROUGH ("2:05 am");

	AT ("4:20 am") OUTPUT_INT;

	AT ("5:35 am") OUTPUT_DOUBLE;

	//AT ("2:03 am") NEGATE; // Command interrupts loop at line 54
	
	// Boolean functions
	AT ("9:15 am") GREATER_THAN 10;
	
	AT ("9:45 am") LESS_THAN_EQUAL 10.0;
	
	AT ("10:15 am") NOT_CURRENT;
	
	AT ("10:45 am") NOT true;
	
	AT ("11:15 am") OR (true || false);

	AT ("12:15 am") EQUAL 15.75;

	AT ("11:30 am") AND(5 > 10);

	AT ("11:45 am") NOT_EQUAL 50;

	AT ("9:30 am") OUTPUT_BOOLEAN;
	
	AT ("10:00 am") OUTPUT_BOOLEAN() UNTIL ("10:05 am");

	AT ("10:20 am") OUTPUT_BOOLEAN;

	AT ("10:50 am") OUTPUT_BOOLEAN;

	AT ("11:20 am") OUTPUT_BOOLEAN;

	AT ("11:35 am") OUTPUT_BOOLEAN;

	AT ("12:00 pm") OUTPUT_BOOLEAN() FOR 3 MINUTES;

	AT ("12:30 pm") OUTPUT_BOOLEAN;

	// String manipulation
	AT ("2:00 pm") APPEND_STRING "is ";
	
	AT ("2:20 pm") PREPEND_STRING "This ";
	
	AT ("2:10 pm") APPEND_STRING "a string, yo ";
	
	AT ("2:15 pm") REMOVE_STRING_END 5;
	
	AT ("2:05 pm") PREPEND_STRING "sure ";

	AT ("2:22 pm") PREPEND_STRING "Yes, ";

	AT ("2:26 pm") REMOVE_STRING_BEGINNING 5;	

	AT ("3:00 pm") APPEND_STRING "This is a new string " IF_NUMBER_GREATER_THAN 10 ELSE() REMOVE_STRING_END 2;

	AT ("2:25 pm") OUTPUT_STRING;

	AT ("2:12 pm") OUTPUT_STRING;

	AT ("2:30 pm") OUTPUT_STRING() FOR 3 MINUTES;

	AT ("3:05 pm") OUTPUT_STRING() FOR 2 MINUTES;
	
	RUN FOR 2 DAYS;

	CLEAR;

	AT ("12:05 am") ADD_RANDOM;

	AT ("12:15 am") OUTPUT_INT;

	AT ("12:00 am") APPEND_STRING "This is a new program";

	AT ("12:10 am") OUTPUT_STRING;

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

