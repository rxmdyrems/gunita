# Contributing

Gunita currently has a built-in open catalog and optional Jellyfin/Komga server support. Changes should preserve the client-only design and must not add scraping, third-party extensions, unlicensed mirrors, analytics, advertising, or rehosted media.

To propose a catalog entry, add the item to both `komelia-app/androidApp/src/main/assets/catalog/catalog.json` and `BuiltInCatalog` in `komelia-domain/core/src/commonMain/kotlin/snd/komelia/content/ContentSource.kt`. Use the source host’s own title and description. The item must be a movie, anime, series, or manga under CC BY, CC BY-SA, CC0, or public domain, and must exclude NC and ND terms.

Each entry needs an HTTPS stream or page URL, a license identifier and proof link on the item’s own page, an author or credit, a source page, an added date, and a size in bytes. Verify stream URLs with `HEAD`, require `200` and the correct media content type, and keep the size within the source-layer cap. Do not add a URL until its license and hosting provenance have been checked.

For code changes, use the existing Kotlin and Compose patterns. Run the GitHub Actions debug APK workflow and describe any unverified device behavior in the pull request.
