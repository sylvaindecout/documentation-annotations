package fr.sdecout.annotations

import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.reflect.KClass

/**
 * Marks this class as an implementation of Builder design pattern.
 *
 * Strategy is a creational pattern defined by GoF in *Design Patterns: Elements of Reusable Object-Oriented Software*.
 *
 * @see <a href="https://refactoring.guru/design-patterns/builder">Refactoring.Guru</a>
 */
@MustBeDocumented
@Target(CLASS)
annotation class Builder(val value: KClass<*>)
