package clock

object ClockOps {
  abstract sealed class ClockOpEnum

  case object NONE extends ClockOpEnum

  case object ADDITION extends ClockOpEnum
  case object SUBTRACTION extends ClockOpEnum
  case object MULTIPLICATION extends ClockOpEnum
  case object DIVISION extends ClockOpEnum
  case object RAISE extends ClockOpEnum

  case object GREATER extends ClockOpEnum
  case object GREATER_EQUAL extends ClockOpEnum
  case object LESS extends ClockOpEnum
  case object LESS_EQUAL extends ClockOpEnum
  case object EQUAL extends ClockOpEnum

  case object OUTPUT extends ClockOpEnum

  case object NEGATION extends ClockOpEnum
}