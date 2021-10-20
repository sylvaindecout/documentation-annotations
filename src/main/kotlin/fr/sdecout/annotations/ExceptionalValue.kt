package fr.sdecout.annotations

import java.lang.annotation.Inherited

/**
 * Represents an exceptional value.
 *
 * This pattern is used to either absorb all messages or produce meaningless behavior (another pattern).
 *
 * @see <a href="http://c2.com/ppr/checks.html">The CHECKS Pattern Language of Information Integrity, by Ward Cunningham</a>
 */
@Inherited
@MustBeDocumented
annotation class ExceptionalValue
