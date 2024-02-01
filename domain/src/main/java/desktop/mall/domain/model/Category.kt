package desktop.mall.domain.model

import desktop.mall.domain.R

//sealed class Category(
open class Category(
    val categoryId: String,
    val categoryName: String,
    val categoryImage: Int
) {
    object Top : Category("1", "상의", R.drawable.top)
    object Outerwear : Category("2", "아우터", R.drawable.outer)
    object Suit : Category("3", "정장", R.drawable.suit)
    object Pants : Category("4", "바지", R.drawable.pants)
    object Shirt : Category("5", "셔츠", R.drawable.shirt)
    object Shoes : Category("6", "신발", R.drawable.shoes)
    object Bag : Category("7", "가방", R.drawable.bag)
    object FashionAccessories : Category("8", "패션잡화", R.drawable.accessories)
}
