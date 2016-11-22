package clock

object ClockOps {
  abstract sealed class ClockOpEnum

  case object C_NONE extends ClockOpEnum

  case object C_NUMBER extends ClockOpEnum

  case object C_STRING extends ClockOpEnum

  case object C_BOOL extends ClockOpEnum

  case object C_COND_BEGIN extends ClockOpEnum
  case object C_COND_END extends ClockOpEnum

  case object C_GREATER extends ClockOpEnum
  case object C_GREATER_EQUAL extends ClockOpEnum
  case object C_LESS extends ClockOpEnum
  case object C_LESS_EQUAL extends ClockOpEnum
  case object C_EQUAL extends ClockOpEnum

  case object C_GREATER_N extends ClockOpEnum
  case object C_GREATER_EQUAL_N extends ClockOpEnum
  case object C_LESS_N extends ClockOpEnum
  case object C_LESS_EQUAL_N extends ClockOpEnum
  case object C_EQUAL_N extends ClockOpEnum

  case object C_LOOP_BEGIN extends ClockOpEnum
  case object C_LOOP_END extends ClockOpEnum

  case object C_ADDITION extends ClockOpEnum
  case object C_SUBTRACTION extends ClockOpEnum
  case object C_MULTIPLICATION extends ClockOpEnum
  case object C_DIVISION extends ClockOpEnum

  case object C_NEGATION extends ClockOpEnum

  case object C_OUTPUT extends ClockOpEnum
}