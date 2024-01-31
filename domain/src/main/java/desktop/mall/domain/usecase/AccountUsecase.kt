package desktop.mall.domain.usecase

import desktop.mall.domain.model.AccountInfo
import desktop.mall.domain.repository.AccountRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class AccountUsecase @Inject constructor(
    private val accountRepository: AccountRepository
) {

    fun getAccountInfo(): StateFlow<AccountInfo?> {
        return accountRepository.getAccountInfo()
    }

    suspend fun signIn(accountInfo: AccountInfo) {
        accountRepository.signIn(accountInfo)
    }

    suspend fun singOut() {
        accountRepository.signOut()
    }
}