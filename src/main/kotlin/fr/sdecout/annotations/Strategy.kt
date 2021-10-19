package fr.sdecout.annotations

import kotlin.annotation.AnnotationTarget.CLASS

/**
 * Marks this class as an implementation of Strategy design pattern.
 *
 * Strategy is a behavioral pattern defined by GoF in *Design Patterns: Elements of Reusable Object-Oriented Software*.
 *
 * @see <a href="https://refactoring.guru/design-patterns/strategy">Refactoring.Guru</a>
 */
@MustBeDocumented
@Target(CLASS)
annotation class Strategy
