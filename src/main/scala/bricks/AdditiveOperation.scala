
package bricks

import Binary._

/**
    The trait contains a binary operation, which is necessary for any algebra implementation. 
    In most cases it is requered to be associative.
    
    This particulat trait can be used for additive operations, such as List concatenation or 
    integer addition.

*/
trait AdditiveOperation[A] {
    
    def add(a: A, b: A): A
     
}

object AdditiveOperation {

    trait Ops[A] {

        def typeClassInstance: AdditiveOperation[A]
        def target: A 

            // An alias for the operation 'add'
            def |+|(b: A): A = typeClassInstance.add(target, b)
    }
}
