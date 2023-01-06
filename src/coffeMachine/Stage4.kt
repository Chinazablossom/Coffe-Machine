package coffeMachine

/*
--Description:
Let's simulate an actual coffee machine!
What do we need for that? This coffee machine will have a limited supply of water, milk, coffee beans, and disposable cups.
Also, it will calculate how much money it gets for selling coffee.

There are several options for the coffee machine we want you to implement:
first, it should sell coffee. It can make different types of coffee: espresso, latte, and cappuccino.
Of course, each variety requires a different amount of supplies, however, in any case, you will need only one disposable cup for a drink.
Second, the coffee machine must get replenished by a special worker.
Third, another special worker should be able to take out money from the coffee machine.

--Objectives:
Write a program that offers to buy one cup of coffee or to fill the supplies or to take its money out.
Note that the program is supposed to do one of the mentioned actions at a time.
It should also calculate the amounts of remaining ingredients and how much money is left.
Display the quantity of supplies before and after purchase.

First, your program reads one option from the standard input, which can be "buy", "fill", "take".
If a user wants to buy some coffee, the input is "buy".
If a special worker thinks that it is time to fill out all the supplies for the coffee machine, the input line will be "fill".
If another special worker decides that it is time to take out the money from the coffee machine, you'll get the input "take".
If the user writes "buy" then they must choose one of three types of coffee that the coffee machine can make: espresso, latte, or cappuccino.
For one espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
If the user writes "fill", the program should ask them how much water, milk, coffee and how many disposable cups they want to add into the coffee machine.
If the user writes "take" the program should give all the money that it earned from selling coffee.
At the moment, the coffee machine has $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cups.

To sum up, your program should print the coffee machine's state, process one query from the user,
as well as print the coffee machine's state after that. Try to use functions for implementing every action that the coffee machine can do.

--Examples:
An espresso should be number 1 in the list, a latte number 2, and a cappuccino number 3.
Options are named as "buy", "fill", "take".

The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

-Example 1:

The coffee machine has:
400 ml of water
540 ml of milk
120 g of coffee beans
9 disposable cups
$550 of money

Write action (buy, fill, take):
> buy
What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:
> 3

The coffee machine has:
200 ml of water
440 ml of milk
108 g of coffee beans
8 disposable cups
$556 of money

-Example 2:

The coffee machine has:
400 ml of water
540 ml of milk
120 g of coffee beans
9 disposable cups
$550 of money

Write action (buy, fill, take):
> fill
Write how many ml of water you want to add:
> 2000
Write how many ml of milk you want to add:
> 500
Write how many grams of coffee beans you want to add:
> 100
Write how many disposable cups you want to add:
> 10

The coffee machine has:
2400 ml of water
1040 ml of milk
220 g of coffee beans
19 disposable cups
$550 of money

-Example 3:

The coffee machine has:
400 ml of water
540 ml of milk
120 g of coffee beans
9 disposable cups
$550 of money

Write action (buy, fill, take):
> take
I gave you $550

The coffee machine has:
400 ml of water
540 ml of milk
120 g of coffee beans
9 disposable cups
$0 of money

 */

private var mlWater = 400
private var mlMilk = 540
private var gCoffeBean = 120
private var disposableCups = 9
private var money  = 550

fun main() {
    println("The coffee machine has:\n" +
            "$mlWater ml of water\n" +
            "$mlMilk ml of milk\n" +
            "$gCoffeBean g of coffee beans\n" +
            "$disposableCups disposable cups\n" +
            "$$money of money \n" )

    println("Write action (buy, fill, take):")
    when(readln()){
        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
    }

}
private fun buy(){
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")

    when(readln().toInt()){
        1 -> println("The coffee machine has:\n" +
                "${mlWater - 250} ml of water\n" +
                "$mlMilk ml of milk\n" +
                "${gCoffeBean - 16} g of coffee beans\n" +
                "${disposableCups - 1} disposable cups\n" +
                "$${money + 4} of money")

        2 -> println("The coffee machine has:\n" +
                "${mlWater - 350} ml of water\n" +
                "${mlMilk - 75} ml of milk\n" +
                "${gCoffeBean - 20} g of coffee beans\n" +
                "${disposableCups - 1} disposable cups\n" +
                "$${money + 7} of money")

        3 ->
            println("The coffee machine has:\n" +
                    "${mlWater - 200} ml of water\n" +
                    "${mlMilk - 100} ml of milk\n" +
                    "${gCoffeBean - 12} g of coffee beans\n" +
                    "${disposableCups - 1} disposable cups\n" +
                    "$${money + 6} of money")

    }

}

private fun fill(){
    println("Write how many ml of water you want to add:")
    val fillWater = readln().toInt()
    println("Write how many ml of milk you want to add:")
    val fillMilk = readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    val fillBean = readln().toInt()
    println("Write how many disposable cups you want to add:")
    val fillCup = readln().toInt()

    println("The coffee machine has:\n" +
            "${mlWater + fillWater} ml of water\n" +
            "${mlMilk + fillMilk} ml of milk\n" +
            "${gCoffeBean + fillBean} g of coffee beans\n" +
            "${disposableCups + fillCup} disposable cups\n" +
            "$$money of money \n" )
}
private fun take(){
    println("I gave you $$money")
    println("The coffee machine has:\n" +
            "$mlWater ml of water\n" +
            "$mlMilk ml of milk\n" +
            "$gCoffeBean g of coffee beans\n" +
            "$disposableCups disposable cups\n" +
            "$${money - money} of money \n" )

}
