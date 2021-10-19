package fr.sdecout.annotations

import java.lang.annotation.Inherited
import kotlin.annotation.AnnotationTarget.TYPE

/**
 * The idea behind Hexagonal Architecture, aka Ports & Adapters Architecture, is to think about our application as the
 * central artefact of a system, where all input and output reaches/leaves the application through a port that isolates
 * the application from external tools, technologies and delivery mechanisms. The application should have no knowledge
 * of who/what is sending input or receiving its output. This is intended to provide some protection against the
 * evolution of technology and business requirements, which can make products obsolete shortly after they are developed,
 * because of technology/vendor lock-down.
 *
 * To put it simply, **it has only one goal: isolate the business logic from the delivery mechanisms and tools used by
 * the system.**
 *
 * @see <a href="https://herbertograca.com/2017/09/14/ports-adapters-architecture">Herberto Graca's article</a>
 */
object HexagonalArchitecture {

    /**
     * A port is a consumer agnostic entry and exit point to/from the application. In many languages, it will be an
     * interface. For example, it can be an interface used to perform searches in a search engine. In our application,
     * we will use this interface as an entry and/or exit point with no knowledge of the concrete implementation that
     * will actually be injected where the interface is defined as a type hint.
     */
    @MustBeDocumented
    @Target(TYPE)
    annotation class Port(val value: Type) {
        enum class Type {
            DRIVING, DRIVEN
        }
    }

    /**
     * In hexagonal architecture, left adapters are adapters that are used to call the domain.
     *
     * An adapter is a class that transforms (adapts) an interface into another.
     *
     * For example, an adapter implements an interface A and gets injected an interface B. When the adapter is
     * instantiated it gets injected in its constructor an object that implements interface B. This adapter is then
     * injected wherever interface A is needed and receives method requests that it transforms and proxies to the inner
     * object that implements interface B.
     */
    @Inherited
    @MustBeDocumented
    @Target(TYPE)
    annotation class LeftAdapter

    /**
     * In hexagonal architecture, right adapters are adapters that are called by the domain.
     *
     * An adapter is a class that transforms (adapts) an interface into another.
     *
     * For example, an adapter implements an interface A and gets injected an interface B. When the adapter is
     * instantiated it gets injected in its constructor an object that implements interface B. This adapter is then
     * injected wherever interface A is needed and receives method requests that it transforms and proxies to the inner
     * object that implements interface B.
     */
    @Inherited
    @MustBeDocumented
    @Target(TYPE)
    annotation class RightAdapter

}
