// DONT_TARGET_EXACT_BACKEND: JS JS_IR JS_IR_ES6 WASM NATIVE
// MODULE: lib
// FILE: JavaClass.java

import java.io.*;

class JavaClass {
    public static String invokeFilter(FileFilter f, File file1, File file2) {
        return f.accept(file1) + " " + f.accept(file2);
    }
}

// MODULE: main(lib)
// FILE: 1.kt

import java.io.*

fun box(): String {
    val ACCEPT_NAME = "test"
    val WRONG_NAME = "wrong"

    val result = JavaClass.invokeFilter({ file -> ACCEPT_NAME == file?.getName() }, File(ACCEPT_NAME), File(WRONG_NAME))

    if (result != "true false") return "Wrong result: $result"
    return "OK"
}
