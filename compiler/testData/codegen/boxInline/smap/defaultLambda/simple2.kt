// SKIP_INLINE_CHECK_IN: lParams$default

// FILE: 1.kt

package test
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]


inline fun lParams(initParams: () -> String = {
    "OK"
}): String {
    val z = "body"
    return initParams()
}

// FILE: 2.kt
import test.*

fun box(): String {
    return lParams()
}

// SMAP_FILE: 1.smap
SMAP
1.kt
Kotlin
*S Kotlin
*F
+ 1 1.kt
test/_1Kt$lParams$1
*L
1#1,38:1
*E

// SMAP_FILE: 2.smap

SMAP
2.kt
Kotlin
*S Kotlin
*F
+ 1 2.kt
_2Kt
+ 2 1.kt
test/_1Kt
+ 3 1.kt
test/_1Kt$lParams$1
*L
1#1,8:1
31#2,5:9
32#3:14
*S KotlinDebug
*F
+ 1 2.kt
_2Kt
*L
5#1:9,5
5#1:14
*E
