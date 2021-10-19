package fr.sdecout.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Marks this package as using <b>Functional Core, Imperative Shell</b> architecture style, as defined by
 * <a href="https://twitter.com/garybernhardt">Gary Bernhardt</a>.
 *
 * @see <a href="https://www.destroyallsoftware.com/screencasts/catalog/functional-core-imperative-shell">Gary
 * Bernhardt's original article</a>
 */
@Documented
@Retention(RUNTIME)
@Target(PACKAGE)
public @interface FunctionalCoreImperativeShell {}
