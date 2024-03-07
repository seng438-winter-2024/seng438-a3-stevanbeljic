**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group  8  |
| :--------------:|
| **Student Names**      |
|       Stevan Beljic            |
|        Aaron Giang             |
|        Angelo Troncone             |
|        Rutvi Brahmbhatt             |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

The goal of this lab is to use JUnit, JMock, and EclEmma to calculate initial coverage using our tests cases developed in the second assignment, and improve them to increase various coverage criteria regarding the SUT, JFreeChart. We are to use the white-box testing techniques learned in class, regarding control flow and data flow, and use them to examine existing code and to develop test cases to further improve the coverage of our test code.

# 2 Manual data-flow coverage calculations for calculateColumnTotal() and <insert second method name here>

**calculateColumnTotal()**<br><br>
<img width="329" alt="image" src="https://github.com/seng438-winter-2024/seng438-a3-stevanbeljic/assets/60798649/7a2334df-13a2-4dde-99fd-9d1aa0bf26e6">

|DU-path sets | |
| :-----: | :----: |
| du(1, data) | {[1]<br>[1, 2, 3]<br>[1, 2, 3, 4, 5]<br>[1, 2, 3, 4, 9, 10]} |
| du(1, column) | {[1]<br>[1, 2, 3, 4, 5]<br>[1, 2, 3, 4, 9, 10]} |
| du(2, total) | {[2, 3, 4, 5, 6, 7]<br>[2, 3, 9, 10, 12]} |
| du(3, rowCount) | {[3, 4, 9]<br>[3, 4, 5, 6, 8, 4, 9]<br>[3, 4, 5, 6, 7, 8, 4, 9]<br>[2, 3, 4, 9, 10, 11, 13, 9]<br>[3, 4, 9, 10, 11, 12, 13, 9]} |
| du(4, r) | {[4]<br>[4, 5, 6, 8]<br>[4, 5, 6, 7, 8]} |
| du(5, n) | {[5, 6]<br>[5, 6, 7]} |
| du(9, r2) | {[9]<br>[9, 10, 11, 13]<br>[9, 10, 11, 12, 13]} |
| du(10, n) | {[10, 11]<br>[10, 11, 12]} |

|DU-pair sets | |
| :-----: | :----: |
| du(1, 1, data) | {[1]} |
| du(1, 3, data) | {[1, 2, 3]} |
| du(1, 5, data) | {[1, 2, 3, 4, 5]} |
| du(1, 10, data) | {1, 2, 3, 4, 9, 10} |
| du(1, 1, column) | {[1]} |
| du(1, 5, column) | {[1, 2, 3, 4, 5]} |
| du(1, 10, column) | {[1, 2, 3, 4, 9, 10]} |
| du(2, 7, total) | {[2, 3, 4, 5, 6, 7]} |
| du(2, 12, total) | {[2, 3, 4, 9, 10, 11, 12]} |
| du(3, 4, rowCount) | {[3, 4]} |
| du(3, 9, rowCount) | {[3, 4, 9]} |
| du(4, 4, r) | {[4]} |
| du(4, 5, r) | {[4, 5]} |
| du(4, 8, r) | {[4, 5, 6, 8]<br>[4, 5, 6, 7, 8]} |
| du(5, 6, n) | {[5, 6]} |
| du(5, 7, n) | {[5, 6, 7]} |
| du(9, 9, r2) | {[9]} |
| du(9, 10, r2) | {[9, 10]} |
| du(9, 13, r2) | {[9, 10, 11, 13]<br>[9, 10, 11, 12, 13]} |
| du(10, 11, n) | {[10, 11]} |
| du(10, 12, n) | {[10, 11, 12]} |

| Variable | Defined at node |   dcu  |    dpu   |
| :------: | :-------------: |:------:|:--------:|
|  data    |        1        |{3,5,10}|{[1, end]}|
|  column  |        1        |{5,10}  |          |
|  total   |        2        |{7,12}  |          |
|  rowCount|        3        |        |{[4, 5], [4, 9], [9, 10], [9, end]}|
|  r       |        4        |{4,8}   |{[4, 5], [4, 9]}|
|  n       |        5        |{7}     |{[6, 7], [6, 8]}|
|  r2      |        9        |{10, 13}|{[9, 10], [9, end]}|
|  n       |        10       |{12}    |{[9, 10], [9, end]}|

**Pair covered per test case**
|Test Case| Pairs covered |
|:-------:|:-------------:|
|testCalculateColumnTotalDataNull| dcu:{} dpu:{}|
|testCalculateColumnTotalDataNotNull| dcu:{} dpu:{}|
|testCalculateColumnTotalSumNegative| dcu:{} dpu:{}|
|testCalculateColumnTotalSumZero| dcu:{} dpu:{}|
|testCalculateColumnTotalSumPositive| dcu:{} dpu:{}|
|testCalculateColumnTotalEmpty| dcu:{} dpu:{}|
|testCalculateColumnTotalNotEmpty| dcu:{} dpu:{}|
|testCalculateColumnTotalInvalidIndex| dcu:{} dpu:{}|
|testCalculateColumnTotalValidIndex| dcu:{} dpu:{}|
# 3 A detailed description of the testing strategy for the new unit test

Our strategy for developing new tests is to first gleen what information relating to coverage we can from the initial test cases imported from assignment 2. From these test cases, we look to see where we can add onto existing unit tests, or create new unit tests, to improve our coverage criteria. We will be performing white-box testing on the SUT, since we have access to the source code and we will develop test cases based upon the expected results of the code, and since our primary metric for measuring test effectiveness will be coverage of various criteria.

The coverage criteria we chose to focus on within the scope of this assignment are: statement, branch and method. We chose these since the coverage criteria are readily available in EclEmma and do not need to be calculated manually.

The initial coverages are:<br><br>
DataUtilities.java - 46.9% statement, 29.7% branch, 60% method<br>
Range.java - 25.2% statement, 19.5% branch, 43.5% method<br>

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

**DataUtilities.java**
testClonePositiveArray() - 55.2% (8.3% increase) statement, 34.4% (4.7% increase) branch, 70% (10% increase) method
testCalculateColumnTotalValidRows() - 66.7% (11.5% increase) statement, 42.2 (7.8% increase) branch, 80% (10% increase) method

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text…

# 6 Pros and Cons of coverage tools used and Metrics you report

Text…

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Text…
