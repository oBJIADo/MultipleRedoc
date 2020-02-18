package app.components.constants

enum class RouterPath(val path: String) {
    SCHEMA("/api"),
    INDEX("/"),
    ANY("*");

    override fun toString(): String = path
}