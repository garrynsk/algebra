
package algebra
package stones

import bricks.MultiplicativeInverse
import algebra.{ MultiplicativeMonoid, Group, Groupoid }

/**
    The trait contains operations for a MultiplicativeGroup typeclass. A multiplicative group is also a semicategory, 
    a category, a semigroup, an additive monoid, a groupoid and a group. 
    So an instance of the typeclass can be transformed to any of them.
*/
trait MultiplicativeGroupComponent[A] extends MultiplicativeInverse[A] with MultiplicativeMonoidComponent[A] { self =>

    def divide(a: A, b: A): A = mult(a, reciprocal(b))
    
    // An instance can be transformed to a groupoid
    def groupoid: Groupoid[A] = new Groupoid{

        override def id(a: A): A = self.id(a)

        override def inverse(a: A): A = self.reciprocal(a)

    }

    // An instance can be transformed to a multiplicative monoid
    def multiplicativeMonoid: MultiplicativeMonoid[A] = new MultiplicativeMonoid{

        override def one: A = self.one

        override def id(a: A): A = self.id(a)

        override def mult(a: A, b: A): A = self.mult(a, b)

    }

    // An instance can be transformed to a group
    def group: Group[A] = new Group{

        override def id: A = self.one

        override def id(a: A): A = self.id(a)

        override def inverse(a: A): A = self.reciprocal(a)

        override def combine(a: A, b: A): A = self.mult(a, b)

    }
}

object MultiplicativeGroupComponent {

    trait Ops[A] extends MultiplicativeInverse.Ops[A] with MultiplicativeMonoidComponent.Ops[A] {

        def typeClassInstance: MultiplicativeGroupComponent[A]
        def target: A
        
        // An alias for the operation 'divide'
        def |/|(b: A): A = typeClassInstance.divide(target,b)

    }
    
}
