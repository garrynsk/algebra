
package bricks

import Binary._

/**
    The trait contains a binary operation, which is necessary for any algebra implementation. 
    In most cases it is requered to be associative.
    
    This particulat trait can be used for multiplicative operations, such as integer multiplication.

*/
trait MultiplicativeOperation[A] {
    
    def mult(a: A, b: A): A
     
}

object MultiplicativeOperation {
 
    trait Ops[A] {

        def typeClassInstance: MultiplicativeOperation[A]
        def target: A 

            // An alias for the operation 'mult'
            def |*|(b: A): A = typeClassInstance.mult(target, b)

    }
    
}
