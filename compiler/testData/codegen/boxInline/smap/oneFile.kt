
// FILE: 1.kt

package zzz

inline fun nothing() {}

// FILE: 2.kt

fun box(): String {
    return test {
        "K"
    }
}

inline fun test(p: () -> String): String {
    var pd = ""
    pd = "O"
    return pd + p()
}

// SMAP_FILE: 1.smap

// SMAP_FILE: 2.smap

//TODO should be empty
SMAP
2.kt
Kotlin
*S Kotlin
*F
+ 1 2.kt
_2Kt
*L
1#1,15:1
10#1,3:16
*S KotlinDebug
*F
+ 1 2.kt
_2Kt
*L
4#1:16,3
*E
