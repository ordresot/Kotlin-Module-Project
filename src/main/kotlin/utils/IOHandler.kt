package utils

import models.MenuItem

class IOHandler(val title: String, var items: ArrayList<MenuItem>, val exitMessage: String = "Назад") {

    //отрисовка меню
    fun showMenu() {
        while (true) {
            println("\n$title")
            items.forEachIndexed { index, item -> println("$index. ${item.title}") }
            println("${items.size}. $exitMessage")

            val userInput = readValidIntInput(items.size + 1)
            if (userInput == items.size) {
                break
            } else {
                val item = items[userInput].action()
                if (item != null && item !is Unit) items.add(item as MenuItem)
            }
        }
    }

    companion object{

        //только правильный ввод допускается
        fun readValidIntInput(limit: Int): Int {
            while (true) {
                val input = readLine()
                if (input != null && input.all { it.isDigit() }) {
                    val number = input.toInt()
                    if (number in 0 until limit) {
                        return number
                    }
                }
                println("Ошибка: Введите корректный номер.")
            }
        }

        //непустой ввод
        fun readNotEmptyInput(): String {
            while (true) {
                val input = readLine()
                if (!input.isNullOrBlank()) {
                    return input
                }
                println("Ошибка: Ввод не может быть пустым. Попробуйте снова.")
            }
        }
    }
}