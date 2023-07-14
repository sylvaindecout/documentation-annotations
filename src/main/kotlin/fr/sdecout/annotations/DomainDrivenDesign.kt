package fr.sdecout.annotations

import java.lang.annotation.Inherited
import kotlin.annotation.AnnotationTarget.*
import kotlin.reflect.KClass

/**
 * Domain-Driven Design is an approach to the development of complex software in which we:
 *
 * * Focus on the core domain.
 * * Explore models in a creative collaboration of domain practitioners and software practitioners.
 * * Speak a ubiquitous language within an explicitly bounded context.</li>
 *
 * @see <a href="https://www.domainlanguage.com/product/domain-driven-design-reference">Definitions and Pattern
 * Summaries, by Eric Evans</a>
 */
object DomainDrivenDesign {

    /**
     * When creation of an entire, internally consistent aggregate, or a large value object, becomes complicated or
     * reveals too much of the internal structure, factories provide encapsulation.
     *
     * Creation of an object can be a major operation in itself, but complex assembly operations do not fit the
     * responsibility of the created objects. Combining such responsibilities can produce ungainly designs that are
     * hard to understand. Making the client direct construction muddies the design of the client, breaches
     * encapsulation of the assembled object or aggregate, and overly couples the client to the implementation of the
     * created object.
     *
     * Therefore:
     *
     * **Shift the responsibility for creating instances of complex objects and aggregates to a separate object, which
     * may itself have no responsibility in the domain model but is still part of the domain design. Provide an
     * interface that encapsulates all complex assembly and that does not require the client to reference the concrete
     * classes of the objects being instantiated. Create an entire aggregate as a piece, enforcing its invariants.
     * Create a complex value object as a piece, possibly after assembling the elements with a builder.**
     */
    @MustBeDocumented
    @Target(CLASS)
    annotation class Factory(val value: KClass<*>)

    /**
     * *Query access to aggregates expressed in the ubiquitous language.*
     *
     * Proliferation of traversable associations used only for finding things muddles the model. In mature models,
     * queries often express domain concepts. Yet queries can cause problems.
     *
     * The sheer technical complexity of applying most database access infrastructure quickly swamps the client code,
     * which leads developers to dumb-down the domain layer, which makes the model irrelevant.
     *
     * A query framework may encapsulate most of that technical complexity, enabling developers to pull the exact data
     * they need from the database in a more automated or declarative way, but that only solves part of the problem.
     *
     * Unconstrained queries may pull specific fields from objects, breaching encapsulation, or instantiate a few
     * specific objects from the interior of an aggregate, blindsiding the aggregate root and making it impossible for
     * these objects to enforce the rules of the domain model. Domain logic moves into queries and application layer
     * code, and the entities and value objects become mere data containers.
     *
     * Therefore:
     *
     * **For each type of aggregate that needs global access, create a service that can provide the illusion of an
     * in-memory collection of all objects of that aggregate’s root type. Set up access through a well-known global
     * interface. Provide methods to add and remove objects, which will encapsulate the actual insertion or removal of
     * data in the data store. Provide methods that select objects based on criteria meaningful to domain experts.
     * Return fully instantiated objects or collections of objects whose attribute values meet the criteria, thereby
     * encapsulating the actual storage and query technology, or return proxies that give the illusion of fully
     * instantiated aggregates in a lazy way. Provide repositories only for aggregate roots that actually need direct
     * access. Keep application logic focused on the model, delegating all object storage and access to the
     * repositories.**
     */
    @MustBeDocumented
    @Target(CLASS)
    annotation class Repository(val value: KClass<*>)

    /**
     * Sometimes, it just isn’t a thing.
     *
     * Some concepts from the domain aren’t natural to model as objects. Forcing the required domain functionality to
     * be the responsibility of an entity or value either distorts the definition of a model-based object or adds
     * meaningless artificial objects.
     *
     * Therefore:
     *
     * **When a significant process or transformation in the domain is not a natural responsibility of an entity or
     * value object, add an operation to the model as a standalone interface declared as a service. Define a service
     * contract, a set of assertions about interactions with the service. (See assertions.) State these assertions in
     * the ubiquitous language of a specific bounded context. Give the service a name, which also becomes part of the
     * ubiquitous language.**
     */
    @MustBeDocumented
    @Target(CLASS)
    annotation class Service

