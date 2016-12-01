package clock

import scala.collection.mutable.HashMap
import ClockOpLines._
import ClockOps._

/* class that controls the order of execution by placing things in order
of their Time of execution*/
class TimeSlot extends Clock{

	var currentTime = new Time(12, 1, Period.parse("am"))
	var currentResult = 0

	val timeTable = new HashMap[Time, ClockOp]

	def setTime(newTime: Time) = {
		currentTime = newTime
	}

	def addLine(lineBuilder: ProgramLines) = {
		val line = lineBuilder.returnLine
		timeTable += Tuple2(currentTime, line)
		println(currentResult)

	}

	def runProgram() = {
		var hour = 12
		var minute = 0
		var period = Period.parse("am")
		val endTime = new Time(11, 59, Period.parse("pm"))
		var runTime = new Time(hour, minute, period)
		while (runTime != endTime){
			println("I'm in")
			val currentLine = timeTable(runTime)

			currentLine match {
				case ClockNone => // do nothing

			    case ClockGreater(num: Int) => currentResult > num
			    case ClockGreaterEqual(num: Int) => currentResult >= num
			    case ClockLess(num: Int) => currentResult < num
			    case ClockLessEqual(num: Int) => currentResult <= num
			    case ClockEqual(num: Int) => currentResult == num

			    case ClockAddition(num: Int) => currentResult += num
			    case ClockSubtraction(num: Int) => currentResult -= num
			    case ClockMultiplication(num: Int) => currentResult *= num
			    case ClockDivision(num: Int) => currentResult /= num

			    case ClockNegation() => currentResult = -currentResult
			}
			if (minute == 59){
				minute = 0
				hour+=1
			}else{
				minute+=1
			}
			if(hour > 12){
				hour = 1
				if(period == Period.parse("am")){
					period = Period.parse("pm")
				}else{
					period = Period.parse("am")
				}
			} 
			runTime = new Time(hour, minute, period)
			println(runTime)
		}
	}
}