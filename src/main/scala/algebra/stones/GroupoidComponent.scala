
package algebra
package stones

import algebra.Category
import bricks.Inverse

/**
    The trait contains operations for a Groupoid typeclass. A groupoid is also a category and 
    a semicategory, so an instance of the typeclass can be transformed to both of them.
*/
trait GroupoidComponent[A] extends CategoryComponent[A] with Inverse[A] { self =>

    // An instance can be transformed to a category
    def category: Category[A] = new Category{

        override def id(a: A): A = self.id(a)

    }

}

object GroupoidComponent {

    trait Ops[A] extends CategoryComponent.Ops[A] with Inverse.Ops[A] {

        def typeClassInstance: GroupoidComponent[A]
        def target: A

    }
    
}


