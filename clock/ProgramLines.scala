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
	var currentBool = false
	var currentString = ""
	var currentChar: Char = ''

	def setNumber(newNum: Int){
		currentNumber = newNum.toDouble
	}

	def setNumber(newNum: Double){
		currentNumber = newNum
	}

	def setBool(newBool: Boolean){
		currentBool = newBool
	}

	def setString(newString: String){
		currentString = newString
	}

	def returnLine = {
	    var lineToReturn: ClockOp = ClockNone

	    currentOp match {

			case ADDITION => lineToReturn = ClockAddition(currentNumber.toInt)
			case SUBTRACTION => lineToReturn = ClockSubtraction(currentNumber.toInt)
			case MULTIPLICATION => lineToReturn = ClockMultiplication(currentNumber.toInt)
			case DIVISION => lineToReturn = ClockDivision(currentNumber.toInt)
			case MODULUS => lineToReturn = ClockModulus(currentNumber.toInt)
			case RAISE => lineToReturn = ClockRaise(currentNumber.toInt)

			case ADDITION_D => lineToReturn = ClockAdditionD(currentNumber)
			case SUBTRACTION_D => lineToReturn = ClockSubtractionD(currentNumber)
			case MULTIPLICATION_D => lineToReturn = ClockMultiplicationD(currentNumber)
			case DIVISION_D => lineToReturn = ClockDivisionD(currentNumber)
			case MODULUS_D => lineToReturn = ClockModulusD(currentNumber)
			case RAISE_D => lineToReturn = ClockRaiseD(currentNumber)

			case GREATER => lineToReturn = ClockGreater(currentNumber.toInt)
			case GREATER_EQUAL => lineToReturn = ClockGreaterEqual(currentNumber.toInt)
			case LESS => lineToReturn = ClockLess(currentNumber.toInt)
			case LESS_EQUAL => lineToReturn = ClockLessEqual(currentNumber.toInt)
			case EQUAL => lineToReturn = ClockEqual(currentNumber.toInt)

			case GREATER_D => lineToReturn = ClockGreaterD(currentNumber)
			case GREATER_EQUAL_D => lineToReturn = ClockGreaterEqualD(currentNumber)
			case LESS_D => lineToReturn = ClockLessD(currentNumber)
			case LESS_EQUAL_D => lineToReturn = ClockLessEqualD(currentNumber)
			case EQUAL_D => lineToReturn = ClockEqualD(currentNumber)

			case NEGATION => lineToReturn = ClockNegation()

			case AND => lineToReturn = ClockAnd(currentBool)
			case OR => lineToReturn = ClockOr(currentBool)
			case NOT => lineToReturn = ClockNot(currentBool)
			case NOT_CURRENT => lineToReturn = ClockNotCurrent()

			case APP_STRING => lineToReturn =  ClockAppString(currentString)
			case PREP_STRING => lineToReturn =  ClockPrepString(currentString)
			case REPLACE_STRING => lineToReturn =  ClockReplaceString(currentString)
			case REM_STR_END => lineToReturn =  ClockRemoveStringEnd(currentNumber.toInt)
			case REM_STR_BEG => lineToReturn =  ClockRemoveStringBeg(currentNumber.toInt)

			case OUTPUT_INT => lineToReturn = ClockOutputInt()
			case OUTPUT_DOUBLE => lineToReturn = ClockOutputDouble()
			case OUTPUT_BOOL => lineToReturn = ClockOutputBool()
			case OUTPUT_STRING => lineToReturn = ClockOutputString()

			case NONE => throw new RuntimeException("Adding an empty line")
		}

		// reset everything in prep for next line
		// reset op
		currentOp = NONE

		lineToReturn
	}
}