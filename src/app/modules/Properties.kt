package app.modules

external interface JsonMap<Key, Value> {
    @JsName("key")
    var key: Key
    @JsName("value")
    var value: Value
}

external interface Properties {
    @JsName("apiMap")
    val apiMap: Array<JsonMap<String, String>>
}

@JsName("properties")
external val PROPERTIES: Properties = definedExternally

val API_MAP: Map<String, String> by lazy {
    try {
        PROPERTIES.apiMap.map { it.key to it.value }.toMap()
    } catch (e: Exception) {
        mapOf<String, String>()
    }
}
