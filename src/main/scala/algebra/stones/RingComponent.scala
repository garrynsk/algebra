
package algebra
package stones

/**
    The trait contains operations for a Ring typeclass. A ring is also a semicategory, 
    a category, a semigroup, an additive monoid, a multiplicative monoid and a semiring. 
    So an instance of the typeclass can be transformed to any of them.
*/
trait RingComponent[A] extends SemiringComponent[A] with AdditiveGroupComponent[A]

object RingComponent {

    trait Ops[A] extends SemiringComponent.Ops[A] with AdditiveGroupComponent.Ops[A]{

        def typeClassInstance: RingComponent[A]
        def target: A
   
    }
}
