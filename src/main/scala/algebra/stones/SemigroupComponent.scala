
package algebra
package stones

import bricks.{ Operation }
import algebra.Semicategory

/**
    The trait contains operations for a Semigroup typeclass. A semigroup is also a semicategory, 
    so an instance of the typeclass can be transformed to it.
*/
trait SemigroupComponent[A] extends SemicategoryComponent[A] with Operation[A] {

    def semicategory: Semicategory[A] = new Semicategory{}

}

object SemigroupComponent {

    trait Ops[A] extends SemicategoryComponent.Ops[A] with Operation.Ops[A]{

        def typeClassInstance: SemigroupComponent[A]
        def target: A

       
    }
    
}

