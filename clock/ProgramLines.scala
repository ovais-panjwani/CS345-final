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

	var currentNumber = 0

	def setValue(newValue: Int){
		currentNumber = newValue
	}

	def returnLine = {
	    var lineToReturn: ClockOp = ClockNone

	    currentOp match {

			case ADDITION => lineToReturn = ClockAddition(currentNumber)
			case SUBTRACTION => lineToReturn = ClockSubtraction(currentNumber)
			case MULTIPLICATION => lineToReturn = ClockMultiplication(currentNumber)
			case DIVISION => lineToReturn = ClockDivision(currentNumber)
			case RAISE => lineToReturn = ClockRaise(currentNumber)

			case GREATER => lineToReturn = ClockGreater(currentNumber)
			case GREATER_EQUAL => lineToReturn = ClockGreaterEqual(currentNumber)
			case LESS => lineToReturn = ClockLess(currentNumber)
			case LESS_EQUAL => lineToReturn = ClockLessEqual(currentNumber)
			case EQUAL => lineToReturn = ClockEqual(currentNumber)

			case OUTPUT => lineToReturn = ClockOutput()

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