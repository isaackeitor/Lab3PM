// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

/**
 *Josue Morales 21116
 */

fun main() {
    val result = processList ( listOf ( 20, 25, 2, 7, "hola", "", true, false, null, 2.0 ) )
    println ( result )
}

fun processList( inputList: List<Any?>? ): List<ItemData>? {
    val exitList = ArrayList<ItemData>()
    if( inputList.isNullOrEmpty() ) {
        return when( inputList ) {
            null -> null
            else -> exitList  
        }
    } else {
        inputList.forEachIndexed { index, obj ->
            if( obj != null ) {
                when( obj ) {
                    is String -> exitList.add( ItemData ( index, obj, "cadena", "L${obj.length}" ) )
                    is Int -> exitList.add( ItemData( index, obj, "entero", objectInfo(obj) ) )
                    is Boolean -> exitList.add( ItemData( index, obj, "booleano", if ( obj == true ) "Verdadero" else "Falso" ) )
                    else -> exitList.add( ItemData( index, obj, null, null ) )
                }
            }
        }
    return exitList
    }
}

fun objectInfo( myAnyTypeElement: Any ): String? {
    return when ( myAnyTypeElement ) {
        is Int -> return when {
            myAnyTypeElement % 10 == 0 -> "M10"
            myAnyTypeElement % 5 == 0 -> "M5"
            myAnyTypeElement % 2 == 0 -> "M2"
            else -> null
        }
        else -> null
    }
}