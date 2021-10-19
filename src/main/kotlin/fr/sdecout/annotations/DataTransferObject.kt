package fr.sdecout.annotations

import java.lang.annotation.Inherited
import kotlin.annotation.AnnotationTarget.CLASS

/**
 * Marks object as a Data Transfer Object (DTO).
 *
 * A DTO is an object that is used solely to carry data between processes.
 *
 * @see <a href="http://en.wikipedia.org/wiki/Data_transfer_object">Wikipedia</a>
 */
@Inherited
@MustBeDocumented
@Target(CLASS)
annotation class DataTransferObject
