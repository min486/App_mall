package desktop.mall.presentation.ui

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import desktop.mall.domain.model.Category
import desktop.mall.presentation.ui.NavigationRouteName.DEEP_LINK_SCHEME
import desktop.mall.presentation.ui.NavigationRouteName.MAIN_CATEGORY
import desktop.mall.presentation.ui.NavigationRouteName.MAIN_HOME
import desktop.mall.presentation.ui.NavigationRouteName.MAIN_LIKE
import desktop.mall.presentation.ui.NavigationRouteName.MAIN_MY_PAGE
import desktop.mall.presentation.ui.iconpack.Heart
import desktop.mall.presentation.ui.iconpack.Home
import desktop.mall.presentation.ui.iconpack.Menu
import desktop.mall.presentation.ui.iconpack.Smile
import desktop.mall.presentation.utils.GsonUtils

sealed class MainNav(override val route: String, val icon: ImageVector, override val title: String) : Destination {
    object Home : MainNav(MAIN_HOME, IconPack.Home, NavigationTitle.MAIN_HOME)
    object Category : MainNav(MAIN_CATEGORY, IconPack.Menu, NavigationTitle.MAIN_CATEGORY)
    object MyPage : MainNav(MAIN_MY_PAGE, IconPack.Smile, NavigationTitle.MAIN_MY_PAGE)
    object Like : MainNav(MAIN_LIKE, IconPack.Heart, NavigationTitle.MAIN_LIKE)

    override val deepLinks: List<NavDeepLink> = listOf(
        navDeepLink { uriPattern = "$DEEP_LINK_SCHEME$route" }
    )

    companion object {
        fun isMainRoute(route: String?): Boolean {
            return when (route) {
                MAIN_HOME, MAIN_CATEGORY, MAIN_MY_PAGE, MAIN_LIKE -> true
                else -> false
            }
        }
    }
}

object SearchNav : Destination {
    override val route: String = NavigationRouteName.SEARCH
    override val title: String = NavigationTitle.SEARCH
    override val deepLinks: List<NavDeepLink> = listOf(
        navDeepLink { uriPattern = "$DEEP_LINK_SCHEME$route" }
    )
}

object BasketNav : Destination {
    override val route: String = NavigationRouteName.BASKET
    override val title: String = NavigationTitle.BASKET
    override val deepLinks: List<NavDeepLink> = listOf(
        navDeepLink { uriPattern = "$DEEP_LINK_SCHEME$route" }
    )
}

object CategoryNav: DestinationArg<Category> {
    override val route: String = NavigationRouteName.CATEGORY
    override val title: String = NavigationTitle.CATEGORY
    override val argName: String = "category"
    override val deepLinks: List<NavDeepLink> = listOf(
        navDeepLink { uriPattern = "$DEEP_LINK_SCHEME$route/{$argName}" }
    )

    override val arguments: List<NamedNavArgument> = listOf(
        navArgument(argName) { type = NavType.StringType }
    )

    override fun navigateWithArg(item: Category): String {
        val arg = GsonUtils.toJson(item)
        return "$route/$arg"
    }

    override fun findArgument(navBackStackEntry: NavBackStackEntry): Category? {
        val categoryString = navBackStackEntry.arguments?.getString(argName)
        return GsonUtils.fromJson<Category>(categoryString)
    }
}

object ProductDetailNav: DestinationArg<String> {
    override val route: String = NavigationRouteName.PRODUCT_DETAIL
    override val title: String = NavigationTitle.PRODUCT_DETAIL
    override val argName: String = "productId"
    override val deepLinks: List<NavDeepLink> = listOf(
        navDeepLink { uriPattern = "$DEEP_LINK_SCHEME$route/{$argName}" }
    )

    override val arguments: List<NamedNavArgument> = listOf(
        navArgument(argName) { type = NavType.StringType }
    )

    override fun navigateWithArg(item: String): String {
        val arg = GsonUtils.toJson(item)
        return "$route/$arg"
    }

    override fun findArgument(navBackStackEntry: NavBackStackEntry): String? {
        val categoryString = navBackStackEntry.arguments?.getString(argName)
        return GsonUtils.fromJson<String>(categoryString)
    }
}


interface Destination {
    val route: String
    val title: String  // 헤더에서 사용
    val deepLinks: List<NavDeepLink>
}

interface DestinationArg<T> : Destination {
    val argName: String
    val arguments: List<NamedNavArgument>

    fun routeWithArgName() = "$route/{$argName}"
    fun navigateWithArg(item: T): String
    fun findArgument(navBackStackEntry: NavBackStackEntry): T?
}

object NavigationRouteName {
    const val DEEP_LINK_SCHEME = "mall://"
    const val MAIN_HOME = "main_home"
    const val MAIN_CATEGORY = "main_category"
    const val MAIN_MY_PAGE = "main_my_page"
    const val MAIN_LIKE = "main_like"
    const val CATEGORY = "category"
    const val PRODUCT_DETAIL = "product_detail"
    const val SEARCH = "search"
    const val BASKET = "basket"
}

object NavigationTitle {
    const val MAIN_HOME = "MINU"
    const val MAIN_CATEGORY = "카테고리"
    const val MAIN_MY_PAGE = "마이페이지"
    const val MAIN_LIKE = "좋아요"
    const val CATEGORY = "카테고리 상세"
    const val PRODUCT_DETAIL = "상품 상세"
    const val SEARCH = "검색"
    const val BASKET = "장바구니"
}