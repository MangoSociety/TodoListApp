package com.example.kotlin_practice.exam.easy.null_safety

inline fun <T,R: Any> SafeList<T>.filterNotNullAndMap(transform: (T) -> R?): SafeList<R>{
    val result = SafeList<R>()
    for (item in this.toList())
        if (item != null){
            transform(item)?.let { result.addIfNotNull(it) }

        }
    return result
}


//    // 4. firstOrNull: возвращает первый не-null элемент или null
//
    inline fun <T> SafeList<T>.firstOrNull(predicate:(T?) -> Boolean = {true}): T? {
        for (item in this.toList()) {
            if (predicate(item)) {
                return item
            }
        }
        return null
    }
