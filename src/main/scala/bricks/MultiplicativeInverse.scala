
package bricks

import Binary._

/**
    The trait contains the inverse law for multiplicative algebras: 

    Suppose that S is a set and • is some binary operation S × S → S.
    For each a in S, there exists an element b in S, commonly denoted a^(−1) (or −a, if the operation is denoted "+"), 
    such that a • b = b • a = e, where e is the identity element.

    It contains a renamed inverse for distinction of multiplicative instances from neutral ones. 
    It is used in MultiplicativeGroups.

    Useful in case when data can be removed from a structure. 

*/
trait MultiplicativeInverse[A] {

    def reciprocal(a: A): A 
    
    // a^(-1) |*| a = id
    def leftReciprocal(a: A)(binary: Binary[A]): Boolean =
        binary(reciprocal(a), a) == binary(a, reciprocal(a))
    
    // a |*| a^(-1) = id
    def rightReciprocal(a: A)(binary: Binary[A]): Boolean =
        binary(reciprocal(a), a) == binary(a, reciprocal(a))

}

object MultiplicativeInverse {

    trait Ops[A] {

        def typeClassInstance: MultiplicativeInverse[A]
        def target: A

    }
}