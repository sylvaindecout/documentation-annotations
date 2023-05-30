package fr.sdecout.annotations

import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.reflect.KClass

/**
 * Marks this class as an implementation of Adapter design pattern.
 *
 * Adapter is a structural pattern defined by GoF in *Design Patterns: Elements of Reusable Object-Oriented Software*.
 *
 * @see <a href="https://refactoring.guru/design-patterns/adapter">Refactoring.Guru</a>
 */
@MustBeDocumented
@Target(CLASS)
annotation class Adapter(val targetType: KClass<*>, val adaptee: KClass<*>)
