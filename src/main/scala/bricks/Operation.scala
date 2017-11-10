
package bricks

import Binary._

/**
    The trait contains a neutrally named binary operation, which is necessary for any algebra implementation. 
    In most cases it is requered to be associative.

*/
trait Operation[A] {
    
    def combine(a: A, b: A): A
     
}

object Operation {

    trait Ops[A] {

        def typeClassInstance: Operation[A]
        def target: A

            // An alias for the operation 'combine'
            def <:>(b: A): A = typeClassInstance.combine(target, b)

    }
}
