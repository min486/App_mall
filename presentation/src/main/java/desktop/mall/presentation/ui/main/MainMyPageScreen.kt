package desktop.mall.presentation.ui.main

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import desktop.mall.domain.model.AccountInfo
import desktop.mall.presentation.viewmodel.MainViewModel

@Composable
fun MainMyPageScreen(viewModel: MainViewModel) {
    val accountInfo by viewModel.accountInfo.collectAsState()
    val context = LocalContext.current

    val kakaoCallback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        when {
            error != null -> {
                Log.e("kakao", "카카오톡 로그인 실패", error)
            }
            token != null -> {
                loginWithKakaoNickName(token, viewModel)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        if(accountInfo != null) {
            Row {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(accountInfo?.profileImageUrl)
                            .apply(block = fun ImageRequest.Builder.(){
                                crossfade(true)
                            }).build()
                    ),
                    contentDescription = "description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "${accountInfo?.name.orEmpty()} 님",
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.singOut()

                    when(accountInfo?.type) {
                        AccountInfo.Type.KAKAO -> {
                            UserApiClient.instance.logout { }
                        }
                        else -> {}
                    }
                }
            ) {
                Text(text = "로그아웃")
            }
        } else {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    loginKakao(context, kakaoCallback)
                }
            ) {
                Text(text = "카카오 로그인")
            }
        }
    }
}

private fun loginWithKakaoNickName(token: OAuthToken, viewModel: MainViewModel) {
    UserApiClient.instance.me { user, error ->
        when {
            error != null -> {
                Log.e("kakao", "사용자 정보 실패", error)
            }
            user != null -> {
                val imageUrl = user.kakaoAccount?.profile?.thumbnailImageUrl
                val nickName = user.kakaoAccount?.profile?.nickname

                viewModel.singIn(AccountInfo(token.accessToken, nickName.orEmpty(), AccountInfo.Type.KAKAO, imageUrl.orEmpty()))
            }
        }
    }
}

private fun loginKakao(context: Context, kakaoCallback: (OAuthToken?, Throwable?) -> Unit) {
    if(UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
        // 카카오톡 설치
        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            if(error != null) {
                Log.e("kakao", "카카오톡 로그인 실패", error)
            }

            if(error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                return@loginWithKakaoTalk
            }

            UserApiClient.instance.loginWithKakaoAccount(context, callback = kakaoCallback)
        }
    } else {
        // 카카오톡 미설치
        UserApiClient.instance.loginWithKakaoAccount(context, callback = kakaoCallback)
    }
}