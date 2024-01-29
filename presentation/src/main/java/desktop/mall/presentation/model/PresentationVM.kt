package desktop.mall.presentation.model

import desktop.mall.domain.model.BaseModel

// BaseModel을 상속받는 제네릭이 model에 들어가서 BaseModel 타입을 쓸 수 있다
sealed class PresentationVM<T : BaseModel>(val model: T) {

}