package desktop.mall.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import desktop.mall.domain.model.Category
import desktop.mall.presentation.ui.category.CategoryScreen
import desktop.mall.presentation.ui.main.MainCategoryScreen
import desktop.mall.presentation.ui.main.MainHomeScreen
import desktop.mall.presentation.ui.main.MainLikeScreen
import desktop.mall.presentation.ui.product_detail.ProductDetailScreen
import desktop.mall.presentation.ui.search.SearchScreen
import desktop.mall.presentation.viewmodel.MainViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val viewModel = hiltViewModel<MainViewModel>()

    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (NavigationItem.MainNav.isMainRoute(currentRoute)) {
                MainHeader(viewModel = viewModel, navController = navController)
            }
         },
        scaffoldState = scaffoldState,
        bottomBar = {
            // main 화면일때만 BottomNavBar 노출될수있게
            if (NavigationItem.MainNav.isMainRoute(currentRoute)) {
                MainBottomNavBar(navController, currentRoute)
            }
        }
    ) {
        MainNavScreen(viewModel = viewModel, navController = navController)
    }

}

@Composable
fun MainHeader(viewModel: MainViewModel, navController: NavHostController) {
    TopAppBar(
        title = { Text("My App") },
        actions = {
            IconButton(onClick = {
                viewModel.openSearchForm(navController)
            }) {
                Icon(Icons.Filled.Search, "description")
            }
        }
    )
}

@Composable
fun MainBottomNavBar(navController: NavController, currentRoute: String?) {
    val bottomNavigationItems = listOf(
        NavigationItem.MainNav.Home,
        NavigationItem.MainNav.Category,
        NavigationItem.MainNav.Like,
        NavigationItem.MainNav.MyPage,
    )

    BottomNavigation {

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
fun MainNavScreen(viewModel: MainViewModel, navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationRouteName.MAIN_HOME) {
        composable(NavigationRouteName.MAIN_HOME) {
            MainHomeScreen(navController, viewModel)
        }
        composable(NavigationRouteName.MAIN_CATEGORY) {
            MainCategoryScreen(viewModel, navController)
        }
        composable(NavigationRouteName.MAIN_MY_PAGE) {
            Text(text = "MyPage")
        }
        composable(NavigationRouteName.MAIN_LIKE) {
            MainLikeScreen(navHostController = navController, viewModel = viewModel)
        }
        composable(
            NavigationRouteName.CATEGORY + "/{category}",
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) {
            val categoryString = it.arguments?.getString("category")
            val category = Gson().fromJson(categoryString, Category::class.java)
            if (category != null) {
                CategoryScreen(category = category, navHostController = navController)
            }
        }
        composable(
            NavigationRouteName.PRODUCT_DETAIL + "/{product}",
            arguments = listOf(navArgument("product") { type = NavType.StringType })
        ) {
            val productString = it.arguments?.getString("product")
            if (productString != null) {
                ProductDetailScreen(productId = productString)
            }
        }
        composable(NavigationRouteName.SEARCH) {
            SearchScreen(navController)
        }
    }
}