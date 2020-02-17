package app.components.constants

enum class RouterPath(val path: String) {
    SCHEMA("/schema"),
    INDEX("/"),
    ANY("*");

    override fun toString(): String = path
}