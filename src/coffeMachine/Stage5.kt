package coffeMachine
import kotlin.system.exitProcess
/*
--Description:
Just one action is not so interesting, is it? Let's improve the program so it can do multiple actions, one after another.
It should repeatedly ask a user what they want to do. If the user types "buy", "fill" or "take",
then the program should do exactly the same thing it did in the previous step.
However, if the user wants to switch off the coffee machine, they should type "exit". The program should terminate on this command.
Also, when the user types "remaining",the program should output all the resources that the coffee machine has.
This means that you shouldn't show the remaining stock levels at the beginning/end of the program.

Remember, that:

For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.

--Objectives:
Write a program that will work endlessly to make coffee for all interested persons until the shutdown signal is given.
Introduce two new options: "remaining" and "exit".

Do not forget that you can be out of resources for making coffee.
If the coffee machine doesn't have enough resources to make coffee,
the program should output a message that says it can't make a cup of coffee and state what is missing.

And the last improvement to the program at this step —
if the user types "buy" to buy a cup of coffee and then changes his mind, they should be able to type "back" to return into the main cycle.

--Example:
Your coffee machine should have the same initial resources as in the example
(400 ml of water, 540 ml of milk, 120 g of coffee beans, 9 disposable cups, $550 in cash).

The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Write action (buy, fill, take, remaining, exit):
> remaining

The coffee machine has:
400 ml of water
540 ml of milk
120 g of coffee beans
9 disposable cups
$550 of money

Write action (buy, fill, take, remaining, exit):
> buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
> 2
I have enough resources, making you a coffee!

Write action (buy, fill, take, remaining, exit):
> remaining

The coffee machine has:
50 ml of water
465 ml of milk
100 g of coffee beans
8 disposable cups
$557 of money

Write action (buy, fill, take, remaining, exit):
> buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
> 2
Sorry, not enough water!

Write action (buy, fill, take, remaining, exit):
> fill

Write how many ml of water you want to add:
> 1000
Write how many ml of milk you want to add:
> 0
Write how many grams of coffee beans you want to add:
> 0
Write how many disposable cups you want to add:
> 0

Write action (buy, fill, take, remaining, exit):
> remaining

The coffee machine has:
1050 ml of water
465 ml of milk
100 g of coffee beans
8 disposable cups
$557 of money

Write action (buy, fill, take, remaining, exit):
> buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
> 2
I have enough resources, making you a coffee!

Write action (buy, fill, take, remaining, exit):
> remaining

The coffee machine has:
700 ml of water
390 ml of milk
80 g of coffee beans
7 disposable cups
$564 of money

Write action (buy, fill, take, remaining, exit):
> take

I gave you $564

Write action (buy, fill, take, remaining, exit):
> remaining

The coffee machine has:
700 ml of water
390 ml of milk
80 g of coffee beans
7 disposable cups
$0 of money

Write action (buy, fill, take, remaining, exit):
> exit

 */

private var mlWater = 400
private var mlMilk = 540
private var gCoffeBean = 120
private var disposableCups = 9
private var money = 550

fun main() {
    menu()
}
private fun menu(){
    do {
        println("Write action (buy, fill, take, remaining, exit):")
        val userInput = readln()
        when (userInput) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> status()
            "exit" -> exitProcess(0)
        }
    } while (true)

}
private fun status() {
    println()
    println("The coffee machine has:")
    println("$mlWater ml of water")
    println("$mlMilk ml of milk")
    println("$gCoffeBean g of coffee beans")
    println("$disposableCups disposable cups")
    println("$$money of money")
    println()

}
private fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    when (readln()) {

        "1" -> do {
            if (mlWater >= 250 && gCoffeBean >= 16) {
                println("I have enough resources, making you a coffee!")
                mlWater -= 250
                gCoffeBean -= 16
                disposableCups -= 1
                money += 4
                break
            } else if (mlWater < 250) {
                println("Sorry, not enough water!")
                break
            } else if (gCoffeBean < 16) {
                println("Sorry, not enough coffee beans!")
                break
            }

        } while (true)


        "2" -> do {
            if (mlWater >= 350 && mlMilk >= 75 && gCoffeBean >= 20) {
                println("I have enough resources, making you a coffee!")
                mlWater -= 350
                mlMilk -= 75
                gCoffeBean -= 20
                disposableCups -= 1
                money += 7
                break
            } else if (mlWater < 350) {
                println("Sorry, not enough water!")
                break
            } else if (mlMilk < 75) {
                println("Sorry, not enough milk!")
                break
            } else if (gCoffeBean < 20) {
                println("Sorry, not enough coffee beans!")
                break
            }
        } while (true)

        "3" -> do{
            if (mlWater >= 200 && mlMilk >= 100 && gCoffeBean >= 12){
                println("I have enough resources, making you a coffee!")
                mlWater -= 200
                mlMilk -= 100
                gCoffeBean -= 12
                disposableCups -= 1
                money += 6
                break
            }else if (mlWater < 200){
                println("Sorry, not enough water!")
                break
            }else if (mlMilk < 100){
                println("Sorry, not enough milk!")
                break
            }else if (gCoffeBean < 12){
                println("Sorry, not enough coffee beans!")
                break
            }
        }while (true)

        "back" ->  menu()
    }
}
private fun fill() {
    println("Write how many ml of water you want to add:")
    val fillWater = readln().toInt()
    println("Write how many ml of milk you want to add:")
    val fillMilk = readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    val fillBean = readln().toInt()
    println("Write how many disposable cups you want to add:")
    val fillCup = readln().toInt()

    mlWater += fillWater
    mlMilk += fillMilk
    gCoffeBean += fillBean
    disposableCups += fillCup
}
private fun take() {
    println("I gave you $$money")
    money -= money
}
