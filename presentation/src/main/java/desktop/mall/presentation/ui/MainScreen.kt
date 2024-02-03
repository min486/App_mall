package desktop.mall.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import desktop.mall.presentation.R
import desktop.mall.presentation.ui.basket.BasketScreen
import desktop.mall.presentation.ui.category.CategoryScreen
import desktop.mall.presentation.ui.iconpack.Basket
import desktop.mall.presentation.ui.iconpack.Search
import desktop.mall.presentation.ui.main.MainCategoryScreen
import desktop.mall.presentation.ui.main.MainHomeScreen
import desktop.mall.presentation.ui.main.MainLikeScreen
import desktop.mall.presentation.ui.main.MainMyPageScreen
import desktop.mall.presentation.ui.product_detail.ProductDetailScreen
import desktop.mall.presentation.ui.search.SearchScreen
import desktop.mall.presentation.ui.theme.basketPrice
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
            MainHeader(viewModel = viewModel, navController = navController, currentRoute)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainHeader(viewModel: MainViewModel, navController: NavHostController, currentRoute: String?) {

    if (MainNav.isMainRoute(currentRoute)) {
        // main 화면 (4개)
        TopAppBar(
            title = {
                Text(
                    text = NavigationUtils.findDestination(currentRoute).title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                if (MainNav.isMainHome(currentRoute)) {
                    // 홈 로고
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "description",
                        modifier = Modifier
                            .width(44.dp)
                            .padding(start = 4.dp)
                    )
                }
            },
            navigationIcon = null,
            backgroundColor = Color.White,
            actions = {
                IconButton(
                    onClick = {
                        viewModel.openSearchForm(navController)
                    },
                    modifier = Modifier.width(50.dp)
                ) {
                    Icon(
                        imageVector = IconPack.Search,
                        contentDescription = "description",
                        tint = Color.Black,
                        modifier = Modifier.width(24.dp)
                    )
                }
                IconButton(
                    onClick = {
                        viewModel.openBasket(navController)
                    },
                    modifier = Modifier.width(50.dp)
                ) {
                    Icon(
                        imageVector = IconPack.Basket,
                        contentDescription = "description",
                        tint = Color.Black,
                        modifier = Modifier.width(24.dp)
                    )
                }
            }
        )
    } else {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = NavigationUtils.findDestination(currentRoute).title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "description"
                    )
                }
            }
        )
    }
}

@Composable
fun MainBottomNavBar(navController: NavHostController, currentRoute: String?) {
    val bottomNavigationItems = listOf(
        MainNav.Home,
        MainNav.Category,
        MainNav.Like,
        MainNav.MyPage,
    )

    BottomNavigation(
        backgroundColor = Color.White
    ) {
        bottomNavigationItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.route,
                        modifier = Modifier.width(28.dp)
                    )
               },
                selected = currentRoute == item.route,
                selectedContentColor = basketPrice,
                unselectedContentColor = Color.Black,
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