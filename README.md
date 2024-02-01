# APCS_Szabo_SeniorSeminar

A program that arranges an optimized schedule for a set of students (actualSrSeminarData.csv) for a special set of seminars.

Approach: Those who filled out the survey first will be prioritized. The 5x5 array of Seminar objects will slowly be populated with Seminar objects as the students' data and choices are processed. For those who cannot be placed into a certain class, an attempt to create another section of a certain seminar will be made. If this is unsuccessful, they will be placed wherever there is space. Those who did not fill out the survey will automatically be placed wherever there is space. 

January 18: Experimented with a "first-choice first" solution to optimization. created toString method and constructor for Student class. Imported student data into an arrayList. Goal for next class: write the algorithm to import Students into the seminar schedule grid.

January 22: Went forward with the first loop of the "first-choice first" soluion. Created various methods for Student and Seminar classes to aid the process of placing the students in the seminar as students are proecssed with the algorithm. Thought about a system to prioritize holding high-popularity classes at different times (might start over with this method.)

January 24: Ditched the first-choice first solution and used the "Collections" class to randomly shuffle the arraylist of students and run an optimization algorithm to find an "optimization score," saving the lowest one i find.

January 26: wrote the "fill" function to fill in the students who could not get their choices or did not fill out the form. 

January 30: debugged students who had duplicate sessions and didn't fill out the form.

February 1: Added Javadocs, Multiline comments, and a screenshot of the search function running.

---

Date: 2/5/2024

Final Summary: A program that arranges a schedule for a "Senior Seminar" enrichment day at the Cincinnati Country Day school given the results of a survey, where the students were told to pick their top 5 choices from a list of seminars. Under this schedule, students on average were denied either their fourth or fifth choice (equal probability), and received all of their other choices.