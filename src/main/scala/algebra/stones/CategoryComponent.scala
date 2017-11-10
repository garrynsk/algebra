
package algebra
package stones

import algebra.Semicategory
import bricks.Identity

/**
    The trait contains operations for a Category typeclass. A category is also a semicategory, 
    so an instance of the typeclass can be transformed to it.
*/
trait CategoryComponent[A] extends SemicategoryComponent[A] with Identity[A] {

    // An instance can be transformed to a semicategory
    def semicategory: Semicategory[A] = new Semicategory{}

}

object CategoryComponent {

    trait Ops[A] extends SemicategoryComponent.Ops[A] with Identity.Ops[A] {

        def typeClassInstance: CategoryComponent[A]
        def target: A
        
    }
    
}

