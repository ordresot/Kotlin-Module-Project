package menu

import models.Archive
import utils.IOHandler
import utils.IOHandler.Companion.readNotEmptyInput
import models.MenuItem
import models.Note

class ArchiveMenu(val title: String, var items: ArrayList<MenuItem>, val exitMessage: String = "Назад"){//: Menu(title, items, exitMessage) {
    companion object{

        //запуск меню архива
        fun archiveMenu(archive: Archive) {
            val archiveMenuItems = arrayListOf(MenuItem("Добавить заметку") { addNote(archive) })
            if (archive.notes.isNotEmpty()) {
                archive.notes.forEachIndexed() { index, note -> //добавляем заметки к отображению в меню
                    archiveMenuItems.add(
                        MenuItem(
                            "Заметка: ${note.title}",
                            { NoteMenu.viewNote(archive.notes[index]) })
                    )
                }
            }
            IOHandler("Заметки в архиве: ${archive.name}", archiveMenuItems).showMenu()
        }

        //добавляем заметку
        fun addNote(archive: Archive): MenuItem {
            println("Введите название заметки:")
            val noteTitle = readNotEmptyInput()//только непустой ввод
            println("Введите текст заметки:")
            val noteContent = readNotEmptyInput()//только непустой ввод
            val newNote = Note(noteTitle, noteContent)
            archive.notes.add(newNote)
            println("Заметка \"$noteTitle\" добавлена.")
            return MenuItem("Заметка: ${noteTitle}") { NoteMenu.viewNote(newNote) }
        }
    }
}