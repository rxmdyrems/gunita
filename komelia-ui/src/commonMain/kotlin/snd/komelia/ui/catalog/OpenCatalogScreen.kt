package snd.komelia.ui.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import snd.komelia.content.BuiltInCatalog
import snd.komelia.content.CatalogItem
import snd.komelia.content.ContentSource
import snd.komelia.ui.login.LoginScreen

class OpenCatalogScreen(
    private val source: ContentSource = BuiltInCatalog.source,
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var items by remember { mutableStateOf(emptyList<CatalogItem>()) }
        LaunchedEffect(source) { items = source.items() }
        val uriHandler = LocalUriHandler.current

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                Text("Gunita", style = MaterialTheme.typography.headlineLarge)
                Text(
                    "Built-in catalog",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 4.dp),
                )
                Text(
                    "Open-license films stream from their original hosts. A Jellyfin or Komga server is optional.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp),
                )
                Spacer(Modifier.height(8.dp))
                Button(onClick = { navigator.push(LoginScreen()) }) {
                    Text("Add Jellyfin/Komga server")
                }
                Text(
                    "Playing a catalog item contacts the hosting server, which can see your IP address.",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 8.dp),
                )
                HorizontalDivider(modifier = Modifier.padding(top = 16.dp))
            }
            items(items, key = { it.id }) { item ->
                CatalogCard(item = item, onPlay = { item.streamUrl?.let(uriHandler::openUri) })
            }
            item {
                TextButton(onClick = { navigator.push(ContentCreditsScreen(items)) }) {
                    Text("Content credits")
                }
            }
        }
    }
}

class ContentCreditsScreen(
    private val items: List<CatalogItem>,
) : Screen {
    @Composable
    override fun Content() {
        val uriHandler = LocalUriHandler.current
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            item { Text("Content credits", style = MaterialTheme.typography.headlineMedium) }
            items(items, key = { it.id }) { item ->
                Column(modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                    Text(item.title, style = MaterialTheme.typography.titleMedium)
                    Text("${item.authorCredit} · ${item.licenseSpdx}")
                    Row {
                        TextButton(onClick = { uriHandler.openUri(item.licenseUrl) }) { Text("License") }
                        TextButton(onClick = { uriHandler.openUri(item.sourcePageUrl) }) { Text("Source") }
                    }
                }
            }
        }
    }
}

@Composable
private fun CatalogCard(item: CatalogItem, onPlay: () -> Unit) {
    val uriHandler = LocalUriHandler.current
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(item.title, style = MaterialTheme.typography.titleLarge)
            Text(item.description, modifier = Modifier.padding(top = 6.dp))
            Text(
                "${item.authorCredit} · ${item.licenseSpdx}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 8.dp),
            )
            Row(modifier = Modifier.padding(top = 10.dp)) {
                Button(onClick = onPlay) { Text("Play") }
                Spacer(Modifier.padding(horizontal = 4.dp))
                TextButton(onClick = { uriHandler.openUri(item.licenseUrl) }) {
                    Text("License")
                }
                TextButton(onClick = { uriHandler.openUri(item.sourcePageUrl) }) {
                    Text("Source")
                }
            }
        }
    }
}
