Feature: Compare the number students and the size of the classroom
	
	Scenario Outline: Check the maximum of students can fit in one classroom
		Given the classroom number is <roomNumber>
		Then the Maximum of students for this classroom should be <Max>

	Example
	|roomNumber|Max|
	|301|82|
	|302|18|
	|314|24|
	|315|40|
	|316|35|
	|317|20|
	|318|42|