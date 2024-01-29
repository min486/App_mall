package desktop.mall.presentation.delegate

import androidx.navigation.NavHostController
import desktop.mall.domain.model.Category

interface CategoryDelegate {
    fun openCategory(navHostController: NavHostController, category: Category)
}