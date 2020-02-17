package app.components.index

import app.components.constants.RouterPath
import app.modules.Properties
import react.RBuilder
import react.dom.div
import react.dom.h1
import react.dom.h2
import react.dom.li
import react.dom.p
import react.dom.span
import react.dom.ul
import react.router.dom.routeLink

fun RBuilder.indexPage(apis: Map<String, String>) =
        div(classes = "index__wrapper") {
            ul {
                for (api in apis) {
                    li {
                        routeLink(to = "${RouterPath.SCHEMA.path}/$api") {
                            +api.key
                        }
                    }
                }
            }
        }