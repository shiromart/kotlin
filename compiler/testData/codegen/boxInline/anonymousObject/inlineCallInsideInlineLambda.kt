// DUMP_SMAP
// NO_CHECK_LAMBDA_INLINING
// FILE: 1.kt

package test

object A {
    inline fun test(s: () -> Unit) {
        s()
    }
}

object B {
    inline fun test2(s: () -> Unit) {
        s()
    }
}

// FILE: 2.kt
import test.*


fun box(): String {
    var z = "fail"

    B.test2 {
        { // regenerated object in inline lambda
            A.test {
                z = "OK"
            }
        }()
    }
    return z;
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
test/B
*L
1#1,19:1
13#2,2:20
*S KotlinDebug
*F
+ 1 2.kt
_2Kt
*L
9#1:20,2
*E

SMAP
2.kt
Kotlin
*S Kotlin
*F
+ 1 2.kt
_2Kt$box$1$1
+ 2 1.kt
test/A
*L
1#1,19:1
7#2,2:20
*S KotlinDebug
*F
+ 1 2.kt
_2Kt$box$1$1
*L
11#1:20,2
*E
