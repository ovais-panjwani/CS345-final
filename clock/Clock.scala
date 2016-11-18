package clock

// for the random number generator
import scala.util.Random

// The class that holds all of the keywords for Clock and does the parsing
class Clock{
	// a random number generator for when the user requests a random number
	val rnd = new Random()

	// the keyword START that marks the beginning of compilation
	object START{

		// the keyword AT sets the Time and therefore the order of execution for the instruction
		def AT(t: Time) = {
			// 
		}

		// print something
		def PRINT(a: Any) = {
			println(a)
		}
	}
}