1. Что такое инлайн-функции в Kotlin и зачем они нужны?
   • Ожидаемый ответ: Инлайн-функции помечаются ключевым словом inline. Они позволяют компилятору
   вставлять тело функции в места вызова, что особенно полезно при использовании лямбда-выражений
   для сокращения накладных расходов на создание объектов-функций.

2. Какие ограничения существуют при использовании инлайн-функций?
   • Ожидаемый ответ: Инлайн-функции не могут быть рекурсивными (либо должны быть правильно
   хвостовыми). Также существуют ограничения на использование приватных членов и обращение к ним из
   вложенных функций.

3. Что такое noinline и crossinline модификаторы и когда они используются?
   • Ожидаемый ответ: noinline используется для параметров-лямбд, которые не нужно инлайнить.
   crossinline запрещает нелокальные возвраты из лямбды, гарантируя, что лямбда завершится в той же
   области.

4. Объясните понятие нелокального возврата и как инлайн-функции позволяют его использовать.
   • Ожидаемый ответ: Нелокальный возврат позволяет выйти из функции, содержащей вызов лямбды, прямо
   из лямбды с помощью return. Это возможно только в инлайн-функциях, где лямбда инлайнится в место
   вызова.

5. Как инлайн-функции влияют на размер кода и производительность приложения?
   • Ожидаемый ответ: Инлайн-функции могут увеличить размер байткода из-за вставки кода в места
   вызова, но могут улучшить производительность за счет уменьшения накладных расходов на вызовы
   функций и создание лямбд.

6. Можно ли использовать инлайн-функции для реализации reified типов? Объясните.
   • Ожидаемый ответ: Да, только инлайн-функции могут использовать параметр типа с модификатором
   reified, позволяя использовать информацию о типе во время выполнения.

7. Приведите пример инлайн-функции с reified типом и объясните, как она работает.
   • Ожидаемый ответ:

```kotlin
inline fun <reified T> Gson.fromJson(json: String): T = this.fromJson(json, T::class.java)
```

Эта функция позволяет десериализовать JSON в объект типа T, используя информацию о типе во время
выполнения.

8. Когда следует избегать использования инлайн-функций?
   • Ожидаемый ответ: Когда функция большая и часто вызывается, инлайнинг может значительно
   увеличить размер кода. Также если функция не использует лямбды или преимущества инлайнинга, его
   использование может быть избыточным.

9. Как инлайн-функции взаимодействуют с приватными членами класса?
   • Ожидаемый ответ: Инлайн-функции могут обращаться к приватным членам класса, поскольку код
   функции вставляется в место вызова, но это может привести к утечке реализации при
   инлайн-подстановке.

10. Объясните, почему инлайн-функции не могут быть рекурсивными и как обойти это ограничение.
    • Ожидаемый ответ: Рекурсивные инлайн-функции могут привести к бесконечному циклу при
    инлайнинге. Обойти это можно, пометив рекурсивный вызов как noinline или преобразовав
    функцию в хвостовую рекурсию.