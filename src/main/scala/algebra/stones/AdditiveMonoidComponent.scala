
package algebra
package stones

import bricks.Binary._
import bricks.{ AdditiveOperation, AdditiveIdentity }
import algebra.{ Monoid, Semigroup }

/**
    The trait contains operations for an AdditiveMonoid typeclass. An additive monoid is also a monoid,
    a semigroup, a category and a semicategory. So an instance of the typeclass can be transformed to any of them.
*/
trait AdditiveMonoidComponent[A] extends CategoryComponent[A] with AdditiveIdentity[A] with AdditiveOperation[A] { self =>
    
    // An instance can be transformed to a semigroup
    /** A trait SemiringComponent inherits this trait and a MultiplicativeMonoid trait.
        Both of them can be transformed to a semigroup. So we have to give them different names, 
        otherwise SemiringComponent will contain two conflicting methods. 
    */
    def addSemigroup: Semigroup[A] = new Semigroup{

        override def combine(a: A, b: A): A = add(a, b)

    }

    // An instance can be transformed to a monoid
    // Same thing is with the monoid. 
    def monoid: Monoid[A] = new Monoid {

        override def id: A = self.zero

        override def id(a: A): A = self.id(a)

        override def combine(a: A, b: A): A = self.add(a, b)
        
    }

}

object AdditiveMonoidComponent {

    trait Ops[A] extends CategoryComponent.Ops[A] with AdditiveIdentity.Ops[A] with AdditiveOperation.Ops[A] {

        def typeClassInstance: AdditiveMonoidComponent[A]
        def target: A

    }
    
}
