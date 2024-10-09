package menu

import models.Archive
import utils.IOHandler
import utils.IOHandler.Companion.readNotEmptyInput
import models.MenuItem

class MainMenu(val title: String, var items: ArrayList<MenuItem>, val exitMessage: String = "Назад"){//: Menu(title, items, exitMessage) {
    companion object{
        val archives: MutableList<Archive> = mutableListOf()//список архивов

        //запуск главного меню
        fun mainMenu() {
            val mainMenuItems = arrayListOf(
                MenuItem("Создать архив") { addArchive() }
            )
            archives.forEach { archive ->//отображаем архивы из списка
                mainMenuItems.add(MenuItem("Открыть архив: ${archive.name}") {
                    ArchiveMenu.archiveMenu(
                        archive
                    )
                })
            }
            IOHandler("Список архивов:", mainMenuItems, "Выход").showMenu()
        }

        //добавляем архив
        fun addArchive(): MenuItem {
            println("Введите название архива:")
            val archiveName = readNotEmptyInput()//вводится только непустая строка
            val archive = Archive(archiveName)
            archives.add(archive)
            println("Архив \"$archiveName\" добавлен.")
            return MenuItem("Архив: ${archive.name}") { ArchiveMenu.archiveMenu(archive) }
        }
    }
}