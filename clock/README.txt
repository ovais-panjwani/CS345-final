# Clock: A DSL for scala that uses Times to schedule commands using a 24 clock

## Purpose

Clock allows users to schedule tasks using Times and executes them in order starting
from 12:00 am and ending at 11:59 pm, so it accommodates 1440 command lines in total.
It probably won't serve any practical purpose, but it is kind of fun to be able to write 
commands out of order and have them execute in the desired sequence.

## Language Specification

Clock allows you to perform mathematical operations using ints and doubles. It acts on a 
global variable that starts at 0 and is acted upon by the operations specified by the
user. The user can then output the result as an int or double as they desire. Times must
be of the form ("hour:minute period"), e.g. ("12:00 am").