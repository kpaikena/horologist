/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.horologist.datalayer.sample.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import com.google.android.horologist.compose.layout.ScalingLazyColumn
import com.google.android.horologist.compose.layout.ScalingLazyColumnState
import com.google.android.horologist.compose.layout.belowTimeTextPreview
import com.google.android.horologist.compose.material.Chip
import com.google.android.horologist.compose.material.Title
import com.google.android.horologist.datalayer.sample.R
import com.google.android.horologist.datalayer.sample.Screen

@Composable
fun MainScreen(
    navigateToRoute: (String) -> Unit,
    modifier: Modifier = Modifier,
    columnState: ScalingLazyColumnState,
) {
    ScalingLazyColumn(
        columnState = columnState,
        modifier = modifier.fillMaxSize(),
    ) {
        item {
            Title(stringResource(id = R.string.main_menu_datalayer_header))
        }

        item {
            Chip(
                label = stringResource(id = R.string.main_menu_datalayer_item),
                modifier = Modifier.fillMaxWidth(),
                onClick = { navigateToRoute(Screen.DataLayerScreen.route) },
            )
        }

        item {
            Chip(
                label = stringResource(id = R.string.main_menu_datalayer_nodes),
                modifier = Modifier.fillMaxWidth(),
                onClick = { navigateToRoute(Screen.DataLayerNodes.route) },
            )
        }
    }
}

@Suppress("unused")
@WearPreviewDevices
@Composable
fun MainScreenPreview() {
    MainScreen(
        navigateToRoute = {},
        columnState = belowTimeTextPreview(),
    )
}