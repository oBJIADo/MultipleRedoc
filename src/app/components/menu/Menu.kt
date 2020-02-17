package app.components.menu

import app.components.constants.RouterPath
import app.modules.API_MAP
import app.modules.BurgerState
import app.modules.MenuSlide
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h2
import react.dom.span
import react.router.dom.routeLink
import react.setState

interface MenuState : RState {
    var isOpen: Boolean
}

interface MenuProps : RProps {
}

class Menu(props: MenuProps) : RComponent<MenuProps, MenuState>(props) {

    override fun MenuState.init(props: MenuProps) {
        isOpen = false
    }

    private fun closeMenu(event: Event) {
        setIsMenuOpen(false)
    }

    private fun setMenuState(newState: BurgerState) {
        setIsMenuOpen(newState.isOpen)
    }

    private fun setIsMenuOpen(isMenuOpen: Boolean) {
        setState { isOpen = isMenuOpen }
    }

    private val activeButtonClass = "noselect__wrapper bm-burger-button-active"
    private val inactiveButtonClass = "noselect__wrapper bm-burger-button-inactive"

    override fun RBuilder.render() {
        div(classes = "right") {
            MenuSlide {
                attrs {
                    id = "slide"
                    pageWrapId = "page-wrap"
                    outerContainerId = "outer-container"
                    isOpen = state.isOpen
                    right = true
                    disableAutoFocus = false
                    burgerButtonClassName = if (state.isOpen) inactiveButtonClass else activeButtonClass
                    itemListClassName = "noselect__wrapper menu_list__wrapper"
                    onStateChange = ::setMenuState
                    crossButtonClassName = "noselect__wrapper cross__button"
                    burgerBarClassName = "asdadsasdasdasddsasadasd"
                }

                h2(classes = "noselect__wrapper menu__header") {
                    +"APIs"
                }
                menuLink(link = RouterPath.INDEX, text = "HOME", onClick = ::closeMenu)
                div(classes = "line__splitter") {}
                for (api in API_MAP) {
                    linkToSchema(schema = api.key, onClick = ::closeMenu)
                }
            }
        }
    }

    private fun RBuilder.linkToSchema(schema: String, onClick: (event: Event) -> Unit) =
            routeLink(to = "${RouterPath.SCHEMA.path}/${schema}") {
                span(classes = "menu__schema_element menu__element") {
                    attrs { onClickFunction = onClick }
                    +schema
                }
            }

    private fun RBuilder.menuLink(link: RouterPath, text: String, onClick: (event: Event) -> Unit) =
            routeLink(to = link.path) {
                span(classes = "menu__active_element menu__element") {
                    attrs { onClickFunction = onClick }
                    +text
                }
            }
}

fun RBuilder.menu() = child(Menu::class) {}