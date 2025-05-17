package org.example.algoriyhms

import java.util.*


fun main() {
    program40001()
}


fun program40001() {
    println("==> program40001")
    println()

    val dungeon = arrayOf(
        intArrayOf(-2, -3, 3),
        intArrayOf(-5, -10, 1),
        intArrayOf(10, 30, -5)
    )

    //val m = 3
    //val n = 3
    //int dp[4][4] = filled with Integer.MAX_VALUE
    //Initial dp (3x3 area + extra padding):
    //We then set:
    //dp[3][2] = 1
    //dp[2][3] = 1

    //val result = calculateMinimumHP(dungeon)
    val result = calculateMinimumHPV2(dungeon)
    println()
    println("result = $result")
    println()

}

//-------------------------------------------------------------------------//
//  Final dp table:
//  [7, 5, 2]
//  [6,11, 5]
//  [1, 1, 6]
//
//  dp[0][0] = 7 → You need at least 7 HP to survive the whole dungeon
//-------------------------------------------------------------------------//
//int m = 3, n = 3;
//int dp[4][4] = filled with Integer.MAX_VALUE
//Initial dp (3x3 area + extra padding):
//
//We then set:
//dp[3][2] = 1
//dp[2][3] = 1
//
//Now,DP look Like This:
//INF  INF  INF  INF
//INF  INF  INF  INF
//INF  INF  INF   1
//INF  INF   1   INF
//-------------------------------------------------------------------------//
//i = 2, j = 2 (dungeon[2][2] = -5)
//minHealth = min(dp[3][2], dp[2][3]) - (-5)
//          = min(1, 1) + 5 = 6
//dp[2][2]  = max(1, 6) = 6
//
//i = 2, j = 1 (dungeon[2][1] = 30)
//minHealth = min(dp[3][1] , dp[2][2]) - 30 = 6 - 30 = -24
//dp[2][1] = max(1, -24) = 1
//
//i = 2, j = 0 (dungeon[2][0] = 10)
//minHealth = dp[2][1] - 10 = 1 - 10 = -9
//dp[2][0] = max(1, -9) = 1
//Row 2 done:[1, 1, 6]
//------------------------------------------------------------------------//
//i = 1, j = 2 (dungeon[1][2] = 1)
//minHealth = dp[2][2] - 1 = 6 - 1 = 5
//dp[1][2] = max(1, 5) = 5
//
//i = 1, j = 1 (dungeon[1][1] = -10)
//minHealth = min(dp[2][1]=1, dp[1][2]=5) = 1
//1 - (-10) = 11 → dp[1][1] = max(1, 11) = 11
//
//i = 1, j = 0 (dungeon[1][0] = -5)
//minHealth = min(dp[2][0]=1, dp[1][1]=11) - (-5) = 1 + 5 = 6
//dp[1][0] = max(1, 6) = 6
//
//Row 1 done:[6, 11, 5]
//-----------------------------------------------------------------------//
//i = 0, j = 2 (dungeon[0][2] = 3)
//minHealth = dp[1][2] - 3 = 5 - 3 = 2
//dp[0][2] = max(1, 2) = 2
//
//i = 0, j = 1 (dungeon[0][1] = -3)
//minHealth = min(dp[1][1]=11, dp[0][2]=2) = 2
//2 - (-3) = 5 → dp[0][1] = max(1, 5) = 5
//
//i = 0, j = 0 (dungeon[0][0] = -2)
//minHealth = min(dp[1][0]=6, dp[0][1]=5) = 5
//5 - (-2) = 7 → dp[0][0] = max(1, 7) = 7
//
//Row 0 done:[7, 5, 2]
//----------------------------------------------------------------------//
//Final dp table:
//[7, 5, 2]
//[6,11, 5]
//[1, 1, 6]
//
//dp[0][0] = 7 → You need at least 7 HP to survive the whole dungeon
//----------------------------------------------------------------------//

fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
    val m = dungeon.size
    val n = dungeon[0].size
    val dp = Array(m + 1) {
        IntArray(n + 1)
    }
    for (row in dp) Arrays.fill(row, Int.MAX_VALUE)
    dp[m][n - 1] = 1
    dp[m - 1][n] = 1
    for (i in m - 1 downTo 0) {
        for (j in n - 1 downTo 0) {
            val minHealth = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]
            dp[i][j] = Math.max(1, minHealth)
        }
    }
    return dp[0][0]
}


//Dungeon Game
//The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon.
// The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned
// in the top-left room and must fight his way through dungeon to rescue the princess.
//
//The knight has an initial health point represented by a positive integer. If at any point his health point drops
// to 0 or below, he dies immediately.
//
//Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering
// these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health
// (represented by positive integers).
//
//To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
//
//Return the knight's minimum initial health so that he can rescue the princess.
//
//Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right
// room where the princess is imprisoned.
//
//
//Example 1:
//
//  ->  ->  ->    |
//  -2  -3    3  \/
//  -5  -10   1   |
//  10  30   -5  \/
//
//
//
//
//
//
//Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
//Output: 7
//Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
//Example 2:
//
//Input: dungeon = [[0]]
//Output: 1
//
//
//Constraints:
//
//m == dungeon.length
//n == dungeon[i].length
//1 <= m, n <= 200
//-1000 <= dungeon[i][j] <= 1000

