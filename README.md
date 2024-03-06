# Senior Seminar

**Quick Summary**: Finds and imports an optimal schedule of classes for a school given the results of a course registration survey of 80 students. *The provided test case can be found at plaindata.csv.*

**Summary**: A school has given me data from a survey that asks students, "What 'Seminar Sessions' would you like to attend on a special Senior Seminar day?" There are five rooms available for this event and five one-hour periods available for lecturers to present their seminar. Each class has a capacity for up to 16 students. There can be no more than two class sessions per seminar, and a lecturer cannot have two class sessions at the same time.

**Task**: Create a schedule as "optimized" as possible.

**Approach**: I defined my own framework for optimization: the total "optimization score" receives five points if a student does not get their first choice, four if they do not get their second choice, etc. After doing so, I wrote a system to import students, based on their position in a "queue," into the schedule with their preferred classes. I used the Collections class to shuffle the queue repeatedly, processing over 3000 different randomized orders per second in order to find the best order. *Please see Optimization.md for the original code.*

**Result**: After 12 hours of testing, by using the Collections library to shuffle the "queue", I received a final optimization score of 103; Each student, on average, was denied either their fourth or their fifth choice seminar, but received all the others they registered for.