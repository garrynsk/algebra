
package bricks

import Binary._

/**
    The trait contains the inverse law: 

    Suppose that S is a set and • is some binary operation S × S → S.
    For each a in S, there exists an element b in S, commonly denoted a^(−1) (or −a, if the operation is denoted "+"), 
    such that a • b = b • a = e, where e is the identity element.

    Useful in case when data can be removed from a structure. 

*/
trait Inverse[A] {

    def inverse(a: A): A 
    
    // a • b = e
    def leftInverse(a: A)(binary: Binary[A]): Boolean =
        binary(inverse(a), a) == binary(a, inverse(a))
    
    // b • a = e
    def rightInverse(a: A)(binary: Binary[A]): Boolean =
        binary(inverse(a), a) == binary(a, inverse(a))
}

object Inverse {

    trait Ops[A] {
        def typeClassInstance: Inverse[A]
        def target: A 
    }
    
}