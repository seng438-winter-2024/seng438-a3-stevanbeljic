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
|testCalculateColumnTotalDataNull| {du(1, end, data)}|
|testCalculateColumnTotalDataNotNull| {du(1, 3, data), du(1, 5, data), du(1, 5, column), du(2, 7, total), du(3, 4, rowCount), du(3, 9, rowCount), du(4, 5, r), du(4, 8, r), du(5, 6, n), du(5, 7, n), du(9, end, r2)} |
|testCalculateColumnTotalSumNegative| {du(1, 3, data), du(1, 5, data), du(1, 5, column), du(2, 7, total), du(3, 4, rowCount), du(3, 9, rowCount), du(4, 5, r), du(4, 8, r), du(5, 6, n), du(5, 7, n), du(9, end, r2)} |
|testCalculateColumnTotalSumZero| {du(1, 3, data), du(1, 5, data), du(1, 5, column), du(2, 7, total), du(3, 4, rowCount), du(3, 9, rowCount), du(4, 5, r), du(4, 8, r), du(5, 6, n), du(5, 7, n), du(9, end, r2)}  |
|testCalculateColumnTotalSumPositive| {du(1, 3, data), du(1, 5, data), du(1, 5, column), du(2, 7, total), du(3, 4, rowCount), du(3, 9, rowCount), du(4, 5, r), du(4, 8, r), du(5, 6, n), du(5, 7, n), du(9, end, r2)} |
|testCalculateColumnTotalEmpty| {du(1, 3, data), du(1, 5, data), du(1, 5, column), du(3, 4, rowCount), du(3, 9, rowCount), du(4, 5, r), du(4, 8, r), du(5, 6, n), du(9, end, r2)}  |
|testCalculateColumnTotalNotEmpty| {du(1, 3, data), du(1, 5, data), du(1, 5, column), du(2, 7, total), du(3, 4, rowCount), du(3, 9, rowCount), du(4, 5, r), du(4, 8, r), du(5, 6, n), du(5, 7, n), du(9, end, r2)} |
|testCalculateColumnTotalInvalidIndex| {du(1, 3, data), du(1, 5, data), du(1, 5, column), du(3, 4, rowCount), du(3, 9, rowCount), du(4, 5, r), du(4, 8, r), du(5, 6, n), du(9, end, r2)}  |
|testCalculateColumnTotalValidIndex| {du(1, 3, data), du(1, 5, data), du(1, 5, column), du(2, 7, total), du(3, 4, rowCount), du(3, 9, rowCount), du(4, 5, r), du(4, 8, r), du(5, 6, n), du(5, 7, n), du(9, end, r2)} |

**Coverage**<br>
DU-Pair Coverage = 14/21 * 100 = 66.67%, largely because the second for loop is not executed at all apart from the initial loop condition.
# 3 A detailed description of the testing strategy for the new unit test

Our strategy for developing new tests is to first gleen what information relating to coverage we can from the initial test cases imported from assignment 2. From these test cases, we look to see where we can add onto existing unit tests, or create new unit tests, to improve our coverage criteria. We will be performing white-box testing on the SUT, since we have access to the source code and we will develop test cases based upon the expected results of the code, and since our primary metric for measuring test effectiveness will be coverage of various criteria.

The coverage criteria we chose to focus on within the scope of this assignment are: statement, branch and method. We chose these since the coverage criteria are readily available in EclEmma and do not need to be calculated manually.

The initial coverages are:<br><br>
DataUtilities - 46.9% statement, 29.7% branch, 60% method<br>
Range - 25.2% statement, 19.5% branch, 43.5% method<br>

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

**DataUtilities.java**
<br>
<br>
`testClonePositiveArray()`<br>
Adding the testClonePositiveArray unit test increased line coverage by 8.3%, branch coverage by 4.7%, and method coverage by 10%. This is because in our initial test cases from assignment 2, we did not have any test cases that tested the clone() method in DataUtilities. We made this test first since it was evident that testing a method not previously tested should contribute the greatest jump in coverage metrics. 
<br>
<br>
`testCalculateColumnTotalValidRows()`<br>
Similarily, the previous version of JFreeChart did not have a calculateColumnTotal() which took 3 parameters, unlike this version. Since we did not have a unit test that tested this 3-parameter version calculateColumnTotal(), we accurately predicted that adding tests for this would generate the biggest jump in coverage. As our data shows, it did as statement coverage jumped by 11.5%, branch by 7.8%, and method by 10%.
<br><br>
**Range.java**
<br>
<br>
`testCase1`<br>
Description
<br>
<br>
`testCase2`<br>
Description
<br>
<br>
`testCase3`<br>
Description
# 5 A detailed report of the coverage achieved of each class and method

### DataUtilities
Final Coverage:
- Statement: 89.6% (as compared to initial 46.9%) (Note: It was not possible to achieve >90% coverage since there were several instances of unreachable code or code running in infinite loops that was not testable. Further down in this section are screenshots demonstrating the issues with the SUT.)<br>
  <img width="685" alt="image" src="https://github.com/seng438-winter-2024/seng438-a3-stevanbeljic/assets/60798649/a7b992d8-a30a-48f1-9d71-ca57a0f31b18">

- Branch: 73.4% (as compared to initial 29.7%)<br>
  <img width="690" alt="image" src="https://github.com/seng438-winter-2024/seng438-a3-stevanbeljic/assets/60798649/44707755-e25f-4022-97a7-fb50ec462989">

- Method: 100% (as compared to initial 60%)<br>
  <img width="694" alt="image" src="https://github.com/seng438-winter-2024/seng438-a3-stevanbeljic/assets/60798649/055f8c56-5380-466d-95ba-e8e573fd1c10">

