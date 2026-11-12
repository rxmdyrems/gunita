# Gunita

Gunita is a free, ad-free Android client for connecting to Jellyfin and Komga servers. It is a client only: it ships and hosts no content. You need your own server and valid credentials for the service you use.

The current foundation is imported from [Komelia](https://github.com/Snd-R/Komelia), including its Android reader, Komga integration, and upstream notices. Jellyfin support will be added incrementally.

## Build

The project requires JDK 17 or higher. Android and JVM targets also require a C/C++ compiler and Node.js for native libraries and EPUB reader assets. The upstream build uses Docker images with these dependencies.

Initialize submodules before building:

```sh
git clone --recurse-submodules https://github.com/rxmdyrems/gunita.git
cd gunita
./gradlew :androidDebug
```

See the Gradle files and upstream build configuration for architecture-specific tasks.

## License and credits

Gunita is distributed under the Apache License, Version 2.0. The repository retains the upstream `LICENSE` file and applicable third-party notices. Gunita credits and builds on [Komelia](https://github.com/Snd-R/Komelia) by Snd-R and its contributors.
