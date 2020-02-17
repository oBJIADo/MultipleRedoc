package app.modules

import react.RClass
import react.RProps
import kotlin.js.Json

external interface Redoc {
    var RedocStandalone: RClass<RedocRProps>
}

@JsModule("redoc")
external val redoc: Redoc

external interface Options {
    /**
     * disable search indexing and search box.
     */
    var disableSearch: Boolean?

    /**
     * enable expanding default server variables, default false.
     */
    var expandDefaultServerVariables: Boolean?
    /**
     * specify which responses to expand by default by response codes. Values should be passed as comma-separated list without spaces e.g. expandResponses="200,201". Special value "all" expands all responses by default. Be careful: this option can slow-down documentation rendering time.
     */
    var expandResponses: String?

    /**
     * do not show "Download" spec button. THIS DOESN'T MAKE YOUR SPEC PRIVATE, it just hides the button.
     */
    @JsName("hideDownloadButton")
    var hideDownloadButton: Boolean?
    /**
     * if set, the protocol and hostname is not shown in the operation definition.
     */
    var hideHostname: Boolean?
    /**
     * do not show loading animation. Useful for small docs.
     */
    var hideLoading: Boolean?

    /**
     * do not show the request sample tab for requests with only one sample.
     */
    var hideSingleRequestSampleTab: Boolean?
    /**
     * set the default expand level for JSON payload samples (responses and request body). Special value 'all' expands all levels. The default value is 2.
     */
    var jsonSampleExpandLevel: String?
    /**
     * Not implemented yet if set, enables lazy rendering mode in ReDoc. This mode is useful for APIs with big number of operations (e.g. > 50). In this mode ReDoc shows initial screen ASAP and then renders the rest operations asynchronously while showing progress bar on the top. Check out the demo for the example.
     */
    var lazyRendering: Boolean?

    /**
     * if true clicking second time on expanded menu item will collapse it, default false.
     */
    var menuToggle: Boolean?
    /**
     * use native scrollbar for sidemenu instead of perfect-scroll (scrolling performance optimization for big specs).
     */
    var nativeScrollbars: Boolean?
    /**
     * do not inject Authentication section automatically.
     */
    var noAutoAuth: Boolean?
    /**
     * shows only required fields in request samples.
     */
    var onlyRequiredInSamples: Boolean?
    /**
     * show path link and HTTP verb in the middle panel instead of the right one.
     */
    var pathInMiddlePanel: Boolean?
    /**
     * show required properties first ordered in the same order as in required array.
     */
    var requiredPropsFirst: Boolean?
    /**
     * If set, specifies a vertical scroll-offset. This is often useful when there are fixed positioned elements at the top of the page, such as navbars, headers etc; scrollYOffset can be specified in various ways:
     * number: A fixed number of pixels to be used as offset.
     * selector: selector of the element to be used for specifying the offset. The distance from the top of the page to the element's bottom will be used as offset.
     * function: A getter function. Must return a number representing the offset ( in pixels).
     */
    var scrollYOffset: Any?

    /**
     * show vendor extensions ("x-" fields). Extensions used by ReDoc are ignored. Can be boolean or an array of string with names of extensions to display.
     */
    var showExtensions: Array<String>?

    /**
     * sort properties alphabetically.
     */
    var sortPropsAlphabetically: Boolean?
    /**
     * if set, warnings are not rendered at the top of documentation (they still are logged to the console).
     */
    var suppressWarnings: Boolean?
    /**
     * if set, payload sample will be inserted at this index or last. Indexes start from 0.
     */
    var payloadSampleIdx: Boolean?
    /**
     * ReDoc theme. Not documented yet. For details check source code: theme.ts.
     */
    var theme: Any?
    /**
     * if set, the spec is considered untrusted and all HTML/markdown is sanitized to prevent XSS. Disabled
     */
    var untrustedSpec: Boolean?
}

class EmptyOptions : Options {
    override var disableSearch: Boolean? = null
    override var expandDefaultServerVariables: Boolean? = null
    override var expandResponses: String? = null
    override var hideDownloadButton: Boolean? = null
    override var hideHostname: Boolean? = null
    override var hideLoading: Boolean? = null
    override var hideSingleRequestSampleTab: Boolean? = null
    override var jsonSampleExpandLevel: String? = null
    override var lazyRendering: Boolean? = null
    override var menuToggle: Boolean? = null
    override var nativeScrollbars: Boolean? = null
    override var noAutoAuth: Boolean? = null
    override var onlyRequiredInSamples: Boolean? = null
    override var pathInMiddlePanel: Boolean? = null
    override var requiredPropsFirst: Boolean? = null
    override var scrollYOffset: Any? = null
    override var showExtensions: Array<String>? = null
    override var sortPropsAlphabetically: Boolean? = null
    override var suppressWarnings: Boolean? = null
    override var payloadSampleIdx: Boolean? = null
    override var theme: Any? = null
    override var untrustedSpec: Boolean? = null
}

external interface RedocProps {
    var specUrl: String
    @JsName("options")
    var options: Json
    var onLoaded: () -> Unit?
}

interface RedocRProps : RProps, RedocProps

val redocComponent: RClass<RedocRProps> = redoc.RedocStandalone
