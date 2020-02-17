package app.modules

import org.w3c.dom.events.Event
import react.RClass
import react.RProps
import kotlin.js.Json

external interface BurgerMenu {
    var slide: RClass<BurgerMenuProps>
    var stack: RClass<BurgerMenuProps>
    var elastic: RClass<BurgerMenuProps>
    var bubble: RClass<BurgerMenuProps>
    var push: RClass<BurgerMenuProps>
    var pushRotate: RClass<BurgerMenuProps>
    var scaleDown: RClass<BurgerMenuProps>
    var scaleRotate: RClass<BurgerMenuProps>
    var fallDown: RClass<BurgerMenuProps>
    var reveal: RClass<BurgerMenuProps>
}

/**
 * This module allow to import react-burger-menu: Main menu in the app. This menu is opensource react component.
 * GitUrl:      https://github.com/negomi/react-burger-menu
 * ExampleUrl:  https://negomi.github.io/react-burger-menu/
 */
@JsModule("react-burger-menu")
external val Menu: BurgerMenu

/**
 * Wrapper for properties to BurgerMenu. All properties on github page. Not a default wrapper.
 *
 *
 *
 */
interface BurgerProps {

    /**
     * There are optional id and className props, which will simply add an ID or custom className to the rendered menu's
     * outermost element. This is not required for any functionality, but could be useful for things like styling with CSS modules.
     */
    var id: String

    /**
     * There are optional id and className props, which will simply add an ID or custom className to the rendered menu's
     * outermost element. This is not required for any functionality, but could be useful for things like styling with CSS modules.
     */
    var className: String?

    var burgerButtonClassName: String
    var crossButtonClassName: String?

    var burgerBarClassName: String?
    var crossClassName: String?
    var morphShapeClassName: String?
    var itemListClassName: String
    var overlayClassName: String?

    var menuClassName: String?
    var htmlClassName: String?
    var bodyClassName: String?

    /**
     * Page wrapper - an element wrapping the rest of the content on your page (except elements with fixed positioning),
     * placed after the menu component
     */
    var pageWrapId: String

    /**
     * Outer container - an element containing everything, including the menu component
     */
    var outerContainerId: String

    /**
     * Open state
     * You can control whether the sidebar is open or closed with the isOpen prop. This is useful if you need to close
     * the menu after a user clicks on an item in it, for example, or if you want to open the menu from some other
     * button in addition to the standard burger icon. The default value is false.
     */
    var isOpen: Boolean

    /**
     * Position - The menu opens from the left by default. To have it open from the right, use the right prop.
     * It's just a Boolean so you don't need to specify a value. Then set the position of the button using CSS.
     */
    var right: Boolean

    /**
     * Width - You can specify the width of the menu with the width prop. The default is 300.
     */
    var width: String?

//    var onStateChange

    /**
     * Close on Escape - By default, the menu will close when the Escape key is pressed. To disable this behavior,
     * you can pass the disableCloseOnEsc prop. This is useful in cases where you want the menu to be open all the time,
     * for example if you're implementing a responsive menu that behaves differently depending on the browser width.
     */
    var disableCloseOnEsc: Boolean

    /**
     * Custom window.onkeydown handler - For more control over global keypress functionality, you can override the
     * handler that this component sets for window.onkeydown, and pass a custom function. This could be useful if you
     * are using multiple instances of this component, for example, and want to implement functionality to ensure that a
     * single press of the Escape key closes them all.
     */
    var customOnKeyDown: (e: Event) -> Unit

    /**
     * Overlay - You can turn off the default overlay with noOverlay
     */
    var noOverlay: Boolean

    /**
     * Custom icons - You can replace the default bars that make up the burger and cross icons with custom ReactElements.
     * Pass them as the customBurgerIcon and customCrossIcon props respectively.
     *
     * <Menu customBurgerIcon={ <img src="img/icon.svg" /> } />
     * <Menu customCrossIcon={ <img src="img/cross.svg" /> } />
     * You should adjust their size using the .bm-burger-button and .bm-cross-button classes, but the element itself will have the class .bm-icon or .bm-cross if you need to access it directly.
     *
     * You can also disable the icon elements so they won't be included at all, by passing false to these props.
     *
     * <Menu customBurgerIcon={ false } />
     * <Menu customCrossIcon={ false } />
     * This can be useful if you want exclusive external control of the menu, using the isOpen prop.
     */
    var customBurgerIcon: String?
    var customCrossIcon: String?

    /**
     * Focusing the first menu item -
     * By default, the menu will set focus on the first item when opened. This is to help with keyboard navigation.
     * If you don't want this functionality, you can pass the disableAutoFocus prop.
     */
    var disableAutoFocus: Boolean

    /**
     * Styles
     */
    var styles: Json?

    var onStateChange: (newState: BurgerState) -> Unit
}

interface BurgerState {
    var isOpen: Boolean
}

/**
 * React props
 */
interface BurgerMenuProps : RProps, BurgerProps

/**
 * Slide menu instance.
 * Burger-menu used default css from example (with some changes), that in app package (BurgerMenu.css)
 */
val MenuSlide: RClass<BurgerMenuProps> = Menu.slide

class DefaultBurgerProperties(
        //Mandatory defaults
        override var id: String = "slide",
        override var isOpen: Boolean = false,
        override var right: Boolean = false,
        override var pageWrapId: String = "page-wrap",
        override var outerContainerId: String = "outer-container",

        //Boolean not mandatory (default false)
        override var disableCloseOnEsc: Boolean = false,
        override var disableAutoFocus: Boolean = false,
        override var noOverlay: Boolean = false,

        //Classes
        override var burgerButtonClassName: String = "noselect__wrapper",
        override var itemListClassName: String = "noselect__wrapper",

        override var className: String? = null,
        override var crossButtonClassName: String? = "cross_button__element",
        override var burgerBarClassName: String? = null,
        override var crossClassName: String? = null,
        override var morphShapeClassName: String? = null,
        override var overlayClassName: String? = null,
        override var menuClassName: String? = null,
        override var htmlClassName: String? = null,
        override var bodyClassName: String? = null,
        override var width: String? = null,
        override var customBurgerIcon: String? = null,
        override var customCrossIcon: String? = null,
        override var styles: Json? = null,

        //default functions
        override var onStateChange: (newState: BurgerState) -> Unit = {},
        override var customOnKeyDown: (e: Event) -> Unit = {}
) : BurgerProps