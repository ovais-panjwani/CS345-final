package clock

// for the random number generator
import scala.util.Random
import scala.language.implicitConversions
import scala.language.postfixOps

import scala.collection.mutable.HashMap
import ClockOpLines._
import ClockOps._

// The class that holds all of the keywords for Clock and does the parsing
class Clock extends App{

	val lineBuilder = new ProgramLines
	val timeSlot = new TimeSlot

	// an implicit conversion from string to Time object
	implicit def string2Time(s: String): Time = {
	    val pattern = "(\\d\\d):(\\d\\d) ([ap]m)".r
	    val pattern(hour, minute, period) = s;

	    new Time(hour.toInt, minute.toInt, Period.parse(period))
  	}

	// the keyword AT sets the Time and therefore the order of execution for the instruction
	object AT {
		def apply(t: Time) = {
			timeSlot setTime t
			AtContinue
	    }

	    object AtContinue {
			def ADD(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.ADDITION
				timeSlot addLine lineBuilder
			}

			def SUBTRACT(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.SUBTRACTION
				timeSlot addLine lineBuilder
			}

			def MULTIPLY_BY(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.MULTIPLICATION
				timeSlot addLine lineBuilder
			}

			def DIVIDE_BY(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.DIVISION
				timeSlot addLine lineBuilder
			}

			def RAISE_TO_POWER(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.RAISE
				timeSlot addLine lineBuilder
			}

			def MODULUS(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.MODULUS
				timeSlot addLine lineBuilder
			}

			def GREATER_THAN(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.GREATER 
				timeSlot addLine lineBuilder
			}

			def GREATER_THAN_EQUAL(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.GREATER_EQUAL
				timeSlot addLine lineBuilder
			}

			def LESS_THAN(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.LESS
				timeSlot addLine lineBuilder
			}

			def LESS_THAN_EQUAL(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.LESS_EQUAL
				timeSlot addLine lineBuilder
			}

			def EQUAL(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.EQUAL
				timeSlot addLine lineBuilder
			}

			def ADD(n: Double) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.ADDITION_D
				timeSlot addLine lineBuilder
			}

			def SUBTRACT(n: Double) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.SUBTRACTION_D
				timeSlot addLine lineBuilder
			}

