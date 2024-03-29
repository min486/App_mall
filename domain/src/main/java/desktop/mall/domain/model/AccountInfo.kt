package desktop.mall.domain.model

data class AccountInfo(val tokenId: String, val name: String, val type: Type, val profileImageUrl: String) {
    enum class Type {
        KAKAO
    }
}