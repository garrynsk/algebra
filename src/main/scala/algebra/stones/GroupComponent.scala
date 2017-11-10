
package algebra
package stones

import algebra.{ Category, Groupoid, Monoid }

/**
    The trait contains operations for a Group typeclass. A group is also a semicategory, a groupoid, 
    a monoid, a semigroup and a category. So an instance of the typeclass can be transformed to any of them.
*/
trait GroupComponent[A] extends GroupoidComponent[A] with MonoidComponent[A] { self =>

    def remove(a: A, b: A): A = combine(a, inverse(b))
    
    // An instance can be transformed to a category
    override def category: Category[A] = new Category{

        override def id(a: A): A = self.id(a)

    }

    // An instance can be transformed to a groupoid
    def groupoid: Groupoid[A] = new Groupoid{

        override def id(a: A): A = self.id(a)

        override def inverse(a: A): A = self.inverse(a)

    }

    // An instance can be transformed to a monoid
    def monoid: Monoid[A] = new Monoid{

        override def id: A = self.id

        override def id(a: A): A = self.id(a)

        override def combine(a: A, b: A): A = self.combine(a, b)

    }
}

object GroupComponent {

    trait Ops[A] extends GroupoidComponent.Ops[A] with MonoidComponent.Ops[A] {

        def typeClassInstance: GroupComponent[A]
        def target: A

    }
    
}


