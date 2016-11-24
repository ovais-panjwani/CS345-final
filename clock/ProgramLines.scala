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

	      case GREATER => lineToReturn = ClockGreater()
	      case GREATER_EQUAL => lineToReturn = ClockGreaterEqual()
	      case LESS => lineToReturn = ClockLess()
	      case LESS_EQUAL => lineToReturn = ClockLessEqual()
	      case EQUAL => lineToReturn = ClockEqual()

	      case ADDITION => lineToReturn = ClockAddition(currentNumber)
	      case SUBTRACTION => lineToReturn = ClockSubtraction()
	      case MULTIPLICATION => lineToReturn = ClockMultiplication()
	      case DIVISION => lineToReturn = ClockDivision()

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