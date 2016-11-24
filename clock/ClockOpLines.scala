package clock

object ClockOpLines {
  abstract sealed class ClockOp

  case object ClockNone extends ClockOp

  case class ClockGreater(num: Int) extends ClockOp
  case class ClockGreaterEqual(num: Int) extends ClockOp
  case class ClockLess(num: Int) extends ClockOp
  case class ClockLessEqual(num: Int) extends ClockOp
  case class ClockEqual(num: Int) extends ClockOp

  case class ClockAddition(num: Int) extends ClockOp
  case class ClockSubtraction(num: Int) extends ClockOp
  case class ClockMultiplication(num: Int) extends ClockOp
  case class ClockDivision(num: Int) extends ClockOp

  case class ClockNegation() extends ClockOp
}