package snd.komelia.content

enum class CatalogItemType {
    MOVIE,
    ANIME,
    SERIES,
    MANGA,
}

data class CatalogItem(
    val id: String,
    val type: CatalogItemType,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val streamUrl: String?,
    val pageUrls: List<String>,
    val licenseSpdx: String,
    val licenseUrl: String,
    val authorCredit: String,
    val sourcePageUrl: String,
    val addedDate: String,
    val sizeBytes: Long,
)

interface ContentSource {
    suspend fun items(): List<CatalogItem>
}

class OpenCatalogSource(
    private val catalog: List<CatalogItem>,
) : ContentSource {
    override suspend fun items(): List<CatalogItem> = catalog.filter { item ->
        val stream = item.streamUrl ?: return@filter false
        val host = stream.substringAfter("https://").substringBefore('/')
        stream.startsWith("https://") &&
            host in setOf("archive.org", "www.archive.org") &&
            item.sizeBytes in 1..400_000_000L &&
            item.licenseSpdx in setOf("CC-BY-3.0", "CC-BY-4.0", "CC0-1.0")
    }
}

object BuiltInCatalog {
    val source: ContentSource = OpenCatalogSource(
        listOf(
            CatalogItem(
                id = "bigbuckbunnyshort",
                type = CatalogItemType.MOVIE,
                title = "Big Buck Bunny — short clip",
                description = "A short Big Buck Bunny clip from the Blender Foundation archive.",
                thumbnailUrl = "https://archive.org/services/img/bigbuckbunnyshort",
                streamUrl = "https://archive.org/download/bigbuckbunnyshort/bigbuckbunnyshort.ia.mp4",
                pageUrls = emptyList(),
                licenseSpdx = "CC-BY-4.0",
                licenseUrl = "https://creativecommons.org/licenses/by/4.0/",
                authorCredit = "Blender Foundation",
                sourcePageUrl = "https://archive.org/details/bigbuckbunnyshort",
                addedDate = "2026-11-12",
                sizeBytes = 2323454L,
            ),
            CatalogItem(
                id = "big-buck-bunny-full-hd",
                type = CatalogItemType.MOVIE,
                title = "Big Buck Bunny",
                description = "Big Buck Bunny, an open movie by the Blender Foundation.",
                thumbnailUrl = "https://archive.org/services/img/BigBuckBunnyFULLHD60FPS",
                streamUrl = "https://archive.org/download/BigBuckBunnyFULLHD60FPS/Big%20Buck%20Bunny%20-%20FULL%20HD%2060FPS.mp4",
                pageUrls = emptyList(),
                licenseSpdx = "CC-BY-3.0",
                licenseUrl = "https://creativecommons.org/licenses/by/3.0/",
                authorCredit = "Blender Foundation",
                sourcePageUrl = "https://archive.org/details/BigBuckBunnyFULLHD60FPS",
                addedDate = "2026-11-12",
                sizeBytes = 339489735L,
            ),
            CatalogItem(
                id = "big-buck-bunny-avchd",
                type = CatalogItemType.MOVIE,
                title = "Big Buck Bunny — AVCHD edition",
                description = "Big Buck Bunny from the Blender Foundation archive.",
                thumbnailUrl = "https://archive.org/services/img/BigBugBunny_AVCHD",
                streamUrl = "https://archive.org/download/BigBugBunny_AVCHD/bigBuckBunny_avchd_720p.mp4",
                pageUrls = emptyList(),
                licenseSpdx = "CC-BY-3.0",
                licenseUrl = "https://creativecommons.org/licenses/by/3.0/",
                authorCredit = "Blender Foundation",
                sourcePageUrl = "https://archive.org/details/BigBugBunny_AVCHD",
                addedDate = "2026-11-12",
                sizeBytes = 61808935L,
            ),
            CatalogItem(
                id = "sintel",
                type = CatalogItemType.ANIME,
                title = "Sintel",
                description = "Sintel, the third open movie by the Blender Foundation.",
                thumbnailUrl = "https://archive.org/services/img/sintel_20260427",
                streamUrl = "https://archive.org/download/sintel_20260427/sintel.mp4",
                pageUrls = emptyList(),
                licenseSpdx = "CC-BY-3.0",
                licenseUrl = "https://creativecommons.org/licenses/by/3.0/",
                authorCredit = "Blender Foundation",
                sourcePageUrl = "https://archive.org/details/sintel_20260427",
                addedDate = "2026-11-12",
                sizeBytes = 351974236L,
            ),
            CatalogItem(
                id = "elephants-dream",
                type = CatalogItemType.MOVIE,
                title = "Elephants Dream",
                description = "An open movie developed by the Blender Foundation.",
                thumbnailUrl = "https://archive.org/services/img/ElephantsDream_628",
                streamUrl = "https://archive.org/download/ElephantsDream_628/ElephantsDream_720p_DivXPlus_512kb.mp4",
                pageUrls = emptyList(),
                licenseSpdx = "CC-BY-3.0",
                licenseUrl = "https://creativecommons.org/licenses/by/3.0/",
                authorCredit = "Blender Foundation",
                sourcePageUrl = "https://archive.org/details/ElephantsDream_628",
                addedDate = "2026-11-12",
                sizeBytes = 73572293L,
            ),
            CatalogItem(
                id = "cosmos-laundromat",
                type = CatalogItemType.MOVIE,
                title = "Cosmos Laundromat: First Cycle",
                description = "On a desolate island, sheep Franck meets a salesman offering the gift of a lifetime.",
                thumbnailUrl = "https://archive.org/services/img/CosmosLaundromatFirstCycle",
                streamUrl = "https://archive.org/download/CosmosLaundromatFirstCycle/Cosmos%20Laundromat%20-%20First%20Cycle%20%281080p%29.mp4",
                pageUrls = emptyList(),
                licenseSpdx = "CC-BY-4.0",
                licenseUrl = "https://creativecommons.org/licenses/by/4.0/",
                authorCredit = "Blender Foundation",
                sourcePageUrl = "https://archive.org/details/CosmosLaundromatFirstCycle",
                addedDate = "2026-11-12",
                sizeBytes = 220087570L,
            ),
            CatalogItem(
                id = "caminandes-llama-drama",
                type = CatalogItemType.MOVIE,
                title = "Caminandes 1: Llama Drama",
                description = "The first episode of the Caminandes cartoon series.",
                thumbnailUrl = "https://archive.org/services/img/Caminandes1LlamaDrama",
                streamUrl = "https://archive.org/download/Caminandes1LlamaDrama/01_llama_drama_1080p.mp4",
                pageUrls = emptyList(),
                licenseSpdx = "CC-BY-3.0",
                licenseUrl = "https://creativecommons.org/licenses/by/3.0/",
                authorCredit = "Blender Foundation",
                sourcePageUrl = "https://archive.org/details/Caminandes1LlamaDrama",
                addedDate = "2026-11-12",
                sizeBytes = 35103580L,
            ),
            CatalogItem(
                id = "caminandes-gran-dillama",
                type = CatalogItemType.MOVIE,
                title = "Caminandes 2: Gran Dillama",
                description = "The second episode of the Caminandes cartoon series.",
                thumbnailUrl = "https://archive.org/services/img/Caminandes2GranDillama",
                streamUrl = "https://archive.org/download/Caminandes2GranDillama/02_gran_dillama_1080p.mp4",
                pageUrls = emptyList(),
                licenseSpdx = "CC-BY-3.0",
                licenseUrl = "https://creativecommons.org/licenses/by/3.0/",
                authorCredit = "Blender Foundation",
                sourcePageUrl = "https://archive.org/details/Caminandes2GranDillama",
                addedDate = "2026-11-12",
                sizeBytes = 125974946L,
            ),
            CatalogItem(
                id = "caminandes-llamigos",
                type = CatalogItemType.MOVIE,
                title = "Caminandes 3: Llamigos",
                description = "The third episode of the Caminandes cartoon series.",
                thumbnailUrl = "https://archive.org/services/img/CaminandesLlamigos",
                streamUrl = "https://archive.org/download/CaminandesLlamigos/Caminandes_%20Llamigos-1080p.mp4",
                pageUrls = emptyList(),
                licenseSpdx = "CC-BY-3.0",
                licenseUrl = "https://creativecommons.org/licenses/by/3.0/",
                authorCredit = "Blender Foundation",
                sourcePageUrl = "https://archive.org/details/CaminandesLlamigos",
                addedDate = "2026-11-12",
                sizeBytes = 138945811L,
            ),
            CatalogItem(
                id = "tears-of-steel",
                type = CatalogItemType.MOVIE,
                title = "Tears of Steel",
                description = "A live-action and visual-effects open movie from the Blender Foundation.",
                thumbnailUrl = "https://archive.org/services/img/Tears-of-Steel",
                streamUrl = "https://archive.org/download/Tears-of-Steel/tears_of_steel_720p.mp4",
                pageUrls = emptyList(),
                licenseSpdx = "CC-BY-3.0",
                licenseUrl = "https://creativecommons.org/licenses/by/3.0/",
                authorCredit = "Blender Foundation",
                sourcePageUrl = "https://archive.org/details/Tears-of-Steel",
                addedDate = "2026-11-12",
                sizeBytes = 76435802L,
            ),
        ),
    )
}
