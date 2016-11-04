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

	Scenario Outline: Gettting the students information from a specific course
		Given the course is <subject_code>, <course_num>
		Then one of the student is <last_name>, <First_name>, <classification>,<Result>
	Examples: 
	|subject_code|course_num|last_name|First_name|classification|Result|
	|"ACCT"|"324"|"Duffy"|"Bernard"|"Senior"|"T"|
	|"ACCT"|"324"|"Arnhart"|"Carmen"|"Senior"|"T"|
	|"ACCT"|"324"|"Livingston"|"Nellie"|"Senior"|"T"|
	|"ACCT"|"324"|"Holmes"|"Allen"|"Junior"|"T"|
	|"ACCT"|"324"|"Davis"|"Martha"|"Senior"|"T"|
	|"ACCT"|"324"|"Harrison"|"Kip"|"Junior"|"T"|
	|"ACCT"|"324"|"Dodson"|"Daniel"|"Senior"|"T"|
	|"ACCT"|"324"|"Davidson"|"Charlotte"|"Junior"|"T"|
	|"ACCT"|"324"|"Dunn"|"Keith"|"Junior"|"T"|
	|"ACCT"|"324"|"Breeden"|"Gladys"|"Junior"|"T"|
	|"ACCT"|"324"|"Reno"|"Gilbert"|"Junior"|"T"|
	|"ACCT"|"324"|"Goulette"|"Hazel"|"Senior"|"T"|
	|"ACCT"|"324"|"Wideman"|"David"|"Junior"|"T"|
	|"ACCT"|"324"|"Brandenberger"|"Amy"|"Junior"|"T"|
	|"ACCT"|"324"|"Harris"|"Glenda"|"Senior"|"T"|
	|"ACCT"|"324"|"Murphy"|"Irma"|"Senior"|"T"|
	|"ACCT"|"324"|"Murphy"|"Irma"|"Senior"|"T"|
	|"ACCT"|"324"|"Ward"|"Candice"|"Junior"|"T"|
	|"ACCT"|"324"|"Chapman"|"Beverly"|"Junior"|"T"|
	|"ACCT"|"324"|"Bostick"|"Ruth"|"Junior"|"T"|
	|"ACCT"|"324"|"Raybon"|"Brandon"|"Senior"|"T"|
	|"ACCT"|"324"|"Mccool"|"Michelle"|"Junior"|"T"|
	|"ACCT"|"324"|"Nellis"|"Carl"|"Graduate"|"T"|
	|"ACCT"|"324"|"Allen"|"John"|"Senior"|"T"|
	|"ACCT"|"324"|"Combee"|"Shirley"|"Senior"|"T"|
	|"ACCT"|"324"|"Johnson"|"James"|"Junior"|"T"|