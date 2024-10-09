package models

//элемент меню (название, действие)
data class MenuItem(val title: String, val action: () -> Any?)
