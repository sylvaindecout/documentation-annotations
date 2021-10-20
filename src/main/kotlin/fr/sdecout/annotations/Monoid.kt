package fr.sdecout.annotations

import java.lang.annotation.Inherited
import kotlin.annotation.AnnotationTarget.FUNCTION

/**
 * Marks this operation as characteristic of a monoid.
 *
 * * Applies to a set
 * * Has closure of operation (ie. it takes said set as both input and output)
 * * Is associative - `(a•b)•c = a•(b•c)`
 * * Has a neutral element - `e•a=a and a•e=a`
 *
 * Monoids matter because they have composability, which helps scale in complexity.
 *
 * @see <a href="http://www.arolla.fr/blog/wp-content/uploads/2018/10/DomainModelingwithMonoids.pdf">Domain modeling with monoids</a>
 */
@Inherited
@MustBeDocumented
@Target(FUNCTION)
annotation class Monoid(val neutralElement: String)
