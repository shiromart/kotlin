
// NO_CHECK_LAMBDA_INLINING
// FILE: 1.kt
package test

inline fun test(s: () -> Unit) {
    val z = 1;
    s()
    val x = 1;
}

// FILE: 2.kt

import test.*

inline fun test2(s: () -> String): String {
    val z = 1;
    val res = s()
    return res
}

fun box(): String {
    var result = "fail"

    test {
        {
            result = test2 {
                "OK"
            }
        }()
    }

    return result
}


// SMAP_FILE: 1.smap

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
*L
1#1,26:1
7#2,4:27
*S KotlinDebug
*F
+ 1 2.kt
_2Kt
*L
14#1:27,4
*E

SMAP
2.kt
Kotlin
*S Kotlin
*F
+ 1 2.kt
_2Kt$box$1$1
+ 2 2.kt
_2Kt
*L
1#1,26:1
6#2,3:27
*S KotlinDebug
*F
+ 1 2.kt
_2Kt$box$1$1
*L
16#1:27,3
*E
