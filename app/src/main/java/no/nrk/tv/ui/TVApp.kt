package no.nrk.tv.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import no.nrk.tv.ui.direct.DirectScreen
import no.nrk.tv.ui.theme.TvTheme
import org.koin.androidx.compose.KoinAndroidContext

@Composable
fun TvApp() {
    TvTheme {
        KoinAndroidContext {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                DirectScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}
