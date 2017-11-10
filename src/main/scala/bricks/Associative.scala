
package bricks

import Binary._

/**
    The trait contains the associative law: 

    Suppose that S is a set and • is some binary operation S × S → S
    For all a, b and c in S, the equation (a • b) • c = a • (b • c) holds.

    It proves that it doesn't matter in which order to calculate the binary operation.
    The property is useful in parallel and distributed systems.

*/
trait Associative[A] {

    // (a • b) • c = a • (b • c)
    def associative(a: A, b: A, c: A)(binary: Binary[A]): Boolean = 
        binary(binary(a, b), c) == binary(a, binary(b, c))

}

object Associative {

    trait Ops[A]{
        def typeClassInstance: Associative[A]
        def target: A 
    }
    
}
