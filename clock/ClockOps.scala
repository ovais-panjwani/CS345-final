package clock

object ClockOps {
  abstract sealed class ClockOpEnum

  case object NONE extends ClockOpEnum

  case object ADDITION extends ClockOpEnum
  case object SUBTRACTION extends ClockOpEnum
  case object MULTIPLICATION extends ClockOpEnum
  case object DIVISION extends ClockOpEnum
  case object MODULUS extends ClockOpEnum
  case object RAISE extends ClockOpEnum

  case object ADDITION_D extends ClockOpEnum
  case object SUBTRACTION_D extends ClockOpEnum
  case object MULTIPLICATION_D extends ClockOpEnum
  case object DIVISION_D extends ClockOpEnum
  case object MODULUS_D extends ClockOpEnum
  case object RAISE_D extends ClockOpEnum

  case object GREATER extends ClockOpEnum
  case object GREATER_EQUAL extends ClockOpEnum
  case object LESS extends ClockOpEnum
  case object LESS_EQUAL extends ClockOpEnum
  case object EQUAL extends ClockOpEnum

  case object GREATER_D extends ClockOpEnum
  case object GREATER_EQUAL_D extends ClockOpEnum
  case object LESS_D extends ClockOpEnum
  case object LESS_EQUAL_D extends ClockOpEnum
  case object EQUAL_D extends ClockOpEnum

  case object NEGATION extends ClockOpEnum

  case object AND extends ClockOpEnum
  case object OR extends ClockOpEnum
  case object NOT extends ClockOpEnum
  case object NOT_CURRENT extends ClockOpEnum

  case object APP_STRING extends ClockOpEnum
  case object PREP_STRING extends ClockOpEnum
  case object REPLACE_STRING extends ClockOpEnum
  case object REM_STR_END extends ClockOpEnum
  case object REM_STR_BEG extends ClockOpEnum

  case object OUTPUT_INT extends ClockOpEnum
  case object OUTPUT_DOUBLE extends ClockOpEnum
  case object OUTPUT_BOOL extends ClockOpEnum  
  case object OUTPUT_STRING extends ClockOpEnum
}