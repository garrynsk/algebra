
package bricks

import Binary._

/**
    The trait contains the commutative law: 

    A binary operation • on a set S is called commutative if:
    x • y = y • x for all x, y in S

    Useful when it is unknown in which order an element will pass into an operation.. 

*/
trait Commutative[A] {

    // a • b = b • a
    def commutative(a: A, b: A)(binary: Binary[A]): Boolean = 
        binary(a, b) == binary(b, a)

}

object Commutative {
  
    trait Ops[A] {
        def typeClassInstance: Commutative[A]
        def target: A 
    }
    
}