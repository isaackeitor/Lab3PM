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
    val result = processList(listOf(20, 25, 2, 7, "hola", "", true, false, null, 2.0))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    val exitList = ArrayList<ItemData>()
    if(inputList.isNullOrEmpty()){
        return when(inputList){
            null -> null
            else -> exitList  
        }
    } else {
        for (index in inputList.indices) {
           	 if(inputList[index] != null){
                 exitList.add(ItemData(index, inputList[index]!!, objectType(inputList[index]!!),objectInfo(inputList[index]!!)))
             }
        }
    }

    return exitList
}

fun objectType (myAnyTypeElement: Any): String?{
    return when (myAnyTypeElement){
        is String -> "cadena"
		is Int -> "entero"
		is Boolean -> "booleano"
		else -> null
    }
}

fun objectInfo(myAnyTypeElement: Any): String?{
    return when (myAnyTypeElement){
        is String -> return  "L" + myAnyTypeElement.length
        is Int -> return when {
            myAnyTypeElement % 10 == 0 -> "M10"
            myAnyTypeElement % 5 == 0 -> "M5"
            myAnyTypeElement % 2 == 0 -> "M2"
           else -> null
        }
        is Boolean -> return when{
            myAnyTypeElement == true -> "Verdadero" 
            myAnyTypeElement == false -> "Falso" 
            else -> null
        }
        else -> null
    }
}