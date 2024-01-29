package desktop.mall.presentation.model

import desktop.mall.domain.model.Product
import desktop.mall.domain.model.Ranking
import desktop.mall.presentation.delegate.ProductDelegate

// by를 통해 전달받은 전달자로 인터페이스 구현 가능
// 하지만 이렇게하면 RankingVM이 openRankingProduct 호출할 수 있고, openProduct도 호출할 수 있다
class RankingVM(model: Ranking, private val productDelegate: ProductDelegate) : PresentationVM<Ranking>(model) {

    fun openRankingProduct(product: Product) {
        productDelegate.openProduct(product)  // 주입받아서 사용하면 RankingVM이라는 인스턴스를 가지고 있는
                                              // composable이나 screen에서는 openRankingProduct만 사용 가능
    }
}