//Демоны захватили принцессу и заключили ее в нижнем правом углу подземелья. Подземелье состоит из m x n комнат,
// расположенных в двухмерной сетке. Наш доблестный рыцарь изначально находился в верхней левой комнате и должен
// был пробиться через подземелье, чтобы спасти принцессу.
//
//У рыцаря есть начальное здоровье, представленное положительным целым числом. Если в какой-либо момент его здоровье
// упадет до 0 или ниже, он немедленно умрет.
//
//Некоторые из комнат охраняются демонами (представлены отрицательными целыми числами), поэтому рыцарь теряет здоровье
// при входе в эти комнаты; другие комнаты либо пусты (представлены как 0), либо содержат магические шары, которые
// увеличивают здоровье рыцаря (представлены положительными целыми числами).
//
//Чтобы добраться до принцессы как можно быстрее, рыцарь решает двигаться только вправо или вниз на каждом шагу.
//
//Верните минимальное начальное здоровье рыцаря, чтобы он мог спасти принцессу.
//
//Обратите внимание, что любая комната может содержать угрозы или усиления, даже первая комната, в которую входит
// рыцарь, и нижняя правая комната, где заточена принцесса.

//*******************************************************************************************************************
//*******************************************************************************************************************
//Dungeon Game problem with dynamic programming.
//Intuition
//The approach, used here is backtracking. But here we are not using the recursion. Instead the array is traversed in the backwards. Which says that the minimum health the soldier need to carry in the first position of the array (the absolute of the value + 1).
//
//Approach
//Step 1 :- Design a loop to traverse from last for ith position.
//Step 2 :- Design a 2nd loop to traverse from last for jth position.
//Step 3 :- If both pointers of the loop stays in last position of the array then we need to check the value. if it is less than 0 return the value as it is. otherwise return 0.
//Step 4 :- If the i pointer stays at last position and j doesn't last position there is a only choice to move left. add the next value to the current value. If the value is greater than 0 return 0 otherwise return as it is.
//Step 5 :- Now check for the second pointer j which is at last position and i pointer doesn't reached the last. then doing the same thing as for ith pointer.
//step 6 :- If both pointer haven't reached the last, we taking two temporary variable for arr[i+1][j] and arr[i][j+1]. adding this maximum in temporary variables to the current value. then checking if the number is greater than 0 then return 0 other wise it will return the value as it is.
//Step 7 :- the number in the first index is the solution for the problem. we need to return the absoluter of the value plus 1.
//
//Complexity
//Time complexity: O(M * N)
//Space complexity: O(1)
//
//Интуиция
//Подход, используемый здесь, — это возврат назад. Но здесь мы не используем рекурсию. Вместо этого массив обходит в обратном направлении. Что говорит о том, что минимальное здоровье, которое солдат должен нести в первой позиции массива (абсолютная величина значения + 1).
//
//Подход
//Шаг 1:- Разработать цикл для обхода с последнего на i-ю позицию.
//Шаг 2:- Разработать второй цикл для обхода с последнего на j-ю позицию.
//Шаг 3:- Если оба указателя цикла остаются в последней позиции массива, то нам нужно проверить значение. Если оно меньше 0, вернуть значение как есть. В противном случае вернуть 0.
//Шаг 4:- Если указатель i остается в последней позиции, а j не в последней позиции, то есть только один вариант — переместиться влево. Добавить следующее значение к текущему значению. Если значение больше 0, вернуть 0, в противном случае вернуть как есть.
//Шаг 5: Теперь проверяем второй указатель j, который находится в последней позиции, а указатель i не достиг последнего. Затем делаем то же самое, что и для указателя i.
//Шаг 6: Если оба указателя не достигли последнего, мы берем две временные переменные для arr[i+1][j] и arr[i][j+1]. Добавляем этот максимум во временных переменных к текущему значению. Затем проверяем, больше ли число 0, затем возвращаем 0, в противном случае возвращается значение как есть.
//Шаг 7: Число в первом индексе является решением задачи. Нам нужно вернуть абсолют значения плюс 1.
//
//Сложность
//Временная сложность: O(M * N)
//Пространственная сложность: O(1)
//******************************************************************************************************************
//

fun calculateMinimumHPV2(dungeon: Array<IntArray>): Int {
    for (i in dungeon.indices.reversed()) {
        for (j in dungeon[0].indices.reversed()) {
            if (i == dungeon.size - 1 && j == dungeon[0].size - 1) {
                if (dungeon[i][j] > 0) dungeon[i][j] = 0
            }
            if (i == dungeon.size - 1 && j + 1 <= dungeon[0].size - 1) {
                dungeon[i][j] = dungeon[i][j + 1] + dungeon[i][j]
                if (dungeon[i][j] > 0) dungeon[i][j] = 0
            } else if (j == dungeon[0].size - 1 && i + 1 <= dungeon.size - 1) {
                dungeon[i][j] = dungeon[i + 1][j] + dungeon[i][j]
                if (dungeon[i][j] > 0) dungeon[i][j] = 0
            } else {
                var temp1 = 0
                var temp2 = 0
                if (i + 1 <= dungeon.size - 1 && j + 1 <= dungeon[0].size - 1) {
                    temp1 = dungeon[i + 1][j]
                    temp2 = dungeon[i][j + 1]
                }
                dungeon[i][j] = dungeon[i][j] + Math.max(temp1, temp2)
                if (dungeon[i][j] > 0) dungeon[i][j] = 0
            }
        }
    }
    return Math.abs(dungeon[0][0]) + 1
}