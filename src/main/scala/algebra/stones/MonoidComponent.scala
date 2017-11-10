
package algebra
package stones

import algebra.{ Category, Semicategory, Semigroup }

/**
    The trait contains operations for a Monoid typeclass. A monoid is also a semicategory, 
    a semigroup and a category. So an instance of the typeclass can be transformed to any of them.
*/
trait MonoidComponent[A] extends SemigroupComponent[A] with CategoryComponent[A] { self =>
    
    def id: A

    // An instance can be transformed to a semicategory
    override def semicategory: Semicategory[A] = new Semicategory{}

    // An instance can be transformed to a semigroup
    def semigroup: Semigroup[A] = new Semigroup{

        override def combine(a: A, b: A): A = self.combine(a, b)

    }

    // An instance can be transformed to a category
    def category: Category[A] = new Category{

        override def id(a: A): A = self.id(a)

    }
}

object MonoidComponent {

    trait Ops[A] extends SemigroupComponent.Ops[A] with CategoryComponent.Ops[A] {

        def typeClassInstance: MonoidComponent[A]
        def target: A
        
    }
    
}
