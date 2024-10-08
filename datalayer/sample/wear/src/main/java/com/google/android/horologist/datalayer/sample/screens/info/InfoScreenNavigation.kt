/*
 * Copyright 2023 The Android Open Source Project
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

@file:OptIn(ExperimentalFoundationApi::class)

package com.google.android.horologist.datalayer.sample.screens.info

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.wear.compose.navigation.composable
import com.google.android.horologist.compose.layout.ScalingLazyColumnDefaults.ItemType
import com.google.android.horologist.compose.layout.ScreenScaffold
import com.google.android.horologist.compose.layout.rememberResponsiveColumnState
import com.google.android.horologist.datalayer.sample.Screen
import java.net.URLDecoder
import java.net.URLEncoder

private const val messageArg = "message"
private const val routePrefix = "infoScreen"

private val URL_CHARACTER_ENCODING = Charsets.UTF_8.name()

const val infoScreenRoute = "$routePrefix/{$messageArg}"

internal class InfoScreenArgs(val message: String) {
    constructor(savedStateHandle: SavedStateHandle) :
        this(URLDecoder.decode(checkNotNull(savedStateHandle[messageArg]), URL_CHARACTER_ENCODING))
}

fun NavController.navigateToInfoScreen(message: String) {
    val encodedMessage = URLEncoder.encode(message, URL_CHARACTER_ENCODING)
    this.navigate("$routePrefix/$encodedMessage")
}

fun NavGraphBuilder.infoScreen(
    onDismissClick: () -> Unit,
) {
    composable(
        route = Screen.InfoScreen.route,
        arguments = listOf(
            navArgument(messageArg) { type = NavType.StringType },
        ),
    ) {
        val columnState = rememberResponsiveColumnState(first = ItemType.Unspecified, last = ItemType.Unspecified)

        ScreenScaffold(scrollState = columnState) {
            InfoScreen(
                onDismissClick = onDismissClick,
                columnState = columnState,
            )
        }
    }
}