    /**
     * Many objects represent a thread of continuity and identity, going through a lifecycle, though their attributes
     * may change.
     *
     * Some objects are not defined primarily by their attributes. They represent a thread of identity that runs
     * through time and often across distinct representations. Sometimes such an object must be matched with another
     * object even though attributes differ. An object must be distinguished from other objects even though they might
     * have the same attributes. Mistaken identity can lead to data corruption.
     *
     * Therefore:
     *
     * **When an object is distinguished by its identity, rather than its attributes, make this primary to its
     * definition in the model. Keep the class definition simple and focused on life cycle continuity and identity.
     *
     * Define a means of distinguishing each object regardless of its form or history. Be alert to requirements that
     * call for matching objects by attributes. Define an operation that is guaranteed to produce a unique result for
     * each object, possibly by attaching a symbol that is guaranteed unique. This means of identification may come
     * from the outside, or it may be an arbitrary identifier created by and for the system, but it must correspond to
     * the identity distinctions in the model.
     *
     * The model must define what it means to be the same thing.**
     */
    @Inherited
    @MustBeDocumented
    @Target(CLASS)
    annotation class Entity {
        @Inherited
        @MustBeDocumented
        @Target(FIELD, PROPERTY, FUNCTION)
        annotation class Id
    }

    /**
     * Some objects describe or compute some characteristic of a thing.
     *
     * Many objects have no conceptual identity.
     *
     * Tracking the identity of entities is essential, but attaching identity to other objects can hurt system
     * performance, add analytical work, and muddle the model by making all objects look the same. Software design is
     * a constant battle with complexity. We must make distinctions so that special handling is applied only where
     * necessary.
     *
     * However, if we think of this category of object as just the absence of identity, we haven’t added much to our
     * toolbox or vocabulary. In fact, these objects have characteristics of their own, and their own significance to
     * the model. These are the objects that describe things.
     *
     * Therefore:
     *
     * **When you care only about the attributes and logic of an element of the model, classify it as a value object.
     * Make it express the meaning of the attributes it conveys and give it related functionality. Treat the value
     * object as immutable. Make all operations Side-effect-free Functions that don’t depend on any mutable state.
     * Don’t give a value object any identity and avoid the design complexities necessary to maintain entities.**
     *
     * @see <a href="http://martinfowler.com/bliki/ValueObject.html">martinFowler.com</a>
     */
    @Inherited
    @MustBeDocumented
    @Target(CLASS)
    annotation class ValueObject

    /**
     * It is difficult to guarantee the consistency of changes to objects in a model with complex associations. Objects
     * are supposed to maintain their own internal consistent state, but they can be blindsided by changes in other
     * objects that are conceptually constituent parts. Cautious database locking schemes cause multiple users to
     * interfere pointlessly with each other and can make a system unusable. Similar issues arise when distributing
     * objects among multiple servers, or designing asynchronous transactions.
     *
     * Therefore:
     *
     * **Cluster the entities and value objects into aggregates and define boundaries around each. Choose one entity to
     * be the root of each aggregate, and allow external objects to hold references to the root only (references to
     * internal members passed out for use within a single operation only). Define properties and invariants for the
     * aggregate as a whole and give enforcement responsibility to the root or some designated framework mechanism.**
     *
     * Use the same aggregate boundaries to govern transactions and distribution. Within an aggregate boundary, apply
     * consistency rules synchronously. Across boundaries, handle updates asynchronously.
     *
     * Keep an aggregate together on one server. Allow different aggregates to be distributed among nodes.
     *
     * When these design decisions are not being guided well by the aggregate boundaries, reconsider the model. Is the
     * domain scenario hinting at an important new insight? Such changes often improve the model’s expressiveness and
     * flexibility as well as resolving the transactional and distributional issues.
     */
    @Entity
    @Inherited
    @MustBeDocumented
    @Target(CLASS)
    annotation class AggregateRoot

}
