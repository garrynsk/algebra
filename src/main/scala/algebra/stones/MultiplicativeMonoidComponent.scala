
package algebra
package stones

import bricks.Binary._
import bricks.{ MultiplicativeIdentity, MultiplicativeOperation }
import algebra.{ Semigroup, Monoid }

/**
    The trait contains operations for a MultiplicativeMonoid typeclass. A multiplicative monoid is also a monoid,
    a semigroup, a category and a semicategory. So an instance of the typeclass can be transformed to any of them.
*/
trait MultiplicativeMonoidComponent[A] extends CategoryComponent[A] with MultiplicativeIdentity[A] with MultiplicativeOperation[A]{ self =>

    // An instance can be transformed to a semigroup
    /** A trait SemiringComponent inherits this trait and a AdditiveMonoid trait.
        Both of them can be transformed to a semigroup. So we have to give them different names, 
        otherwise SemiringComponent will contain two conflicting methods. 
    */
    def multSemigroup: Semigroup[A] = new Semigroup{

        override def combine(a: A, b: A): A = self.mult(a, b)

    }

    // An instance can be transformed to a monoid
    // Same thing is with the monoid. 
    def addMonoid: Monoid[A] = new Monoid {

        override def id: A = self.one

        override def id(a: A): A = self.id(a)

        override def combine(a: A, b: A): A = self.mult(a, b)
        
    }

}

object MultiplicativeMonoidComponent {

    trait Ops[A] extends CategoryComponent.Ops[A] with MultiplicativeIdentity.Ops[A] with MultiplicativeOperation.Ops[A] {

        def typeClassInstance: MultiplicativeMonoidComponent[A]
        def target: A

    }
    
}
