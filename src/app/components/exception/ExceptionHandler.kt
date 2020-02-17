package app.components.exception

import react.RBuilder
import react.dom.div
import react.dom.h1

fun RBuilder.notFoundHandler() =
        div(classes = "not_found__wrapper") {
            h1 {
                +"404: Page not found"
            }
        }