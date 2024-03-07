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

Text…

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

# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text…

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
