// DONT_TARGET_EXACT_BACKEND: JS JS_IR JS_IR_ES6 WASM NATIVE
// MODULE: lib
// FILE: JavaClass.java

public class JavaClass {

    public Double minus0()
    {
        return -0.0;
    }

    public Double plus0()
    {
        return 0.0;
    }
}

// MODULE: main(lib)
// FILE: b.kt

fun box(): String {
    val jClass = JavaClass()

    if ((jClass.minus0() as Comparable<Double>) >= jClass.plus0()) return "fail 1"
    if ((jClass.minus0() as Comparable<Double>) == jClass.plus0()) return "fail 2"
    if (jClass.minus0() == (jClass.plus0() as Comparable<Double>)) return "fail 3"

    return "OK"
}
