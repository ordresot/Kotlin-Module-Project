package menu

import utils.IOHandler
import utils.IOHandler.Companion.readNotEmptyInput
import models.MenuItem
import models.Note

class NoteMenu(val title: String, var items: ArrayList<MenuItem>, val exitMessage: String = "Назад"){//: Menu(title, items, exitMessage) {
    companion object{
        //меню заметок
        fun viewNote(note: Note) {
            val noteMenuItems = arrayListOf(
                MenuItem("Показать содержимое") {
                    println("Заметка: ${note.title}\nСодержание: ${note.content}")
                },
                MenuItem("Добавить содержимое") {
                    println("Введите дополнение к содержанию заметки:")
                    val newContent = readNotEmptyInput()//только непустой ввод
                    note.content += newContent
                    println("Заметка \"$note.title\" обновлена.")
                },
                MenuItem("Изменить содержимое") {
                    println("Введите новое содержание заметки:")
                    val newContent = readNotEmptyInput()//только непустой ввод
                    note.content = newContent
                    println("Заметка \"$note.title\" обновлена.")
                }
            )
            IOHandler("Заметка: ${note.title}", noteMenuItems).showMenu()
        }
    }
}