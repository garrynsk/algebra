
package bricks

/**
    The trait contains the associativity law for functions: 

    Suppose that S is a set and ∘ is some binary operation S × S → S.
    For every three objects a, b and c if f : a → b, g : b → c and h : c → d then 
    h ∘ (g ∘ f) = (h ∘ g) ∘ f.

    The law is applied to every algebra.

*/
trait Composition[A] {

    def compose[A, B, C](f: B => C)(g: A => B): A => C = f compose g 

    def andThen[A, B, C](f: A => B)(g: B => C): A => C = f andThen g 
    
    // h ∘ (g ∘ f) = (h ∘ g) ∘ f
    def composition[B, C, D](a: D)(f: A => B, g: B => C, h: D => A): Boolean = 
        compose(compose(g)(f))(h)(a) == compose(g)(compose(f)(h))(a)

}

object Composition {
    
    trait Ops[A]{
        def typeClassInstance: Composition[A]
        def target: A 
        
    }
}
