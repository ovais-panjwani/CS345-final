package clock

import scala.collection.mutable.HashMap
import ClockOpLines._
import ClockOps._

/* class that controls the order of execution by placing things in order
of their Time of execution*/
object TimeSlot extends Clock{

	var currentTime = new Time(12, 1, Period.parse("am"))

	val timeTable = new HashMap[Time, ClockOp]

	def setTime(newTime: Time) = {
		currentTime = newTime
	}

	def addLine(lineBuilder: ProgramLines) = {
		val line = lineBuilder.returnLine
		timeTable += Tuple2(currentTime, line)

	}

	def runProgram() = {

	}

	println(currentTime)

}