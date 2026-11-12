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

## Built-in catalog

Gunita opens on a built-in catalog of ten Blender Foundation open-film entries. The catalog keeps titles, descriptions, credits, license proof links, source pages, stream URLs, and verified size limits in the app. Media is streamed from the original Internet Archive host; Gunita does not rehost it. See [CONTENT_LICENSES.md](CONTENT_LICENSES.md) for the complete item list and proof links.

The catalog is enabled by default and can be used without a Jellyfin or Komga server. Selecting **Play** opens the original HTTPS stream with the platform URI handler. The hosting service can see the device IP address. An optional **Add Jellyfin/Komga server** entry keeps the existing server login flow available.

Manga entries, server settings for disabling the catalog, and an in-app video player are deferred. Contributions for new entries should follow [CONTRIBUTING.md](CONTRIBUTING.md).

## License and credits

Gunita is distributed under the Apache License, Version 2.0. The repository retains the upstream `LICENSE` file and applicable third-party notices. Gunita credits and builds on [Komelia](https://github.com/Snd-R/Komelia) by Snd-R and its contributors.
