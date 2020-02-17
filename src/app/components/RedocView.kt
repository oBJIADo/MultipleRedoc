package app.components

import app.components.constants.RouterPath
import app.components.exception.notFoundHandler
import app.components.index.indexPage
import app.modules.API_MAP
import app.modules.redocComponent
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.route
import react.router.dom.switch
import kotlin.js.json

interface RedocViewState : RState {
}

class RedocView : RComponent<RProps, RedocViewState>() {
    val apiPath = "/api"

    override fun RBuilder.render() {
        switch {
            route(exact = true, path = RouterPath.INDEX.path) {
                indexPage(API_MAP)
            }
            route<SourceProps>("${RouterPath.SCHEMA}/:name") {
                val type = API_MAP[it.match.params.name] ?: ".json"

                redocComponent {
                    attrs {
                        specUrl = "$apiPath/${it.match.params.name}$type"
                        options = json(
                                "hideDownloadButton" to false
                        )

                    }
                }
            }
            route(path = "") {
                notFoundHandler()
            }
        }
    }

    interface SourceProps : RProps {
        var name: String
    }
}

fun RBuilder.redocView() = child(RedocView::class) {}