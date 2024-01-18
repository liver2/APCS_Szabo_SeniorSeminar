# APCS_Szabo_SeniorSeminar

A program that arranges an optimized schedule for a set of students (actualSrSeminarData.csv) for a special set of seminars.

Approach: Those who filled out the survey first will be prioritized. The 5x5 array of Seminar objects will slowly be populated with Seminar objects as the students' data and choices are processed. For those who cannot be placed into a certain class, an attempt to create another section of a certain seminar will be made. If this is unsuccessful, they will be placed wherever there is space. Those who did not fill out the survey will automatically be placed wherever there is space. 

January 18: Experimented with a "first-choice first" solution to optimization. created toString method and constructor for Student class. Imported student data into an arrayList. Goal for next class: write the algorithm to import Students into the seminar schedule grid.