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
	      /*val hour: Int = t.hour
	      val minute: Int = t.minute
	      val period: Period = t.period
	      println(hour + ":" + minute + " " + period)*/
	    }

	    object AtContinue {
			def ADD(n: Int) = {
				lineBuilder setValue n
				lineBuilder setOp ClockOps.ADDITION
				timeSlot addLine lineBuilder
			}

			def SUBTRACT(n: Int) = {
				lineBuilder setValue n
				lineBuilder setOp ClockOps.SUBTRACTION
				timeSlot addLine lineBuilder
			}

			def MULTIPLY_BY(n: Int) = {
				lineBuilder setValue n
				lineBuilder setOp ClockOps.MULTIPLICATION
				timeSlot addLine lineBuilder
			}

			def DIVIDE_BY(n: Int) = {
				lineBuilder setValue n
				lineBuilder setOp ClockOps.DIVISION
				timeSlot addLine lineBuilder
			}

			def RAISE_TO_POWER(n: Int) = {
				lineBuilder setValue n
				lineBuilder setOp ClockOps.RAISE
				timeSlot addLine lineBuilder
			}

			def MODULUS(n: Int) = {
				lineBuilder setValue n
				lineBuilder setOp ClockOps.MODULUS
				timeSlot addLine lineBuilder
			}

			def ADD(n: Double) = {
				lineBuilder setValue n
				lineBuilder setOp ClockOps.ADDITION_D
				timeSlot addLine lineBuilder
			}

			def SUBTRACT(n: Double) = {
				lineBuilder setValue n
				lineBuilder setOp ClockOps.SUBTRACTION_D
				timeSlot addLine lineBuilder
			}

			def MULTIPLY_BY(n: Double) = {
				lineBuilder setValue n
				lineBuilder setOp ClockOps.MULTIPLICATION_D
				timeSlot addLine lineBuilder
			}

			def DIVIDE_BY(n: Double) = {
				lineBuilder setValue n
				lineBuilder setOp ClockOps.DIVISION_D
				timeSlot addLine lineBuilder
			}

			def MODULUS(n: Double) = {
				lineBuilder setValue n
				lineBuilder setOp ClockOps.MODULUS_D
				timeSlot addLine lineBuilder
			}

			def RAISE_TO_POWER(n: Double) = {
				lineBuilder setValue n
				lineBuilder setOp ClockOps.RAISE_D
				timeSlot addLine lineBuilder
			}

			def NEGATE() = {
				lineBuilder setOp ClockOps.NEGATION
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
	var currentResult = 0.0
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

				    case ClockAddition(num: Int) => currentResult += num.toDouble
				    case ClockSubtraction(num: Int) => currentResult -= num.toDouble
				    case ClockMultiplication(num: Int) => currentResult *= num.toDouble
				    case ClockDivision(num: Int) => currentResult /= num.toDouble
				    case ClockModulus(num: Int) => currentResult %= num.toDouble
				    case ClockRaise(num: Int) => currentResult = scala.math.pow(currentResult, num)

				    case ClockAdditionD(num: Double) => currentResult += num
				    case ClockSubtractionD(num: Double) => currentResult -= num
				    case ClockMultiplicationD(num: Double) => currentResult *= num
				    case ClockDivisionD(num: Double) => currentResult /= num
				    case ClockModulusD(num: Double) => currentResult %= num
				    case ClockRaiseD(num: Double) => currentResult = scala.math.pow(currentResult, num)

				    case ClockGreater(num: Double) => currentResult > num
				    case ClockGreaterEqual(num: Double) => currentResult >= num
				    case ClockLess(num: Double) => currentResult < num
				    case ClockLessEqual(num: Double) => currentResult <= num
				    case ClockEqual(num: Double) => currentResult == num

				    case ClockOutputInt() => println(currentResult.toInt)
				    case ClockOutputDouble() => println(currentResult.toDouble)

				    case ClockNegation() => currentResult = -currentResult
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