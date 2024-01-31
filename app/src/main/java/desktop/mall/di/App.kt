package desktop.mall.di

import android.app.Application
import android.util.Log
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import dagger.hilt.android.HiltAndroidApp
import desktop.mall.R

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

//        var keyhash = Utility.getKeyHash(this)
//        Log.e("keyhash", keyhash)

        KakaoSdk.init(this, getString(R.string.app_key))
    }
}