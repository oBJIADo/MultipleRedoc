package app

import app.components.menu.menu
import app.components.redocView
import app.modules.API_MAP
import app.modules.PROPERTIES
import kotlinext.js.require
import kotlinext.js.requireAll
import kotlinx.html.id
import react.dom.div
import react.dom.render
import react.router.dom.hashRouter
import kotlin.browser.document

/**
 * Index class. App starting here.
 */
fun main(args: Array<String>) {
    // Need to load all css files into src folder
    requireAll(require.context("src", true, js("/\\.css$/")))

    render(document.getElementById("app")) {
        hashRouter {
            div {
                console.log(API_MAP)
                console.log(PROPERTIES)
                attrs {
                    id = "outer-container"
                }
                menu()
                div {
                    attrs {
                        id = "page-wrap"
                    }
                    redocView()
                }
            }
        }
    }
}