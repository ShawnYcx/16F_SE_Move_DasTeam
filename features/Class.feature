# Shawn Yap, Ivan Anyengbu, Steven Qin
# Date: 10/25/16
# CS374 Software Engineering
# Project 2 - Moving Classes

Feature: Moving Classes to the top 5 next available spot
	Scenario Outline: Check the max number of students allowed in a class room on the third floor
		Given the room number is <rn>
		Then the maximum number of student allowed in that classroom is <max>

	Examples:
	|	rn|	max|
	|"301"|	 82|
	|"302"|	 18|
	|"314"|	 24|
	|"315"|	 40|
	|"316"|	 35|
	|"317"|	 20|
	|"318"|	 42|