package fr.sdecout.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <i><p>Sharing a part of the model and associated code is a very intimate interdependency, which can leverage design
 * work or undermine it.</p></i>
 *
 * <p>When functional integration is limited, the overhead of continuous integration of a large context may be deemed
 * too high. This may especially be true when the team does not have the skill or the political organization to maintain
 * continuous integration, or when a single team is simply too big and unwieldy. So separate bounded contexts might be
 * defined and multiple teams formed.</p>
 *
 * <p>Once separate, uncoordinated teams working on closely related applications can go racing forward for a while, but
 * what they produce may not fit together. Even partner teams can end up spending a great deal on translation layers
 * and retrofitting, meanwhile duplicating effort and losing the benefits of a common ubiquitous language.</p>
 *
 * <b><p>Therefore: Designate with an explicit boundary some subset of the domain model that the teams agree to share.
 * Keep this kernel small.</p>
 *
 * <p>Within this boundary, include, along with this subset of the model, the subset of code or of the database design
 * associated with that part of the model. This explicitly shared stuff has special status, and should not be changed
 * without consultation with the other team.</p></b>
 *
 * <p>Define a continuous integration process that will keep the kernel model tight and align the ubiquitous language
 * of the teams. Integrate a functional system frequently, though somewhat less often than the pace of continuous
 * integration within the teams.</p>
 *
 * @see <a href="https://www.domainlanguage.com/product/domain-driven-design-reference">Definitions and Pattern
 * Summaries, by Eric Evans</a>
 */
@Documented
@Retention(RUNTIME)
@Target(PACKAGE)
public @interface SharedKernel {
}
