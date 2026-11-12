# Dependency audit

The foundation was inspected statically on 2026-11-12 across Gradle build files, the version catalog, and application source. No dependencies or plugins matching advertising, AdMob, analytics, telemetry, crash reporting, Sentry, Bugsnag, App Center, Firebase, Google Play Services, or Google Services were found.

This is a source-level audit, not a resolved Gradle dependency report. CI compilation and a future lockfile or dependency-report review should be used to verify transitive dependencies.

The repository includes native image and EPUB reader components inherited from Komelia. They were not removed because they are part of the current reader foundation and are unrelated to advertising or telemetry.
