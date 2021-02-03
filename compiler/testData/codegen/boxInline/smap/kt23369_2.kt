
// FILE: a.kt

package test

inline fun inlineFun(lambda: () -> String): String {
    return lambda()
}

// FILE: 2.kt
import test.*

fun box(): String {
    return inlineFun { "OK" }
}

// SMAP_FILE: 1+ a.smap

// SMAP_FILE: 2.smap

SMAP
2.kt
Kotlin
*S Kotlin
*F
+ 1 2.kt
_2Kt
+ 2 1+ a.kt
test/_1__aKt
*L
1#1,8:1
7#2:9
*S KotlinDebug
*F
+ 1 2.kt
_2Kt
*L
5#1:9
*E
