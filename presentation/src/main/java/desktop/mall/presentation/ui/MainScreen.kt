package desktop.mall.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class MainNavItem(val route: String, val icon: ImageVector, val name: String) {
    object Main : MainNavItem("Main", Icons.Filled.Home, "Main")
    object Category : MainNavItem("Category", Icons.Filled.Star, "Category")
    object MyPage : MainNavItem("MyPage", Icons.Filled.AccountBox, "MyPage")
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            MainBottomNavBar(navController)
        }
    ) {
        MainNavScreen(navController = navController)
    }

}

@Composable
fun MainBottomNavBar(navController: NavController) {
    val bottomNavigationItems = listOf(
        MainNavItem.Main,
        MainNavItem.Category,
        MainNavItem.MyPage,
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavigationItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(item.icon, item.route) }
            )
        }
    }
}

@Composable
fun MainNavScreen(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MainNavItem.Main.route) {
        composable(MainNavItem.Main.route) {
            Text(text = "Main")
        }
        composable(MainNavItem.Category.route) {
            Text(text = "Category")
        }
        composable(MainNavItem.MyPage.route) {
            Text(text = "MyPage")
        }
    }
}

