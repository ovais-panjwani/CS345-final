package clock

class ProgramLines{
	import ClockOps._
	import ClockOpLines._

	// holds last operation
	var currentOp: ClockOpEnum = NONE

	/* set the next op */
	def setOp(newOp: ClockOpEnum) = {
		currentOp = newOp
	}

	/* returns the currently set op */
	def getOp = currentOp

	var currentNumber = 0.0

	def setValue(newValue: Int){
		currentNumber = newValue.toDouble
	}

	def setValue(newValue: Double){
		currentNumber = newValue
	}

	def returnLine = {
	    var lineToReturn: ClockOp = ClockNone

	    currentOp match {

			case ADDITION => lineToReturn = ClockAddition(currentNumber.toInt)
			case SUBTRACTION => lineToReturn = ClockSubtraction(currentNumber.toInt)
			case MULTIPLICATION => lineToReturn = ClockMultiplication(currentNumber.toInt)
			case DIVISION => lineToReturn = ClockDivision(currentNumber.toInt)
			case RAISE => lineToReturn = ClockRaise(currentNumber.toInt)

			case ADDITION_D => lineToReturn = ClockAdditionD(currentNumber)
			case SUBTRACTION_D => lineToReturn = ClockSubtractionD(currentNumber)
			case MULTIPLICATION_D => lineToReturn = ClockMultiplicationD(currentNumber)
			case DIVISION_D => lineToReturn = ClockDivisionD(currentNumber)
			case RAISE_D => lineToReturn = ClockRaiseD(currentNumber)

			case GREATER => lineToReturn = ClockGreater(currentNumber)
			case GREATER_EQUAL => lineToReturn = ClockGreaterEqual(currentNumber)
			case LESS => lineToReturn = ClockLess(currentNumber)
			case LESS_EQUAL => lineToReturn = ClockLessEqual(currentNumber)
			case EQUAL => lineToReturn = ClockEqual(currentNumber)

			case OUTPUT_INT => lineToReturn = ClockOutputInt()
			case OUTPUT_DOUBLE => lineToReturn = ClockOutputDouble()

			case NEGATION => lineToReturn = ClockNegation()

			case NONE => throw new RuntimeException("Adding an empty line")

			/*case NONE =>
			if (!firstLine)
			    throw new RuntimeException("Adding an empty line")
			else
			    // first line meaning nothing supposed to be there
			    firstLine = false*/
		}

		// reset everything in prep for next line
		// reset op
		currentOp = NONE

		lineToReturn
	}
}