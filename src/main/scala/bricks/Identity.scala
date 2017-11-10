
package bricks

/**
    The trait contains the identity law: 

    For every object x, there exists a morphism id : x → x called the identity morphism for x, 
    such that for every morphism f : a → b, we have id ∘ f = f = f ∘ id.

    It is used to prove that an algebra is actually a category. 

*/
trait Identity[A] extends Composition[A] {

    def id(a: A): A = a

    // id ∘ f = f
    def unitLeft(a: A)(f: A => A): Boolean = 
        compose(f)(id)(a) == f(a)

    // f ∘ id = f
    def unitRight(a: A)(f: A => A): Boolean = 
        andThen(f)(id)(a) == f(a)
    
    // id ∘ f = f ∘ id
    def identity(a: A)(f: A => A): Boolean =
        unitLeft(a)(f) == unitRight(a)(f)
        
}

object Identity {
     trait Ops[A] {

        def typeClassInstance: Identity[A]
        def target: A 
    }
}
