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
	val rand = new Random()

	// an implicit conversion from string to Time object
	implicit def string2Time(s: String): Time = {
	    val pattern = "(\\d\\d):(\\d\\d) ([ap]m)".r
	    val pattern(hour, minute, period) = s;

	    new Time(hour.toInt, minute.toInt, Period.parse(period))
  	}

	// the keyword AT sets the Time and therefore the order of execution for the instruction
	object AT {
		var currTime = new Time(12, 0, Period.parse("am"))
		var currentOp: ClockOpEnum = NONE
		var setLine = true

		def apply(t: Time) = {
			timeSlot setTime t
			currTime = new Time(t.hour, t.minute, t.period)
			AtContinue
	    }

	    // all the commands that can be executed
	    object AtContinue {

	    	// Mathematical operations using ints
			def ADD(n: Int) = {
				if(setLine) {
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.ADDITION
					timeSlot addLine lineBuilder
					currentOp = ClockOps.ADDITION
				}
				CommandContinue
			}

			def SUBTRACT(n: Int) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.SUBTRACTION
					timeSlot addLine lineBuilder
					currentOp = ClockOps.SUBTRACTION
				}
				CommandContinue
			}

			def MULTIPLY_BY(n: Int) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.MULTIPLICATION
					timeSlot addLine lineBuilder
					currentOp = ClockOps.MULTIPLICATION
				}
				CommandContinue
			}

			def DIVIDE_BY(n: Int) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.DIVISION
					timeSlot addLine lineBuilder
					currentOp = ClockOps.DIVISION
				}
				CommandContinue
			}

			def RAISE_TO_POWER(n: Int) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.RAISE
					timeSlot addLine lineBuilder
					currentOp = ClockOps.RAISE
				}
				CommandContinue
			}

			def MODULUS(n: Int) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.MODULUS
					timeSlot addLine lineBuilder
					currentOp = ClockOps.MODULUS
				}
				CommandContinue
			}

			def GREATER_THAN(n: Int) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.GREATER 
					timeSlot addLine lineBuilder
					currentOp = ClockOps.GREATER
				}
				CommandContinue
			}

			def GREATER_THAN_EQUAL(n: Int) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.GREATER_EQUAL
					timeSlot addLine lineBuilder
					currentOp = ClockOps.GREATER_EQUAL
				}
				CommandContinue
			}

			def LESS_THAN(n: Int) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.LESS
					timeSlot addLine lineBuilder
					currentOp = ClockOps.LESS
				}
				CommandContinue
			}

			def LESS_THAN_EQUAL(n: Int) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.LESS_EQUAL
					timeSlot addLine lineBuilder
					currentOp = ClockOps.LESS_EQUAL
				}
				CommandContinue
			}

			def EQUAL(n: Int) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.EQUAL
					timeSlot addLine lineBuilder
					currentOp = ClockOps.EQUAL
				}
				CommandContinue
			}

			// Mathematical operations using doubles
			def ADD(n: Double) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.ADDITION_D
					timeSlot addLine lineBuilder
					currentOp = ClockOps.ADDITION_D
				}
				CommandContinue
			}

			def SUBTRACT(n: Double) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.SUBTRACTION_D
					timeSlot addLine lineBuilder
					currentOp = ClockOps.SUBTRACTION_D
				}
				CommandContinue
			}

			def MULTIPLY_BY(n: Double) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.MULTIPLICATION_D
					timeSlot addLine lineBuilder
					currentOp = ClockOps.MULTIPLICATION_D
				}
				CommandContinue
			}

			def DIVIDE_BY(n: Double) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.DIVISION_D
					timeSlot addLine lineBuilder
					currentOp = ClockOps.DIVISION_D
				}
				CommandContinue
			}

			def MODULUS(n: Double) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.MODULUS_D
					timeSlot addLine lineBuilder
					currentOp = ClockOps.MODULUS_D
				}
				CommandContinue
			}

			def RAISE_TO_POWER(n: Double) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.RAISE_D
					timeSlot addLine lineBuilder
					currentOp = ClockOps.RAISE_D
				}
				CommandContinue
			}

			def ADD_RANDOM() = {
				if(setLine){
					val n = rand.nextInt
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.ADDITION
					timeSlot addLine lineBuilder
					currentOp = ClockOps.ADDITION
				}
				RandomContinue
			}

			def SUBTRACT_RANDOM() = {
				if(setLine){
					val n = rand.nextInt
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.SUBTRACTION
					timeSlot addLine lineBuilder
					currentOp = ClockOps.SUBTRACTION
				}
				RandomContinue
			}

			def MULTIPLY_BY_RANDOM() = {
				if(setLine){
					val n = rand.nextInt
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.MULTIPLICATION
					timeSlot addLine lineBuilder
					currentOp = ClockOps.MULTIPLICATION
				}
				RandomContinue
			}

			def DIVIDE_BY_RANDOM() = {
				if(setLine){
					val n = rand.nextInt
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.DIVISION
					timeSlot addLine lineBuilder
					currentOp = ClockOps.DIVISION
				}
				RandomContinue
			}

			def MODULUS_RANDOM() = {
				if(setLine){
					val n = rand.nextInt
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.MODULUS
					timeSlot addLine lineBuilder
					currentOp = ClockOps.MODULUS
				}
				RandomContinue
			}

			def GREATER_THAN(n: Double) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.GREATER_D
					timeSlot addLine lineBuilder
					currentOp = ClockOps.GREATER_D
				}
				CommandContinue
			}

			def GREATER_THAN_EQUAL(n: Double) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.GREATER_EQUAL_D
					timeSlot addLine lineBuilder
					currentOp = ClockOps.GREATER_EQUAL_D
				}
				CommandContinue
			}

			def LESS_THAN(n: Double) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.LESS_D
					timeSlot addLine lineBuilder
					currentOp = ClockOps.LESS_D
				}
				CommandContinue
			}

			def LESS_THAN_EQUAL(n: Double) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.LESS_EQUAL_D
					timeSlot addLine lineBuilder
					currentOp = ClockOps.LESS_EQUAL_D
				}
				CommandContinue
			}

			def EQUAL(n: Double) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.EQUAL_D
					timeSlot addLine lineBuilder
					currentOp = ClockOps.EQUAL_D
				}
				CommandContinue
			}

			def NEGATE() = {
				if(setLine){
					lineBuilder setOp ClockOps.NEGATION
					timeSlot addLine lineBuilder
					currentOp = ClockOps.NEGATION
				}
				CommandContinue
			}

			def AND(b: Boolean) = {
				if(setLine){
					lineBuilder setBool b
					lineBuilder setOp ClockOps.AND
					timeSlot addLine lineBuilder
					currentOp = ClockOps.AND
				}
				CommandContinue
			}

			def OR(b: Boolean) = {
				if(setLine){
					lineBuilder setBool b
					lineBuilder setOp ClockOps.OR
					timeSlot addLine lineBuilder
					currentOp = ClockOps.OR
				}
				CommandContinue
			}

			def NOT(b: Boolean) = {
				if(setLine){
					lineBuilder setBool b
					lineBuilder setOp ClockOps.NOT
					timeSlot addLine lineBuilder
					currentOp = ClockOps.NOT
				}
				CommandContinue
			}

			def NOT_CURRENT() = {
				if(setLine){
					lineBuilder setOp ClockOps.NOT_CURRENT
					timeSlot addLine lineBuilder
					currentOp = ClockOps.NOT_CURRENT
				}
				CommandContinue
			}

			def APPEND_STRING(s: String) = {				
				if(setLine) {
					lineBuilder setString s
					lineBuilder setOp ClockOps.APP_STRING
					timeSlot addLine lineBuilder
					currentOp = ClockOps.APP_STRING
				}
				CommandContinue
			}

			def PREPEND_STRING(s: String) = {				
				if(setLine){
					lineBuilder setString s
					lineBuilder setOp ClockOps.PREP_STRING
				 	timeSlot addLine lineBuilder
				 	currentOp = ClockOps.PREP_STRING
				 }				
				CommandContinue
			}

			def REPLACE_STRING(s: String) = {
				if(setLine){
					lineBuilder setString s
					lineBuilder setOp ClockOps.REPLACE_STRING
					timeSlot addLine lineBuilder
					currentOp = ClockOps.REPLACE_STRING
				}
				CommandContinue
			}

			def REMOVE_STRING_END(n: Int) = {
				if(setLine){
					lineBuilder setNumber n				
					lineBuilder setOp ClockOps.REM_STR_END
					timeSlot addLine lineBuilder
					currentOp = ClockOps.REM_STR_END
				}				
				CommandContinue
			}

			def REMOVE_STRING_BEGINNING(n: Int) = {
				if(setLine){
					lineBuilder setNumber n
					lineBuilder setOp ClockOps.REM_STR_BEG
					timeSlot addLine lineBuilder
					currentOp = ClockOps.REM_STR_BEG
				}
				CommandContinue
			}

			def OUTPUT_INT() = {
				if(setLine){
					lineBuilder setOp ClockOps.OUTPUT_INT
					timeSlot addLine lineBuilder
					currentOp = ClockOps.OUTPUT_INT
				}
				CommandContinue
			}

			def OUTPUT_DOUBLE() = {
				if(setLine){
					lineBuilder setOp ClockOps.OUTPUT_DOUBLE
					timeSlot addLine lineBuilder
					currentOp = ClockOps.OUTPUT_DOUBLE
				}
				CommandContinue
			}

			def OUTPUT_BOOLEAN() = {
				if(setLine){
					lineBuilder setOp ClockOps.OUTPUT_BOOL
					timeSlot addLine lineBuilder
					currentOp = ClockOps.OUTPUT_BOOL
				}
				CommandContinue
			}

			def OUTPUT_STRING() = {
				if(setLine){
					lineBuilder setOp ClockOps.OUTPUT_STRING
					timeSlot addLine lineBuilder
					currentOp = ClockOps.OUTPUT_STRING
				}
				CommandContinue
			}

			object RandomContinue {
				def BETWEEN(lowerBound: Int) = {
					timeSlot removeLine;
					new RandContinue(lowerBound)
				}
			}

			class RandContinue(lower: Int) {
				def AND(upperBound: Int) = {
					if(setLine){
						val r = upperBound - lower
						val n = rand.nextInt(r) + lower
						lineBuilder setNumber n
						lineBuilder setOp currentOp
						timeSlot addLine lineBuilder
					}
					CommandContinue
				}
			}

			var loopTimes = 0

			object CommandContinue {
				def FOR(n: Int) = {
					loopTimes = n
					ForContinue
			    }

			    def UNTIL(t: Time) = {
			    	while(currTime < t){
			    		currTime++;
			    		timeSlot setTime currTime
			    		lineBuilder setOp currentOp
			    		timeSlot addLine lineBuilder
				    }
				    setLine = true
			    }

			    def THROUGH(t: Time) = {
			    	while(currTime <= t){
			    		currTime++;
			    		timeSlot setTime currTime
			    		lineBuilder setOp currentOp
			    		timeSlot addLine lineBuilder
				    }
				    setLine = true
			    }

			    object ForContinue{
			    	def MINUTES() = {
			    		var a = 0
			    		for (a <- 1 until loopTimes){
			    			currTime++;
			    			timeSlot setTime currTime
			    			lineBuilder setOp currentOp
			    			timeSlot addLine lineBuilder
			    		}
			    		setLine = true
			    	}

			    	def HOUR() = {
			    		loopTimes *= 60
			    		for (a <- 1 until loopTimes){
			    			currTime++;
			    			timeSlot setTime currTime
			    			lineBuilder setOp currentOp
			    			timeSlot addLine lineBuilder
			    		}
			    		setLine = true
			    	}

			    	def HOURS() = {
			    		loopTimes *= 60
			    		for (a <- 1 until loopTimes){
			    			currTime++;
			    			timeSlot setTime currTime
			    			lineBuilder setOp currentOp
			    			timeSlot addLine lineBuilder
			    		}
			    		setLine = true
			    	}
			    }

			    def IF_NUMBER_GREATER_THAN(n: Int) = {
		    		setLine = !(timeSlot.currentNumber > n)
		    		if (setLine){
		    			timeSlot removeLine
		    		}
		    		IfContinue			    	
			    }

			    def IF_NUMBER_LESS_THAN(n: Int) = {
		    		setLine = !(timeSlot.currentNumber < n)
		    		if (setLine){
		    			timeSlot removeLine
		    		}
		    		IfContinue			    	
			    }

			    def IF_NUMBER_GREATER_THAN_EQUAL(n: Int) = {
		    		setLine = !(timeSlot.currentNumber >= n)
		    		if (setLine){
		    			timeSlot removeLine
		    		}
		    		IfContinue			    	
			    }

			    def IF_NUMBER_LESS_THAN_EQUAL(n: Int) = {
		    		setLine = !(timeSlot.currentNumber <= n)
		    		if (setLine){
		    			timeSlot removeLine
		    		}
		    		IfContinue			    	
			    }

			    def IF_NUMBER_EQUAL(n: Int) = {
		    		setLine = !(timeSlot.currentNumber == n)
		    		if (setLine){
		    			timeSlot removeLine
		    		}
		    		IfContinue			    	
			    }

			    def IF_NUMBER_NOT_EQUAL(n: Int) = {
			    	setLine = !(timeSlot.currentNumber != n)
		    		if (setLine){
		    			timeSlot removeLine
		    		}
		    		IfContinue
			    }

			    object IfContinue {
			    	def ELSE() = {
			    		AtContinue
			    	}
			    }
			}
	    }
	    
	}

	def RUN = {
		timeSlot runProgram
	}

	// Time objects are used to control the flow of execution
	class Time(h: Int, m: Int, p: Period) {
		var hour: Int = h
		var minute: Int = m
		var period: Period = p

		// comparator methods that compares 2 Time objects
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
  		def ++(): Time = {
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
			var newTime: Time = new Time(hour, minute, period)
			return newTime
		}
		override def hashCode: Int = {
			val prime = 61
			var result = 1
			result = (prime * hour) + minute
			return result
		}
		override def toString() : String = (s"TIME " + hour + ":" + minute + " " + period)	    
	}
	// Period class distinguishes am and pm for Time objects, helps control execution flow
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
	/* TimeSlot class uses a HashMap to hold commands at different Times and executes the commands
		in order according to the Times, starting at 12:00 am and ending at 11:59 pm*/
	class TimeSlot{

		var currentTime = new Time(12, 1, Period.parse("am"))
		var currentNumber = 0.0
		var currentBoolean = false
		var currentString = ""
		//var startTime = new Time(12, 1, Period.parse("am"))
		//var endTime = new Time(11, 59, Period.parse("pm"))

		// HashMap that holds the commands for each time
		val timeTable = new HashMap[Time, ClockOp]

		/*def setStartTime(newTime: Time) = {
			startTime = newTime
		}*/
		// sets the Time for the next incoming command
		def setTime(newTime: Time) = {
			currentTime = new Time(newTime.hour, newTime.minute, newTime.period)
		}
		// adds the next command to the timeTable at the current Time
		def addLine(lineBuilder: ProgramLines) = {
			val line = lineBuilder.returnLine
			timeTable += Tuple2(currentTime, line)
		}
		//removes last line added in conditionals
		def removeLine() = {
			timeTable -= currentTime
		}
		// runs the program, executing commands in order of Time, like a clock, beginning at 12:00 am
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

						// Mathematical operations for ints
					    case ClockAddition(num: Int) => currentNumber += num.toDouble
					    case ClockSubtraction(num: Int) => currentNumber -= num.toDouble
					    case ClockMultiplication(num: Int) => currentNumber *= num.toDouble
					    case ClockDivision(num: Int) => currentNumber /= num.toDouble
					    case ClockModulus(num: Int) => currentNumber %= num.toDouble
					    case ClockRaise(num: Int) => currentNumber = scala.math.pow(currentNumber, num)

					    // Mathematical operations for doubles
					    case ClockAdditionD(num: Double) => currentNumber += num
					    case ClockSubtractionD(num: Double) => currentNumber -= num
					    case ClockMultiplicationD(num: Double) => currentNumber *= num
					    case ClockDivisionD(num: Double) => currentNumber /= num
					    case ClockModulusD(num: Double) => currentNumber %= num
					    case ClockRaiseD(num: Double) => currentNumber = scala.math.pow(currentNumber, num)

					    // Comparators for ints
					    case ClockGreater(num: Int) => currentBoolean = currentNumber > num.toDouble
					    case ClockGreaterEqual(num: Int) => currentBoolean = currentNumber >= num.toDouble
					    case ClockLess(num: Int) => currentBoolean = currentNumber < num.toDouble
					    case ClockLessEqual(num: Int) => currentBoolean = currentNumber <= num.toDouble
					    case ClockEqual(num: Int) => currentBoolean = currentNumber == num.toDouble

					    // Comparators for doubles
					    case ClockGreaterD(num: Double) => currentBoolean = currentNumber > num
					    case ClockGreaterEqualD(num: Double) => currentBoolean = currentNumber >= num
					    case ClockLessD(num: Double) => currentBoolean = currentNumber < num
					    case ClockLessEqualD(num: Double) => currentBoolean = currentNumber <= num
					    case ClockEqualD(num: Double) => currentBoolean = currentNumber == num

					    // Negates current number
					    case ClockNegation() => currentNumber = -currentNumber

					    // Boolean operations
					    case ClockAnd(bool: Boolean) => currentBoolean &= bool
					    case ClockOr(bool: Boolean) => currentBoolean |= bool
					    case ClockNot(bool: Boolean) => currentBoolean = !bool
					    case ClockNotCurrent() => currentBoolean = !currentBoolean

					    // String operations
					    case ClockAppString(str: String) => currentString += str
					    case ClockPrepString(str: String) => currentString = str + currentString
					    case ClockReplaceString(str: String) => currentString = str
					    case ClockRemoveStringEnd(num: Int) => currentString = currentString.dropRight(num)
					    case ClockRemoveStringBeg(num: Int) => currentString = currentString.drop(num)

					    // Outputs for different types
					    case ClockOutputInt() => println(currentNumber.toInt)
					    case ClockOutputDouble() => println(currentNumber.toDouble)
					    case ClockOutputBool() => println(currentBoolean)
					    case ClockOutputString() => println(currentString)
					}
				}
				runTime++;
			}
		}
	}
}