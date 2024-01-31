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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import desktop.mall.presentation.ui.basket.BasketScreen
import desktop.mall.presentation.ui.category.CategoryScreen
import desktop.mall.presentation.ui.main.MainCategoryScreen
import desktop.mall.presentation.ui.main.MainHomeScreen
import desktop.mall.presentation.ui.main.MainLikeScreen
import desktop.mall.presentation.ui.main.MainMyPageScreen
import desktop.mall.presentation.ui.product_detail.ProductDetailScreen
import desktop.mall.presentation.ui.search.SearchScreen
import desktop.mall.presentation.utils.NavigationUtils
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
            //if (MainNav.isMainRoute(currentRoute)) {
            MainHeader(viewModel = viewModel, navController = navController, currentRoute)
            //}
        },
        scaffoldState = scaffoldState,
        bottomBar = {
            // main 화면일때만 BottomNavBar 노출될수있게
            if (MainNav.isMainRoute(currentRoute)) {
                MainBottomNavBar(navController, currentRoute)
            }
        }
    ) {
        MainNavScreen(viewModel = viewModel, navController = navController)
    }
}

@Composable
fun MainHeader(viewModel: MainViewModel, navController: NavHostController, currentRoute: String?) {
    TopAppBar(
        title = { Text(NavigationUtils.findDestination(currentRoute).title) },
        navigationIcon = if (!MainNav.isMainRoute(currentRoute)) {
            {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, "description")
                }
            }
        } else {
            null
        },
        actions = {
            if (MainNav.isMainRoute(currentRoute)) {
                IconButton(onClick = {
                    viewModel.openSearchForm(navController)
                }) {
                    Icon(Icons.Filled.Search, "description")
                }

                IconButton(onClick = {
                    viewModel.openBasket(navController)
                }) {
                    Icon(Icons.Filled.ShoppingCart, "description")
                }
            }
        }
    )
}

@Composable
fun MainBottomNavBar(navController: NavHostController, currentRoute: String?) {
    val bottomNavigationItems = listOf(
        MainNav.Home,
        MainNav.Category,
        MainNav.Like,
        MainNav.MyPage,
    )

    BottomNavigation {

        bottomNavigationItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, item.route) },
                selected = currentRoute == item.route,
                onClick = {
                    // 하단 탭 전환
                    NavigationUtils.navigate(
                        navController, item.route,
                        navController.graph.startDestinationRoute
                    )
                }
            )
        }
    }
}

@Composable
fun MainNavScreen(viewModel: MainViewModel, navController: NavHostController) {
    NavHost(navController = navController, startDestination = MainNav.Home.route) {
        composable(
            route = MainNav.Home.route,
            deepLinks = MainNav.Home.deepLinks
        ) {
            MainHomeScreen(navController, viewModel)
        }
        composable(
            route = MainNav.Category.route,
            deepLinks = MainNav.Category.deepLinks
        ) {
            MainCategoryScreen(viewModel, navController)
        }
        composable(
            route = MainNav.MyPage.route,
            deepLinks = MainNav.MyPage.deepLinks
        ) {
            MainMyPageScreen(viewModel)
        }
        composable(
            route = MainNav.Like.route,
            deepLinks = MainNav.Like.deepLinks
        ) {
            MainLikeScreen(navHostController = navController, viewModel = viewModel)
        }
        composable(
            route = BasketNav.route,
            deepLinks = BasketNav.deepLinks
        ) {
            BasketScreen()
        }
        composable(
            route = SearchNav.route,
            deepLinks = SearchNav.deepLinks
        ) {
            SearchScreen(navController)
        }
//        composable(
//            NavigationRouteName.CATEGORY + "/{category}",
//            arguments = listOf(navArgument("category") { type = NavType.StringType })
//        ) {
//            val categoryString = it.arguments?.getString("category")
//            val category = Gson().fromJson(categoryString, Category::class.java)
//            if (category != null) {
//                CategoryScreen(category = category, navHostController = navController)
//            }
//        }
        composable(
            route = CategoryNav.routeWithArgName(),
            arguments = CategoryNav.arguments,
            deepLinks = CategoryNav.deepLinks
        ) {
            val category = CategoryNav.findArgument(it)
            if (category != null) {
                CategoryScreen(category = category, navHostController = navController)
            }
        }
        composable(
            route = ProductDetailNav.routeWithArgName(),
            arguments = ProductDetailNav.arguments,
            deepLinks = ProductDetailNav.deepLinks
        ) {
            val productString = ProductDetailNav.findArgument(it)
            if (productString != null) {
                ProductDetailScreen(productId = productString)
            }
        }
//        composable(
//            NavigationRouteName.PRODUCT_DETAIL + "/{product}",
//            arguments = listOf(navArgument("product") { type = NavType.StringType })
//        ) {
//            val productString = it.arguments?.getString("product")
//            if (productString != null) {
//                ProductDetailScreen(productId = productString)
//            }
//        }

    }
}