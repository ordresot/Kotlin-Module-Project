package models

class Archive(val name: String) {
    //список заметок в архиве
    val notes: MutableList<Note> = mutableListOf()
}
