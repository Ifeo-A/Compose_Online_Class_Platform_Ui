package com.ife_a.compose_online_class_platform_ui.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ife_a.compose_online_class_platform_ui.destinations.DestinationClassDetail
import com.ife_a.compose_online_class_platform_ui.destinations.DestinationHome
import com.ife_a.compose_online_class_platform_ui.destinations.DestinationVideo
import com.ife_a.compose_online_class_platform_ui.navigation.NavigationHelper.DestinationArguments.CLASS_ID
import com.ife_a.compose_online_class_platform_ui.navigation.NavigationHelper.DestinationArguments.NAV_BAR_PADDING
import com.ife_a.compose_online_class_platform_ui.navigation.NavigationHelper.DestinationArguments.VIDEO_ID

object NavigationHelper {

    object DestinationArguments {
        const val CLASS_ID = "classId"
        const val VIDEO_ID = "videoId"
        const val NAV_BAR_PADDING = "navBarPadding"
    }

    sealed class Destinations(val route: String) {
        object DestinationHome : Destinations(route = "destinationHome")
        object DestinationClassDetail :
            Destinations(route = "destinationClassDetail/{$CLASS_ID}/{${NAV_BAR_PADDING}}") {

            fun supplyArguments(classId: String, navBarPadding: Int): String {
                return this.route
                    .replace("{$CLASS_ID}", classId)
                    .replace("{$NAV_BAR_PADDING}", navBarPadding.toString())
            }
        }

        object DestinationVideo :
            Destinations(route = "destinationVideo/{$VIDEO_ID}/{${NAV_BAR_PADDING}}") {

            fun supplyArguments(videoId: String, navBarPadding: Int): String {
                return this.route
                    .replace("{$VIDEO_ID}", videoId)
                    .replace("{$NAV_BAR_PADDING}", navBarPadding.toString())
            }
        }
    }

    @Composable
    fun SetupNavGraph(navController: NavHostController, navBarPadding: Int) {

        NavHost(
            navController = navController,
            startDestination = Destinations.DestinationHome.route
        ) {

            // DestinationHome
            composable(
                route = Destinations.DestinationHome.route,
                content = {
                    DestinationHome(
                        navBarPadding = navBarPadding,
                        classItemClicked = { classId: String ->
                            navController.navigate(
                                route = Destinations.DestinationClassDetail.supplyArguments(
                                    classId = classId,
                                    navBarPadding = navBarPadding
                                )
                            )
                        }
                    )
                }
            )

            // DestinationClassDetail
            composable(
                route = Destinations.DestinationClassDetail.route,
                arguments = listOf(
                    navArgument(name = CLASS_ID) {
                        type = NavType.StringType
                    },
                    navArgument(name = NAV_BAR_PADDING) {
                        type = NavType.IntType
                    }
                ),
                content = { backStackEntry: NavBackStackEntry ->
                    backStackEntry.arguments?.let { bundle: Bundle ->
                        DestinationClassDetail(
                            classId = bundle.getString(CLASS_ID, ""),
                            navBarPadding = bundle.getInt(NAV_BAR_PADDING, 0),
                            classVideoClicked = { videoId: String ->
                                navController.navigate(
                                    route = Destinations.DestinationVideo.supplyArguments(
                                        videoId = videoId,
                                        navBarPadding = navBarPadding
                                    )
                                )
                            }
                        )
                    }
                }
            )

            // DestinationVideo
            composable(
                route = Destinations.DestinationVideo.route,
                arguments = listOf(
                    navArgument(name = VIDEO_ID) {
                        type = NavType.StringType
                    },
                    navArgument(name = NAV_BAR_PADDING) {
                        type = NavType.IntType
                    }
                ),
                content = { backStackEntry: NavBackStackEntry ->
                    backStackEntry.arguments?.let { bundle: Bundle ->
                        DestinationVideo(
                            videoId = bundle.getString(VIDEO_ID, ""),
                            navBarPadding = bundle.getInt(NAV_BAR_PADDING, 0),
                        )
                    }
                }
            )
        }
    }

}