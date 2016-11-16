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
	|"ACCT"|"211"|"Payne"|"Gretchen"|"Junior"|"T"|

	Scenario Outline: Get all the classes that the students is taking. 
		Given the student name is <last_name>, <First_name>, <Term_code>
		Then the student is taking class <Subject_Code>,<Course_Number>,<Instructor><result>
	Examples: 
	|last_name|First_name|Term_code|Subject_Code|Course_Number|Instructor|result|
	|"Payne"|"Gretchen"|"201710"|"ACCT"|"211"|"368944"|"T"|
	|"Payne"|"Gretchen"|"201710"|"ENGL"|"326"|"1128"|"T"|
	|"Payne"|"Gretchen"|"201710"|"ACCT"|"310"|"1615"|"T"|
	|"Payne"|"Gretchen"|"201710"|"BLAW"|"363"|"25033"|"T"|
	|"Payne"|"Gretchen"|"201710"|"FIN"|"310"|"1780"|"T"|

	|"Aguiar"|"Gregory"|"201710"|"ACCT"|"211"|"368944"|"T"|
	|"Aguiar"|"Gregory"|"201710"|"POLS"|"382"|"730"|"T"|
	|"Aguiar"|"Gregory"|"201710"|"FREN"|"221"|"2049"|"T"|
	|"Aguiar"|"Gregory"|"201710"|"IS"|"322"|"1180"|"T"|
	|"Aguiar"|"Gregory"|"201710"|"POLS"|"395"|"730"|"T"|

	|"Summerlin"|"David"|"201710"|"ACCT"|"211"|"368944"|"T"|
	|"Summerlin"|"David"|"201710"|"AENV"|"384"|"180"|"T"|
	|"Summerlin"|"David"|"201710"|"ANSC"|"235"|"282529"|"T"|
	|"Summerlin"|"David"|"201710"|"ANSC"|"496"|"180"|"T"|
	|"Summerlin"|"David"|"201710"|"COMM"|"211"|"2003"|"T"|
	|"Summerlin"|"David"|"201710"|"BCOR"|"310"|"1418"|"T"|

	|"Bosworth"|"Paul"|"201710"|"ACCT"|"211"|"368944"|"T"|	
	|"Bosworth"|"Paul"|"201710"|"IS"|"322"|"1180"|"T"|	
	|"Bosworth"|"Paul"|"201710"|"BIBL"|"453"|"504"|"T"|	
	|"Bosworth"|"Paul"|"201710"|"PEAC"|"100"|"1727"|"T"|	
	|"Bosworth"|"Paul"|"201710"|"PSYC"|"370"|"1478"|"T"|	
	|"Bosworth"|"Paul"|"201710"|"FIN"|"310"|"1780"|"T"|	

	|"Gray"|"Heather"|"201710"|"ACCT"|"211"|"368944"|"T"|	
	|"Gray"|"Heather"|"201710"|"IT"|"220"|"9979"|"T"|	
	|"Gray"|"Heather"|"201710"|"COMM"|"211"|"448258"|"T"|	
	|"Gray"|"Heather"|"201710"|"BCOR"|"310"|"1418"|"T"|	
	|"Gray"|"Heather"|"201710"|"IT"|"440"|"419266"|"T"|	


	|"Moreno"|"Christa"|"201710"|"ACCT"|"211"|"368944"|"T"|
	|"Moreno"|"Christa"|"201710"|"MKTG"|"320"|"22988"|"T"|	
	|"Moreno"|"Christa"|"201710"|"MGMT"|"331"|"313"|"T"|
	|"Moreno"|"Christa"|"201710"|"FIN"|"310"|"1780"|"T"|
	|"Moreno"|"Christa"|"201710"|"IS"|"324"|"520705"|"T"|

	|"Harris"|"Christopher"|"201710"|"ACCT"|"211"|"368944"|"T"|
	|"Harris"|"Christopher"|"201710"|"MPEV"|"211"|"1584"|"T"|
	|"Harris"|"Christopher"|"201710"|"MKTG"|"320"|"22988"|"T"|
	|"Harris"|"Christopher"|"201710"|"MGMT"|"305"|"2051"|"T"|
	|"Harris"|"Christopher"|"201710"|"IS"|"322"|"1180"|"T"|

	|"Showman"|"Janet"|"201710"|"ACCT"|"211"|"368944"|"T"|		
	|"Showman"|"Janet"|"201710"|"ECON"|"261"|"1510"|"T"|	
	|"Showman"|"Janet"|"201710"|"PEAC"|"215"|"782"|"T"|	
	|"Showman"|"Janet"|"201710"|"IS"|"322"|"1180"|"T"|	
	|"Showman"|"Janet"|"201710"|"MPEI"|"314"|"19128"|"T"|	
	|"Showman"|"Janet"|"201710"|"ENGL"|"263"|"18218"|"T"|	
