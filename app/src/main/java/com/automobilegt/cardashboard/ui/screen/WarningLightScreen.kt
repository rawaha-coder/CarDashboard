/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/10/24, 11:09 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/10/24, 11:09 PM
 */

package com.automobilegt.cardashboard.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.automobilegt.cardashboard.ui.screen.components.TopAppBarContent
import com.automobilegt.cardashboard.ui.screen.components.WarningLightItem
import com.automobilegt.cardashboard.ui.theme.PurpleLeft
import com.automobilegt.cardashboard.ui.theme.PurpleRight
import com.automobilegt.cardashboard.ui.viewmodel.WarningLightViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WarningLightScreen(
    viewModel: WarningLightViewModel
) {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
            state = rememberTopAppBarState()
        )

    Box(
        modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    PurpleLeft,
                    PurpleRight
                )
            )
        )
    ) {
        Scaffold(
            topBar = {
                TopAppBarContent(scrollBehavior = scrollBehavior)
            },
            bottomBar = {
                BottomAppBarContent(viewModel = viewModel)
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                MiddleAppContent(viewModel = viewModel)
            }
        }
    }
}


@Composable
fun MiddleAppContent(
    viewModel: WarningLightViewModel
) {
    val warningLightsState = viewModel.warningLights.collectAsState()

    warningLightsState.value.data?.let { warningLights ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 4.dp, start = 4.dp, end = 4.dp, bottom = 4.dp)
        )
        {
            items(warningLights) { warningLight ->
                WarningLightItem(warningLight, bookmark = {
                    id, bookmarked -> viewModel.updateBookmarkStatus(id, bookmarked)
                 }
                )
            }
        }
    }
}



@Composable
fun BottomAppBarContent(viewModel: WarningLightViewModel){

    var selected by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar (
    ){
        bottomNavItemList.forEachIndexed {index, bottomNavItem ->

            NavigationBarItem(
                selected = index == selected,
                onClick = {
                    selected = index
                    if (index == 0){
                        viewModel.loadWarningLights()
                    }else if(index == 1){
                        viewModel.getBookmarkedWarningLight()
                    }
                },
                icon = {
                    Icon(
                        imageVector =
                        if(index == selected)
                            bottomNavItem.selectedIcon
                        else
                            bottomNavItem.unselectedIcon,
                        contentDescription = "${bottomNavItem.title} page"
                    )
                }
            )
        }
    }
}

val bottomNavItemList = listOf(
    BottomNavItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        isSelected = false
    ),
    BottomNavItem(
        title = "Bookmark",
        selectedIcon = Icons.Filled.Bookmarks,
        unselectedIcon = Icons.Outlined.Bookmarks,
        isSelected = false
    ),
)

data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    var isSelected: Boolean
)

