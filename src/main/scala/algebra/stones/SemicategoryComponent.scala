
package algebra
package stones

import bricks.{ Composition, Associative }

/**
    The trait contains operations for a Semicategory typeclass. 
*/
trait SemicategoryComponent[A] extends Composition[A] with Associative[A] 

object SemicategoryComponent {

    trait Ops[A] extends Composition.Ops[A] with Associative.Ops[A] {

        def typeClassInstance: SemicategoryComponent[A]
        def target: A
        
    }
    
}

