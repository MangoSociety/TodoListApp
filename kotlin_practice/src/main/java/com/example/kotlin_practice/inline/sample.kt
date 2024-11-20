package com.example.kotlin_practice.inline

fun test(action: (String, Int, Boolean) -> Unit) {
    println()
    action("text",1, true)
}

inline fun testInline(action: (String, Int, Boolean) -> Unit) {
    println()
    action("text",1, true)
}

data class Person(
    val title: String,
    val cry: (Boolean) -> Unit
)

fun loadAccount(onError: (Throwable) -> Unit, onSuccess: () -> Unit) {
    try {
        // loadAccounts
    } catch (ex: Exception) {
        onError(ex)
        return
    }
    onSuccess()
}

fun handleError(ex: Throwable) {

}

fun onSuccess() {

}

fun testLoadAccount() {
    loadAccount(
        onError = ::handleError,
        onSuccess = ::onSuccess
    )
}

fun testLoadAccount1() {
    loadAccount(
        onError = {
            handleError(it)
        },
        onSuccess = {
            onSuccess()
        }
    )
}

fun main() {
    val person = Person(
        "Vasya",
        cry = { isCry: Boolean ->
            if (isCry) {
                println("вася плачет, срочно перезапускать сервисы")
            }
        }
    )


    val lambda = { text: String, number: Int, isFlag: Boolean ->
        println(text.hashCode() * number)
    }
    lambda("text",1, true)
    lambda.invoke("text",1, true)
//    test { text: String, number: Int, isFlag: Boolean ->
//        println(text.hashCode() * number)
//    }
    testInline { text: String, number: Int, isFlag: Boolean ->
        println(text.hashCode() * number)
    }
}

//fun main() {
//    val lambda = { text: String, number: Int, isFlag: Boolean ->
//        println(text.hashCode() * number)
//    }
//    println()
//    lambda("text",1, true)
//}

///
//-> 4 val obj = Function1() - описание лямбды action
//-> 4 obj.exec() - выпонление созданной лямбды