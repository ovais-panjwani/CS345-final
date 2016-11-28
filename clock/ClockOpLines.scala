package clock

// line types for storing lines in TimeSlot
object ClockOpLines {
  abstract sealed class ClockOp

  case object ClockNone extends ClockOp

  case class ClockAddition(num: Int) extends ClockOp
  case class ClockSubtraction(num: Int) extends ClockOp
  case class ClockMultiplication(num: Int) extends ClockOp
  case class ClockDivision(num: Int) extends ClockOp
  case class ClockModulus(num: Int) extends ClockOp
  case class ClockRaise(num: Int) extends ClockOp

  case class ClockAdditionD(num: Double) extends ClockOp
  case class ClockSubtractionD(num: Double) extends ClockOp
  case class ClockMultiplicationD(num: Double) extends ClockOp
  case class ClockDivisionD(num: Double) extends ClockOp
  case class ClockModulusD(num: Double) extends ClockOp
  case class ClockRaiseD(num: Double) extends ClockOp

  case class ClockGreater(num: Int) extends ClockOp
  case class ClockGreaterEqual(num: Int) extends ClockOp
  case class ClockLess(num: Int) extends ClockOp
  case class ClockLessEqual(num: Int) extends ClockOp
  case class ClockEqual(num: Int) extends ClockOp

  case class ClockGreaterD(num: Double) extends ClockOp
  case class ClockGreaterEqualD(num: Double) extends ClockOp
  case class ClockLessD(num: Double) extends ClockOp
  case class ClockLessEqualD(num: Double) extends ClockOp
  case class ClockEqualD(num: Double) extends ClockOp

  case class ClockNegation() extends ClockOp

  case class ClockAnd(bool: Boolean) extends ClockOp
  case class ClockOr(bool: Boolean) extends ClockOp
  case class ClockNot(bool: Boolean) extends ClockOp
  case class ClockNotCurrent() extends ClockOp

  case class ClockAppString(str: String) extends ClockOp
  case class ClockPrepString(str: String) extends ClockOp
  case class ClockReplaceString(str: String) extends ClockOp
  case class ClockRemoveStringEnd(num: Int) extends ClockOp
  case class ClockRemoveStringBeg(num: Int) extends ClockOp

  case class ClockOutputInt() extends ClockOp
  case class ClockOutputDouble() extends ClockOp
  case class ClockOutputBool() extends ClockOp
  case class ClockOutputString() extends ClockOp
}