- Unreachable & Untestable code:<br>
  1.<br> <img width="293" alt="image" src="https://github.com/seng438-winter-2024/seng438-a3-stevanbeljic/assets/60798649/911a373c-59e5-4322-9323-0ccb5a8a0373"><br>
  2.<br> <img width="135" alt="image" src="https://github.com/seng438-winter-2024/seng438-a3-stevanbeljic/assets/60798649/83d920f2-06c2-4b10-8bae-6fbb69dda06c"><br>
  3.<br> <img width="297" alt="image" src="https://github.com/seng438-winter-2024/seng438-a3-stevanbeljic/assets/60798649/aefb0b1e-8a73-4a72-a2a5-da7cdcf51db7"><br>
  4.<br> <img width="357" alt="image" src="https://github.com/seng438-winter-2024/seng438-a3-stevanbeljic/assets/60798649/18007526-6082-496b-b09e-98073a250a25"><br>

  In instances 1, 3, and 4, the code ran an infinite loop since the conditions checked if the r2, c2, and i2 we larger than some count, and then kept incrementing them. In instance 2, the code was unreachable since total was initialized as 0, then immediately checked to see if it was larger than 0. Therefore, 89.6% is the highest possible statement coverage without modifying the SUT itself.


### Range
Final Coverage:
- Statement: 90.8% (as compared to initial 25.2%)

- Branch: 86.6% (as compared to initial 19.5%)

- Method: 100.0% (as compared to initial 43.5%)

# 6 Pros and Cons of coverage tools used and Metrics you report

The coverage tool we used, apart from our own knowledge on the DU sets, was EclEmma. Some positive aspects of EclEmma were that it was easy to use and understand with its simplistic GUI and reporting metrics. The reporting metrics covered by EclEmma were largely similar to the ones covered in class. Furthermore, EclEmma simplistically highlights covered branches, partly covered branches, and uncovered branches, making it easy to locate where more tests were needed.
<br><br>
Some downsides of EclEmma were that it doesn't take into consideration unreachable code, meaning even if all executable code was covered, statement coverage could never be 100% since it still factors in unreachable statements into its total statement count. Another downside of EclEmma was that it does not have the ability to report on condition coverage, a significant coverage criteria covered in class. As suggested, we instead pivoted to tracking method coverage, although condition coverage would have been much more useful as method coverage is a fairly simple metric that does not provide as much insight into testing depth as condition coverage does.

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Requirements based test generation (black-box testing) and coverage-based test generation (white-box testing) vary significantly. While black-box focuses on producing tests based on user requirements and expected behaviour, white-box tests are more inspired by the underlying code and system itself.

Benefits of Requirements-based testing:
- Easier to develop tests as knowledge of underlying functionality of system is not needed
- Tests expected behaviour of subsystems
- Clearer test objectives

Drawbacks of Requirements-based testing:
- Limited knowledge of the underlying functionality of the system impacts its accuracy
- Confined to the listed requirements

Benefits of Coverage-based testing:
- Measureable criteria to show where enough work was done, and where more is needed
- Tests are tailored to the SUT

Drawbacks of Coverage-based testing:
- Significant time required to familiarize with SUT
- High coverage does not correlate to high functionality

# 8 A discussion on how the team work/effort was divided and managed

Familiarization with the SUT was not fully necessary as it is the same system used as the previous assignment, however there were some changes and each group member was tasked with individually identifying changes across JFreeChart versions. Group work was divided similarily to the last assignment, wherein Stevan and Rutvi were tasked with handling the DataUtilities class and all of its corresponding requirements (DFGs, DU sets, coverage, test development and reporting), while Angelo and Aaron were tasked with handling the Range class and its corresponding requirements. Upon achievement of the desired coverage metrics, we came together as a group and reviewed the generated DFGs and unit tests. The overall report was written collaboratively.

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

One issue we had was taking into account all the dead code in the DataUtilities class. The class has 3 instances of infinite loops and 1 instance of unreachable code, and we had difficulty determining how to proceed and handle this issue, as our statement coverage was up to 89.6% and to get 90% we needed to somehow test this untestable code. 
We also had some difficulty still learning and getting familiar with JMock. Even though we had some experience on the previous assignment, more was necessary to get used to the tool. While we are still not fully confident in our abilities to maximize its utility, we feel much more confident in using it to develop test doubles to execute unit tests.

Lessons learned from this lab include just learning how to better analyze data flow graphs and create the corresponding DU-pair and path sets, and also how to develop tests to tackle these tests. They were a significant challenge at first, however using the course notes we managed to figure out how to create these sets and also how to create the graphs themselves.

# 10 Comments/feedback on the lab itself

**Stevan**: I thought this lab was very good at teaching us how to apply whitebox testing in combination with previous black-box testing methods, to bolster coverage. It was also very useful in teaching us how to use coverage tools such as EclEmma (although we do have some prior experience using it). Doing the DFGs was a little tiring and there was a lot of work in developing those, specifically all the associated sets, however it was a good practical way to learn how to produce a CFG with data flow from real code.

**Rutvi**: Overall, I think this lab was an inclusion of various code coverage tools and recommendations gives students flexibility and exposure to different tools used in industry. While the lab mentions reporting three coverage metrics (statement, branch, and condition coverages), it could benefit from more explicit explanations and examples for each metric. This would assist students in understanding and implementing these metrics effectively. The section on manually calculating DU-pair coverage could be enhanced by providing a sample calculation or an example. This would assist students in completing this part of the assignment accurately.

**Angelo**:

**Aaron**:
