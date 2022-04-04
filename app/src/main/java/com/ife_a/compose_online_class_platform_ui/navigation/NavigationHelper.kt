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
import com.ife_a.compose_online_class_platform_ui.navigation.NavigationHelper.DestinationArguments.CLASS_ID
import com.ife_a.compose_online_class_platform_ui.navigation.NavigationHelper.Destinations.*

object NavigationHelper {

    object DestinationArguments {
        const val CLASS_ID = "classId"
    }

    sealed class Destinations(val route: String) {
        object DestinationHome : Destinations(route = "destinationHome")
        object DestinationClassDetail :
            Destinations(route = "destinationClassDetail/{$CLASS_ID}") {
            fun supplyClassId(classId: String): String {
                return this.route.replace("{$CLASS_ID}", classId)
            }
        }
    }

    @Composable
    fun SetupNavGraph(navController: NavHostController) {

        NavHost(
            navController = navController,
            startDestination = DestinationHome.route
        ) {

            composable(
                route = DestinationHome.route,
                content = {
                    DestinationHome(
                        classItemClicked = { classId: String ->
                            navController.navigate(
                                route = DestinationClassDetail.supplyClassId(classId = classId)
                            )
                        }
                    )
                }
            )

            composable(
                route = DestinationClassDetail.route,
                arguments = listOf(
                    navArgument(name = CLASS_ID) {
                        type = NavType.StringType
                    }
                ),
                content = { backStackEntry: NavBackStackEntry ->
                    backStackEntry.arguments?.let { bundle: Bundle ->
                        DestinationClassDetail(
                            classId = bundle.getString(CLASS_ID, "")
                        )
                    }
                }
            )
        }

    }

}