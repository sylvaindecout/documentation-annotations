# Documentation annotations

[![Gitmoji](https://img.shields.io/badge/gitmoji-%20%F0%9F%98%9C%20%F0%9F%98%8D-FFDD67.svg)](https://gitmoji.dev)

## About

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

## Release

1. Increment version in `build.properties` (eg. `version=0.1.4`)
2. Push commit (eg. `:bookmark: Increment version from 0.1.3 to 0.1.4`)
3. Create a new release
   1. Create a new tag (eg. `v0.1.4-alpha`)
   2. Set release title (eg. `v0.1.4-alpha`)
   3. Auto-generate release notes
   4. Mark as a pre-release
   5. Publish release
4. Wait for GitHub Actions pipeline (automatically started) to complete
