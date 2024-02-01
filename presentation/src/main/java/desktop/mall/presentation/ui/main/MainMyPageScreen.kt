package desktop.mall.presentation.ui.main

import android.content.Context
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import desktop.mall.domain.model.AccountInfo
import desktop.mall.presentation.R
import desktop.mall.presentation.ui.theme.GrayButton
import desktop.mall.presentation.ui.theme.GrayIcon
import desktop.mall.presentation.ui.theme.GrayLine
import desktop.mall.presentation.ui.theme.GrayLine2
import desktop.mall.presentation.ui.theme.GrayText
import desktop.mall.presentation.ui.theme.kakaoContainer
import desktop.mall.presentation.ui.theme.kakaoLabel
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
        modifier = Modifier.fillMaxSize()
    ) {
        if(accountInfo != null) {
            // 로그인 상태
            Row(
                modifier = Modifier.padding(36.dp)
            ) {
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
                        .size(88.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(32.dp))

                Column {
                    Text(
                        text = "${accountInfo?.name.orEmpty()} 님",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 12.dp)
                    )

                    Text(
                        text = "회원정보 변경",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = GrayText,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
            }

            Divider(color = GrayLine, thickness = 8.dp)

            Column(
                modifier = Modifier.padding(36.dp)
            ) {
                Text(
                    text = "쇼핑정보",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Divider(color = Color.Black, thickness = 2.dp)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "좋아요 목록",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )

                    IconButton(onClick = {  }) {
                        Icon(
                            Icons.Filled.KeyboardArrowRight,"description",
                            tint = GrayIcon
                        )
                    }
                }

                Divider(color = GrayLine2, thickness = 1.dp)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "최근 본 제품",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )

                    IconButton(onClick = {  }) {
                        Icon(
                            Icons.Filled.KeyboardArrowRight,"description",
                            tint = GrayIcon
                        )
                    }
                }

                Divider(color = GrayLine2, thickness = 1.dp)

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "마이 메뉴",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Divider(color = Color.Black, thickness = 2.dp)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "회원정보",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )

                    IconButton(onClick = {  }) {
                        Icon(
                            Icons.Filled.KeyboardArrowRight,"description",
                            tint = GrayIcon
                        )
                    }
                }

                Divider(color = GrayLine2, thickness = 1.dp)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "회원탈퇴",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )

                    IconButton(onClick = {  }) {
                        Icon(
                            Icons.Filled.KeyboardArrowRight,"description",
                            tint = GrayIcon
                        )
                    }
                }

                Divider(color = GrayLine2, thickness = 1.dp)

                Spacer(modifier = Modifier.height(40.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    border = BorderStroke(1.dp, GrayButton),
                    onClick = {
                        viewModel.signOut()

                        when(accountInfo?.type) {
                            AccountInfo.Type.KAKAO -> {
                                UserApiClient.instance.logout { }
                            }
                            else -> {}
                        }
                    }
                ) {
                    Text(
                        text = "로그아웃",
                        color = Color.Black
                    )
                }
            }
        } else {
            // 로그아웃 상태
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(120.dp))

                Text(
                    text = "MINU",
                    modifier = Modifier.weight(1f),
                    fontSize = 80.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 30.dp)
                ) {
                    Button(
                        onClick = {
                            loginKakao(context, kakaoCallback)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(40.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = kakaoContainer
                        )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.kakao),
                                contentDescription = "description"
                            )

                            Text(
                                text = "카카오로 3초만에 시작하기",
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                color = kakaoLabel
                            )

                            Box {}
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(40.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White
                        ),
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.google),
                                contentDescription = "description"
                            )

                            Text(
                                text = "Google로 시작하기",
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                color = kakaoLabel
                            )

                            Box {}
                        }
                    }
                }
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

                viewModel.signIn(AccountInfo(token.accessToken, nickName.orEmpty(), AccountInfo.Type.KAKAO, imageUrl.orEmpty()))
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