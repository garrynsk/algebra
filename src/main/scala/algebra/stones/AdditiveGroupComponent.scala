
package algebra
package stones

import bricks.AdditiveInverse
import algebra.{ AdditiveMonoid, Group, Groupoid }

/**
    The trait contains operations for an AdditiveGroup typeclass. An additive group is also a semicategory, 
    a category, a semigroup, an additive monoid, a groupoid and a group. 
    So an instance of the typeclass can be transformed to any of them.
*/
trait AdditiveGroupComponent[A] extends AdditiveInverse[A] with AdditiveMonoidComponent[A] { self =>

    def substract(a: A, b: A): A = add(a, negation(b))

    // An instance can be transformed to a groupoid
    def groupoid: Groupoid[A] = new Groupoid {

        override def id(a: A): A = self.id(a)

        override def inverse(a: A): A = self.negation(a)

    }

    // An instance can be transformed to an additive monoid
    def additiveMonoid: AdditiveMonoid[A] = new AdditiveMonoid{

        override def zero: A = self.zero

        override def id(a: A): A = self.id(a)

        override def add(a: A, b: A): A = self.add(a, b)

    }

    // An instance can be transformed to a group
    def group: Group[A] = new Group{

        override def id: A = self.zero

        override def id(a: A): A = self.id(a)

        override def inverse(a: A): A = self.negation(a)

        override def combine(a: A, b: A): A = self.add(a, b)

    }
    
}

object AdditiveGroupComponent {

    trait Ops[A] extends AdditiveInverse.Ops[A] with AdditiveMonoidComponent.Ops[A] {

        def typeClassInstance: AdditiveGroupComponent[A]
        def target: A
        
        // An alias for the operation 'substract'
        def |-|(b: A): A = typeClassInstance.substract(target,b)
        
    }
    
}
