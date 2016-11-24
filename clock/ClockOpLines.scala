package clock

object ClockOpLines {
  abstract sealed class ClockOp

  case object ClockNone extends ClockOp

  case class ClockNum(num: Int) extends ClockOp

  case class ClockGreater() extends ClockOp
  case class ClockGreaterEqual() extends ClockOp
  case class ClockLess() extends ClockOp
  case class ClockLessEqual() extends ClockOp
  case class ClockEqual() extends ClockOp

  case class ClockAddition() extends ClockOp
  case class ClockSubtraction() extends ClockOp
  case class ClockMultiplication() extends ClockOp
  case class ClockDivision() extends ClockOp

  case class ClockNegation() extends ClockOp
}