# Documentation annotations

This library defines annotations that can be used to document code, with the goal to make concepts explicit and to provide a quick way to find out more about them.

You can check out [Cyril Martraire](https://twitter.com/cyriux) 's book, [Living Documentation: Continuous Knowledge Sharing by Design](http://informit.com/livingdoc), to understand better the general approach.

## Usage

:warning: Access to `https://maven.pkg.github.com/sylvaindecout/documentation-annotations` repository requires proper credentials.

### Maven
```
<dependency>
   <groupId>fr.sdecout.annotations</groupId>
   <artifactId>documentation-annotations</artifactId>
   <version>${documentation-annotations.version}</version>
</dependency>
```
Maven settings need to enable access to `https://maven.pkg.github.com/sylvaindecout/documentation-annotations` repository.

### Gradle
```
implementation("fr.sdecout.annotations", "documentation-annotations", documentation_annotations_version)
```

```
repositories {
    [...]
    maven {
        url = uri("https://maven.pkg.github.com/sylvaindecout/documentation-annotations")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
        }
    }
}
```
