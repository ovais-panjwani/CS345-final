package clock

object ClockOpLines {
  abstract sealed class ClockOp

  case object ClockNone extends ClockOp

  case class ClockAddition(num: Int) extends ClockOp
  case class ClockSubtraction(num: Int) extends ClockOp
  case class ClockMultiplication(num: Int) extends ClockOp
  case class ClockDivision(num: Int) extends ClockOp
  case class ClockRaise(num: Int) extends ClockOp

  case class ClockAdditionD(num: Double) extends ClockOp
  case class ClockSubtractionD(num: Double) extends ClockOp
  case class ClockMultiplicationD(num: Double) extends ClockOp
  case class ClockDivisionD(num: Double) extends ClockOp
  case class ClockRaiseD(num: Double) extends ClockOp

  case class ClockGreater(num: Double) extends ClockOp
  case class ClockGreaterEqual(num: Double) extends ClockOp
  case class ClockLess(num: Double) extends ClockOp
  case class ClockLessEqual(num: Double) extends ClockOp
  case class ClockEqual(num: Double) extends ClockOp

  case class ClockOutputInt() extends ClockOp
  case class ClockOutputDouble() extends ClockOp

  case class ClockNegation() extends ClockOp
}