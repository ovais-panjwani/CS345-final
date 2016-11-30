# Clock: A DSL for scala that uses Times to schedule commands using a 24 clock

## Purpose

Clock allows users to schedule tasks using Times and executes them in order starting
from 12:00 am and ending at 11:59 pm, so it accommodates 1440 command lines in total.
It probably won't serve any practical purpose, but it is kind of fun to be able to write 
commands out of order and have them execute in the desired sequence.

## Language Specification

Clock allows you to perform mathematical operations using ints and doubles, boolean operations, and
string manipulation. It acts on global variables that start at default values of 0 for the number, 
false for the boolean, and an empty string, and is acted upon by the operations specified by the 
user. The user can then output the current number as an int or double, the current boolean, or the 
current string. Times must be of the form ("hour:minute period"), e.g. ("12:00 am"), ("1:00 pm"), etc.
The language includes loops and conditionals, but has no concept of variables. The loops are based on
lengths of time, and the conditionals on comparisons with the current number. All command lines must
begin with the keyword AT, so an example line would look like AT ("12:00 am") <do something>.

## Language Features

One of the main features of the language is that Time slots can be overwritten, which is the only 
instance in which the order of the commands makes a difference. This allows for another feature of
the language, loop interference. If a loop is going from 2:00 am to 2:05 am and another command is 
set for 2:03 am, that command will be executed, but the loop will still continue until, or through 
2:05, depending on the type of loop. Programs run on a 24 hour clock, but they can be run for multiple
"days", which will run the entire program as many times as the user indicates. The user also has the 
option to CLEAR the timeTable and write a completely new program to the same file and run it as well,
for as many days as desired.

### Mathematical Operations (all of which take ints or doubles as arguments, and update the current 
	number)

Basic Operations: `ADD`, `SUBTRACT`, `MULTIPLY_BY`, `DIVIDE_BY`, `MODULUS`, `RAISE_TO_POWER`, `NEGATE`

Operations Using Random Values: `ADD_RANDOM`, `SUBTRACT_RANDOM`, `MULTIPLY_BY_RANDOM`,
								`DIVIDE_BY_RANDOM, `MODULUS_RANDOM`
								
Operations using random values can specify a range for the random number to be used:

"ADD_RANDOM BETWEEN <x> AND <y>"

### Comparators (compare values, ints or doubles, to the current number and update the current boolean)

`GREATER_THAN`, `LESS_THAN`, `GREATER_THAN_EQUAL`, `LESS_THAN_EQUAL`, `EQUAL`, `NOT_EQUAL`

### Boolean Operations (simply update the current boolean)

`AND`, `OR` 
`NOT` - sets the current boolean to NOT the boolean being passed in 
`NOT_CURRENT` - NOTs the current boolean

### String Operations (manipulate current string)

`APPEND_STRING` - adds a string to the end of the current string
`PREPEND_STRING` - adds a string to the beginning of the current string
`REPLACE_STRING` - replaces the current string with the given string
`REMOVE_STRING_END` - removes the given number of characters from the end of the current string
`REMOVE_STRING_BEGINNING` - removes n characters from the beginning of the current string

### Outputs

`OUTPUT_INT`, `OUTPUT_DOUBLE`, `OUTPUT_BOOLEAN`, `OUTPUT_STRING`

### Loops

For loops have the following syntax:

"... FOR <x> MINUTES" or "... FOR <x> HOURS"

For loops perform the given operation the indicated number of minutes, which is 60 times for each hour

While loops have the following syntax:

"... UNTIL <Time>" or "... THROUGH <Time>"

The UNTIL loop excludes the indicated time, and the THROUGH loop includes the given time

### Conditionals (compare the current number to the given number)

Conditionals follow the given command and determine whether the command is executed. They can also
be followed by `ELSE`, which is followed by another command that is to be executed in the case that 
the condition is false. Conditionals can be used in concert with loops. Whichever command is
executed as a result of the conditional will be executed the number of times indicated by the loop.

`IF_NUMBER_GREATER_THAN`, `IF_NUMBER_LESS_THAN`, `IF_NUMBER_GREATER_THAN_EQUAL`,
`IF_NUMBER_LESS_THAN_EQUAL`, `IF_NUMBER_EQUAL`, `IF_NUMBER_NOT_EQUAL`,
`IF_BOOLEAN` - simply uses the current boolean to determine whether to perform the command

### Other

`RUN` - begins execution of the program
"RUN FOR <x> DAYS" - executes the entire program for x number of days
`CLEAR` - clears the timeTable and resets the default current values

## Other Notes

**Note that all lines should end with a semi-colon or bad things might happen**. The purpose of the 
semi-colon is to stop the runtime from trying to parse the next thing as an argument of the thing 
that is possibly returned at the end of each line. There are some cases where you do not need to put
a semi-colon, but I recommend you put one anyway. There are some objects that don't take arguments,
and must be followed by empty parentheses if they are used with loops or conditionals, like the 
outputs and ELSE.

## Possible Extensions

It should be possible to implement variables, and potentially function calls. In order to accommodate
more command lines, the Time class can be altered to go by seconds, rather than minutes. Also, it 
wouldn't hurt to rearrange the objects and classes in such a way that the need for parentheses 
after commands that don't take arguments.