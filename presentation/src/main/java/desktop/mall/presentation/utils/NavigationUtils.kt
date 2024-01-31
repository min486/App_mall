package desktop.mall.presentation.utils

import androidx.navigation.NavHostController
import desktop.mall.presentation.ui.BasketNav
import desktop.mall.presentation.ui.CategoryNav
import desktop.mall.presentation.ui.Destination
import desktop.mall.presentation.ui.MainNav
import desktop.mall.presentation.ui.NavigationRouteName
import desktop.mall.presentation.ui.ProductDetailNav
import desktop.mall.presentation.ui.SearchNav

object NavigationUtils {

//    fun navigate(
//        controller: NavHostController,
//        routeName: String,
//        args: Any? = null,
//        backStackRouteName: String? = null,
//        isLaunchSingleTop: Boolean = true,
//        needToRestoreState: Boolean = true
//    ) {
//        var argument = ""
//        if(args != null) {
//            when(args) {
//                is Parcelable -> {
//                    argument = String.format("/%s", Uri.parse(Gson().toJson(args)))
//                }
//                is Category -> {
//                    argument = String.format("/%s", Uri.parse(Gson().toJson(args)))
//                }
//                is Product -> {
//                    argument = String.format("/%s", args.productId)
//                }
//            }
//        }
//        controller.navigate("$routeName$argument") {
//            if(backStackRouteName != null) {
//                popUpTo(backStackRouteName) { saveState = true }
//            }
//            launchSingleTop = isLaunchSingleTop
//            restoreState = needToRestoreState
//        }
//    }

    fun navigate(
        controller: NavHostController,
        routeName: String,
        backStackRouteName: String? = null,
        isLaunchSingleTop: Boolean = true,
        needToRestoreState: Boolean = true
    ) {
        controller.navigate(routeName) {
            if(backStackRouteName != null) {
                popUpTo(backStackRouteName) { saveState = true }
            }
            launchSingleTop = isLaunchSingleTop
            restoreState = needToRestoreState
        }
    }

    fun findDestination(route: String?): Destination {
        return when(route) {
            NavigationRouteName.MAIN_HOME -> MainNav.Home
            NavigationRouteName.MAIN_CATEGORY -> MainNav.Category
            NavigationRouteName.MAIN_LIKE -> MainNav.Like
            NavigationRouteName.MAIN_MY_PAGE -> MainNav.MyPage
            NavigationRouteName.SEARCH -> SearchNav
            NavigationRouteName.BASKET -> BasketNav

            ProductDetailNav.routeWithArgName() -> ProductDetailNav
            CategoryNav.routeWithArgName() -> CategoryNav
            else -> MainNav.Home
        }
    }
}