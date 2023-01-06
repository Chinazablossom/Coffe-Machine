package coffeMachine

/*
--Description:
Now let's consider a case when you need a lot of coffee.
Maybe you're hosting a party with a lot of guests! In these circumstances, it's better to make preparations in advance.
So, we will ask a user to enter the desired amount of coffee, in cups.
Given this, you can adjust the program by calculating how much water, coffee, and milk are necessary to make the specified amount of coffee.
Of course, all this coffee is not needed right now, so at this stage, the coffee machine doesn't actually make any coffee yet.

--Objectives:
Let's break the task into several steps:
First, read the numbers of coffee drinks from the input.
Figure out how much of each ingredient the machine will need.
Note that one cup of coffee made on this coffee machine contains 200 ml of water, 50 ml of milk, and 15 g of coffee beans.
Output the required ingredient amounts back to the user.

--Examples:
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

-Example 1: a dialogue with a user might look like this

Write how many cups of coffee you will need:
> 25
For 25 cups of coffee you will need:
5000 ml of water
1250 ml of milk
375 g of coffee beans

-Example 2: here is another dialogue

Write how many cups of coffee you will need:
> 125
For 125 cups of coffee you will need:
25000 ml of water
6250 ml of milk
1875 g of coffee beans

 */

fun main() {
    println("Write how many cups of coffee you will need:")
    val numberOfCoffee = readln().toInt()
    println(
        "For $numberOfCoffee cups of coffee you will need:\n" +
        "${numberOfCoffee * 200} ml of water\n" +
        "${numberOfCoffee * 50} ml of milk\n" +
        "${numberOfCoffee * 15} g of coffee beans"
    )

}