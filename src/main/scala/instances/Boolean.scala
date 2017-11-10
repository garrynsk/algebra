
package instances

import algebra.{ Ring, Semiring, AdditiveMonoid, MultiplicativeMonoid, AdditiveGroup, Category, Semicategory }

trait BooleanInstances extends  BooleanRing

trait BooleanRing {

    implicit def booleanRing: Ring[Boolean] = new Ring[Boolean] {

        override def zero: Boolean = false

        override def add(a: Boolean, b: Boolean): Boolean = a | b 

        override def one: Boolean = true

        override def mult(a: Boolean, b: Boolean): Boolean = a & b    

        override def negation(a: Boolean): Boolean = a match {
            case false => true
            case true => false
        } 

    }

}


trait BooleanSemiring {

    implicit def booleanSemiring: Semiring[Boolean] = new Semiring[Boolean] {

        override def zero: Boolean = false

        override def add(a: Boolean, b: Boolean): Boolean = a | b 

        override def one: Boolean = true

        override def mult(a: Boolean, b: Boolean): Boolean = a & b    

    }
}

trait BooleanAddMonoid  {

    implicit def booleanAddMonoid: AdditiveMonoid[Boolean] = new AdditiveMonoid[Boolean] {

        override def zero: Boolean = false

        override def add(a: Boolean, b: Boolean): Boolean = a | b 

    }

}

trait BooleanMultMonoid  {

    implicit def booleanMultMonoid: MultiplicativeMonoid[Boolean] = new MultiplicativeMonoid[Boolean] {

        override def one: Boolean = true

        override def mult(a: Boolean, b: Boolean): Boolean = a & b   

    }

}

trait BooleanAdditiveGroup  {

    implicit def booleanAddGroup: AdditiveGroup[Boolean] = new AdditiveGroup[Boolean] {

        override def zero: Boolean = false

        override def add(a: Boolean, b: Boolean): Boolean = a | b 

        override def negation(a: Boolean): Boolean = a match {
            case false => true
            case true => false
        } 

    }
}

trait BooleanCategory  {

    implicit def booleanCategory: Category[Boolean] = new Category[Boolean] {}
    
}

trait BooleanSemicategory  {

    implicit def booleanSemicategory: Semicategory[Boolean] = new Semicategory[Boolean] {}
    
}