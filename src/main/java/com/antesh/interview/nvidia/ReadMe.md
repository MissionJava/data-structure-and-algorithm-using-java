#HackerRank coding round interview asked at Nvidia
##Football Scores
The number of goals achieved by two football teams in matches in a league is given in the form of two
lists. Consider:

Football team A, has played three matches, and has scored teamA = [1, 2, 3] goals in each match respectively.
Football team B, has played two matches, and has scored teamB = [2, 4] goals in each match respectively.
For each match of team B, compute the total number of matches of team A where team A has scored less than or equal to
the number of goals scored by team B in that match.

###In the above case:

For 2 goals scored by team B in its first match, team A has 2 matches with scores 1 and 2. For 4 goals scored by team B
in its second match, team A has 3 matches with scores 1, 2 and 3. Hence, the answer: [2, 3].

###Function Description

Complete the function counts in the editor below. The function must return an array of m positive integers, one for each
teamB[i] representing the total number of elements teamA[j] satisfying teamA[j] = teamB[i] where 0 = j < n
and 0 = i < m, in the given order.

###counts has the following parameter(s):

teamA[teamA[0],...teamA[n-1]]:  first array of positive integers

teamB[teamB[0],...teamB[n-1]]:  second array of positive integers

##Constraints

2 = n, m = 105 1 = teamA[j] = 109, where 0 = j < n. 1 = teamB[i] = 109, where 0 = i < m.

Input Format For Custom Testing Input from stdin will be processed as follows and passed to the function.

The first line contains an integer n, the number of elements in teamA.

The next n lines each contain an integer describing teamA[j] where 0 = j < n.

The next line contains an integer m, the number of elements in teamB.

The next m lines each contain an integer describing teamB[i] where 0 = i < m.

##Sample Case 0 
###Sample Input 0

4 1 4 2 4 2 3 5 

###Sample Output 0
2 4 

###Explanation 0

Given values are n = 4, teamA = [1, 4, 2, 4], m = 2, and teamB = [3, 5].

For teamB[0] = 3, we have 2 elements in teamA (teamA[0] = 1 and teamA[2] = 2) that are = teamB[0]. For teamB[1] = 5,
we have 4 elements in teamA (teamA[0] = 1, teamA[1] = 4, teamA[2] = 2, and teamA[3] = 4) that are = teamB[1].
Thus, the function returns the array [2, 4] as the answer.

##Sample Case 1 
###Sample Input 1

5 2 10 5 4 8 4 3 1 7 8 

###Sample Output 1

1 0 3 4 

###Explanation 1

Given values are n = 5, teamA = [2, 10, 5, 4, 8], m = 4, and teamB = [3, 1, 7, 8].

For teamB[0] = 3, we have 1 element in teamA (teamA[0] = 2) that is = teamB[0]. For teamB[1] = 1, there are 0 elements
in teamA that are = teamB[1]. For teamB[2] = 7, we have 3 elements in teamA (teamA[0] = 2, teamA[2] = 5,
and teamA[3] = 4) that are = teamB[2]. For teamB[3] = 8, we have 4 elements in teamA (teamA[0] = 2, teamA[2] = 5,
teamA[3] = 4, and teamA[4] = 8) that are = teamB[3]. Thus, the function returns the array [1, 0, 3, 4] as the answer.