			def MULTIPLY_BY(n: Double) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.MULTIPLICATION_D
				timeSlot addLine lineBuilder
			}

			def DIVIDE_BY(n: Double) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.DIVISION_D
				timeSlot addLine lineBuilder
			}

			def MODULUS(n: Double) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.MODULUS_D
				timeSlot addLine lineBuilder
			}

			def RAISE_TO_POWER(n: Double) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.RAISE_D
				timeSlot addLine lineBuilder
			}

			def GREATER_THAN_D(n: Double) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.GREATER 
				timeSlot addLine lineBuilder
			}

			def GREATER_THAN_EQUAL_D(n: Double) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.GREATER_EQUAL
				timeSlot addLine lineBuilder
			}

			def LESS_THAN_D(n: Double) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.LESS
				timeSlot addLine lineBuilder
			}

			def LESS_THAN_EQUAL_D(n: Double) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.LESS_EQUAL
				timeSlot addLine lineBuilder
			}

			def EQUAL_D(n: Double) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.EQUAL
				timeSlot addLine lineBuilder
			}

			def NEGATE() = {
				lineBuilder setOp ClockOps.NEGATION
				timeSlot addLine lineBuilder
			}

			def AND(b: Boolean) = {
				lineBuilder setBool b
				lineBuilder setOp ClockOps.AND
				timeSlot addLine lineBuilder
			}

			def OR(b: Boolean) = {
				lineBuilder setBool b
				lineBuilder setOp ClockOps.OR
				timeSlot addLine lineBuilder
			}

			def NOT(b: Boolean) = {
				lineBuilder setBool b
				lineBuilder setOp ClockOps.NOT
				timeSlot addLine lineBuilder
			}

			def NOT_CURRENT() = {
				lineBuilder setOp ClockOps.NOT_CURRENT
				timeSlot addLine lineBuilder
			}

			def APPEND_STRING(s: String) = {
				lineBuilder setString s
				lineBuilder setOp ClockOps.APP_STRING
				timeSlot addLine lineBuilder
			}

			def PREPEND_STRING(s: String) = {
				lineBuilder setString s
				lineBuilder setOp ClockOps.PREP_STRING
				timeSlot addLine lineBuilder
			}

			def REPLACE_STRING(s: String) = {
				lineBuilder setString s
				lineBuilder setOp ClockOps.REPLACE_STRING
				timeSlot addLine lineBuilder
			}

			def REMOVE_STRING_END(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.REM_STR_END
				timeSlot addLine lineBuilder
			}

			def REMOVE_STRING_BEGINNING(n: Int) = {
				lineBuilder setNumber n
				lineBuilder setOp ClockOps.REM_STR_BEG
				timeSlot addLine lineBuilder
			}

			def OUTPUT_INT() = {
				lineBuilder setOp ClockOps.OUTPUT_INT
				timeSlot addLine lineBuilder
			}

			def OUTPUT_DOUBLE() = {
				lineBuilder setOp ClockOps.OUTPUT_DOUBLE
				timeSlot addLine lineBuilder
			}

			def OUTPUT_BOOLEAN() = {
				lineBuilder setOp ClockOps.OUTPUT_BOOL
				timeSlot addLine lineBuilder
			}

			def OUTPUT_STRING() = {
				lineBuilder setOp ClockOps.OUTPUT_STRING
				timeSlot addLine lineBuilder
			}
	    }
	    
	}

	def RUN = {
		timeSlot runProgram
	}

	class Time(h: Int, m: Int, p: Period) {
		val hour: Int = h
		val minute: Int = m
		val period: Period = p
		override def equals(that: Any): Boolean = 
			that match{
				case that: Time => this.hour == that.hour && this.minute == that.minute && this.period == that.period
				case _ => false
			}
		def < (that: Any): Boolean = 
			that match{
				case that: Time => (((this.hour == 12) && (this.period == Period.parse("am"))) && ((that.hour != 12) || (that.period == Period.parse("pm")))) ||
					((this.period == Period.parse("am")) && (that.period == Period.parse("pm"))) ||
					(((that.hour != 12) && (that.period != Period.parse("am"))) && (this.period == that.period) && (this.hour < that.hour)) || 
					((this.period == that.period) && (this.hour == that.hour) && (this.minute < that.minute))
				case _ => false
			}
		def <=(that: Any): Boolean = 
			that match{
				case that: Time => ((this < that) || (this == that))
				case _ => false
			}
  		def > (that: Any): Boolean = 
  			that match{
  				case that: Time => !(this <= that)
  				case _ => false
  			}
  		def >=(that: Any): Boolean = 
  			that match{
  				case that: Time => !(this < that)
  				case _ => false
  			}
		override def hashCode: Int = {
			val prime = 61
			var result = 1
			result = (prime * hour) + minute
			return result
		}
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

	class TimeSlot{

	var currentTime = new Time(12, 1, Period.parse("am"))
	var currentNumber = 0.0
	var currentBoolean = false
	var currentString = ""

	val timeTable = new HashMap[Time, ClockOp]

	def setTime(newTime: Time) = {
		currentTime = newTime
	}

	def addLine(lineBuilder: ProgramLines) = {
		val line = lineBuilder.returnLine
		timeTable += Tuple2(currentTime, line)
	}

	def runProgram() = {
		var hour = 12
		var minute = 0
		var period = Period.parse("am")
		val endTime = new Time(11, 59, Period.parse("pm"))
		var runTime = new Time(hour, minute, period)
		while (runTime != endTime){
			if(timeTable contains runTime){
				val currentLine = timeTable(runTime)
				currentLine match {
					case ClockNone => // do nothing

				    case ClockAddition(num: Int) => currentNumber += num.toDouble
				    case ClockSubtraction(num: Int) => currentNumber -= num.toDouble
				    case ClockMultiplication(num: Int) => currentNumber *= num.toDouble
				    case ClockDivision(num: Int) => currentNumber /= num.toDouble
				    case ClockModulus(num: Int) => currentNumber %= num.toDouble
				    case ClockRaise(num: Int) => currentNumber = scala.math.pow(currentNumber, num)

				    case ClockAdditionD(num: Double) => currentNumber += num
				    case ClockSubtractionD(num: Double) => currentNumber -= num
				    case ClockMultiplicationD(num: Double) => currentNumber *= num
				    case ClockDivisionD(num: Double) => currentNumber /= num
				    case ClockModulusD(num: Double) => currentNumber %= num
				    case ClockRaiseD(num: Double) => currentNumber = scala.math.pow(currentNumber, num)

				    case ClockGreater(num: Int) => currentBoolean = currentNumber > num.toDouble
				    case ClockGreaterEqual(num: Int) => currentBoolean = currentNumber >= num.toDouble
				    case ClockLess(num: Int) => currentBoolean = currentNumber < num.toDouble
				    case ClockLessEqual(num: Int) => currentBoolean = currentNumber <= num.toDouble
				    case ClockEqual(num: Int) => currentBoolean = currentNumber == num.toDouble

				    case ClockGreaterD(num: Double) => currentBoolean = currentNumber > num
				    case ClockGreaterEqualD(num: Double) => currentBoolean = currentNumber >= num
				    case ClockLessD(num: Double) => currentBoolean = currentNumber < num
				    case ClockLessEqualD(num: Double) => currentBoolean = currentNumber <= num
				    case ClockEqualD(num: Double) => currentBoolean = currentNumber == num

				    case ClockNegation() => currentNumber = -currentNumber

				    case ClockAnd(bool: Boolean) => currentBoolean &= bool
				    case ClockOr(bool: Boolean) => currentBoolean |= bool
				    case ClockNot(bool: Boolean) => currentBoolean = !bool
				    case ClockNotCurrent() => currentBoolean = !currentBoolean

				    case ClockAppString(str: String) => currentString += str
				    case ClockPrepString(str: String) => currentString = str + currentString
				    case ClockReplaceString(str: String) => currentString = str
				    case ClockRemoveStringEnd(num: Int) => currentString = currentString.dropRight(num)
				    case ClockRemoveStringBeg(num: Int) => currentString = currentString.drop(num)

				    case ClockOutputInt() => println(currentNumber.toInt)
				    case ClockOutputDouble() => println(currentNumber.toDouble)
				    case ClockOutputBool() => println(currentBoolean)
				    case ClockOutputString() => println(currentString)
				}
			}
			if (minute == 59){
				minute = 0
				hour+=1
				if(hour > 12){
					hour = 1
				}else if(hour == 12){
					if(period == Period.parse("am")){
						period = Period.parse("pm")
					}else{
						period = Period.parse("am")
					}
				}
			}else{
				minute+=1
			}
			runTime = new Time(hour, minute, period)
		}
	}
}
}