
package algebra
package stones

import bricks.Binary._
import bricks.Commutative


/**
    The trait contains operations for a Semiring typeclass. A semiring is also a semicategory, 
    a category, a semigroup, an additive monoid and a multiplicative monoid. 
    So an instance of the typeclass can be transformed to any of them.
*/
trait SemiringComponent[A] extends AdditiveMonoidComponent[A] with MultiplicativeMonoidComponent[A] with Commutative[A]{
    // TODO: move the law to a separate trait
    def annihilation(a: A): Boolean =
        mult(zero, a) == mult(a, zero) && mult(zero, a) == zero

}

object SemiringComponent {

    trait Ops[A] extends AdditiveMonoidComponent.Ops[A] with MultiplicativeMonoidComponent.Ops[A] {

        def typeClassInstance: SemiringComponent[A]
        def target: A
        
    }
    
}
