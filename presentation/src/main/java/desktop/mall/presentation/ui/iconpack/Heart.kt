package desktop.mall.presentation.ui.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import desktop.mall.presentation.ui.IconPack

public val IconPack.Heart: ImageVector
    get() {
        if (_heart != null) {
            return _heart!!
        }
        _heart = Builder(name = "Heart", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF1C274C)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(5.6244f, 4.4241f)
                curveTo(3.9654f, 5.1824f, 2.75f, 6.9861f, 2.75f, 9.137f)
                curveTo(2.75f, 11.3344f, 3.6492f, 13.0281f, 4.9383f, 14.4797f)
                curveTo(6.0007f, 15.676f, 7.2868f, 16.6675f, 8.5411f, 17.6345f)
                curveTo(8.839f, 17.8642f, 9.1351f, 18.0925f, 9.4261f, 18.3218f)
                curveTo(9.9521f, 18.7365f, 10.4213f, 19.1004f, 10.8736f, 19.3647f)
                curveTo(11.3261f, 19.6292f, 11.6904f, 19.7499f, 12.0f, 19.7499f)
                curveTo(12.3096f, 19.7499f, 12.6739f, 19.6292f, 13.1264f, 19.3647f)
                curveTo(13.5787f, 19.1004f, 14.0479f, 18.7365f, 14.574f, 18.3218f)
                curveTo(14.8649f, 18.0925f, 15.161f, 17.8642f, 15.4589f, 17.6345f)
                curveTo(16.7132f, 16.6675f, 17.9993f, 15.676f, 19.0617f, 14.4797f)
                curveTo(20.3508f, 13.0281f, 21.25f, 11.3344f, 21.25f, 9.137f)
                curveTo(21.25f, 6.9861f, 20.0346f, 5.1824f, 18.3756f, 4.4241f)
                curveTo(16.7639f, 3.6874f, 14.5983f, 3.8825f, 12.5404f, 6.0206f)
                curveTo(12.399f, 6.1675f, 12.2039f, 6.2505f, 12.0f, 6.2505f)
                curveTo(11.7961f, 6.2505f, 11.601f, 6.1675f, 11.4596f, 6.0206f)
                curveTo(9.4017f, 3.8825f, 7.2361f, 3.6874f, 5.6244f, 4.4241f)
                close()
                moveTo(12.0f, 4.4587f)
                curveTo(9.688f, 2.3902f, 7.099f, 2.1008f, 5.0008f, 3.0599f)
                curveTo(2.7847f, 4.0728f, 1.25f, 6.4249f, 1.25f, 9.137f)
                curveTo(1.25f, 11.8025f, 2.3605f, 13.836f, 3.8167f, 15.4757f)
                curveTo(4.9829f, 16.7888f, 6.4102f, 17.8879f, 7.6708f, 18.8585f)
                curveTo(7.9566f, 19.0785f, 8.2338f, 19.292f, 8.4974f, 19.4998f)
                curveTo(9.0097f, 19.9036f, 9.5595f, 20.3342f, 10.1168f, 20.6598f)
                curveTo(10.6739f, 20.9853f, 11.3096f, 21.2499f, 12.0f, 21.2499f)
                curveTo(12.6904f, 21.2499f, 13.3261f, 20.9853f, 13.8832f, 20.6598f)
                curveTo(14.4405f, 20.3342f, 14.9903f, 19.9036f, 15.5026f, 19.4998f)
                curveTo(15.7662f, 19.292f, 16.0434f, 19.0785f, 16.3292f, 18.8585f)
                curveTo(17.5898f, 17.8879f, 19.0171f, 16.7888f, 20.1833f, 15.4757f)
                curveTo(21.6395f, 13.836f, 22.75f, 11.8025f, 22.75f, 9.137f)
                curveTo(22.75f, 6.4249f, 21.2153f, 4.0728f, 18.9992f, 3.0599f)
                curveTo(16.901f, 2.1008f, 14.3121f, 2.3902f, 12.0f, 4.4587f)
                close()
            }
        }
        .build()
        return _heart!!
    }

private var _heart: ImageVector? = null
