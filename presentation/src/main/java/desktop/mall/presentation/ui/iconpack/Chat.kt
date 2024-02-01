package desktop.mall.presentation.ui.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import desktop.mall.presentation.ui.IconPack

public val IconPack.Chat: ImageVector
    get() {
        if (_chat != null) {
            return _chat!!
        }
        _chat = Builder(name = "Chat", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF1C274C)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(10.4606f, 1.25f)
                horizontalLineTo(13.5394f)
                curveTo(15.1427f, 1.25f, 16.3997f, 1.25f, 17.4039f, 1.3455f)
                curveTo(18.4274f, 1.4428f, 19.2655f, 1.6446f, 20.0044f, 2.0973f)
                curveTo(20.7781f, 2.5714f, 21.4286f, 3.2219f, 21.9027f, 3.9956f)
                curveTo(22.3554f, 4.7344f, 22.5572f, 5.5726f, 22.6545f, 6.5961f)
                curveTo(22.75f, 7.6003f, 22.75f, 8.8573f, 22.75f, 10.4606f)
                verticalLineTo(11.5278f)
                curveTo(22.75f, 12.6691f, 22.75f, 13.564f, 22.7007f, 14.2868f)
                curveTo(22.6505f, 15.0223f, 22.5468f, 15.6344f, 22.3123f, 16.2004f)
                curveTo(21.7287f, 17.6093f, 20.6093f, 18.7287f, 19.2004f, 19.3123f)
                curveTo(18.3955f, 19.6457f, 17.4786f, 19.7197f, 16.2233f, 19.7413f)
                curveTo(15.7842f, 19.7489f, 15.5061f, 19.7545f, 15.2941f, 19.7779f)
                curveTo(15.096f, 19.7999f, 15.0192f, 19.832f, 14.9742f, 19.8582f)
                curveTo(14.9268f, 19.8857f, 14.8622f, 19.936f, 14.7501f, 20.0898f)
                curveTo(14.6287f, 20.2564f, 14.4916f, 20.4865f, 14.2742f, 20.8539f)
                lineTo(13.7321f, 21.7697f)
                curveTo(12.9585f, 23.0767f, 11.0415f, 23.0767f, 10.2679f, 21.7697f)
                lineTo(9.7258f, 20.8539f)
                curveTo(9.5084f, 20.4865f, 9.3712f, 20.2564f, 9.2499f, 20.0898f)
                curveTo(9.1377f, 19.936f, 9.0731f, 19.8857f, 9.0257f, 19.8582f)
                curveTo(8.9808f, 19.832f, 8.904f, 19.7999f, 8.7059f, 19.7779f)
                curveTo(8.4939f, 19.7545f, 8.2157f, 19.7489f, 7.7767f, 19.7413f)
                curveTo(6.5214f, 19.7197f, 5.6045f, 19.6457f, 4.7996f, 19.3123f)
                curveTo(3.3907f, 18.7287f, 2.2713f, 17.6093f, 1.6877f, 16.2004f)
                curveTo(1.4532f, 15.6344f, 1.3495f, 15.0223f, 1.2993f, 14.2868f)
                curveTo(1.25f, 13.564f, 1.25f, 12.6691f, 1.25f, 11.5278f)
                lineTo(1.25f, 10.4606f)
                curveTo(1.25f, 8.8573f, 1.25f, 7.6003f, 1.3455f, 6.5961f)
                curveTo(1.4428f, 5.5726f, 1.6446f, 4.7344f, 2.0973f, 3.9956f)
                curveTo(2.5714f, 3.2219f, 3.2219f, 2.5714f, 3.9956f, 2.0973f)
                curveTo(4.7344f, 1.6446f, 5.5726f, 1.4428f, 6.5961f, 1.3455f)
                curveTo(7.6003f, 1.25f, 8.8573f, 1.25f, 10.4606f, 1.25f)
                close()
                moveTo(6.7381f, 2.8387f)
                curveTo(5.8243f, 2.9256f, 5.2429f, 3.0922f, 4.7794f, 3.3763f)
                curveTo(4.2075f, 3.7267f, 3.7267f, 4.2075f, 3.3763f, 4.7794f)
                curveTo(3.0922f, 5.2429f, 2.9256f, 5.8243f, 2.8387f, 6.7381f)
                curveTo(2.7508f, 7.663f, 2.75f, 8.8488f, 2.75f, 10.5f)
                verticalLineTo(11.5f)
                curveTo(2.75f, 12.6751f, 2.7504f, 13.5189f, 2.7958f, 14.1847f)
                curveTo(2.8408f, 14.8438f, 2.9274f, 15.2736f, 3.0735f, 15.6264f)
                curveTo(3.5049f, 16.6678f, 4.3322f, 17.4951f, 5.3736f, 17.9265f)
                curveTo(5.8892f, 18.1401f, 6.5471f, 18.2199f, 7.8025f, 18.2416f)
                lineTo(7.8343f, 18.2421f)
                curveTo(8.2323f, 18.249f, 8.5811f, 18.2549f, 8.871f, 18.287f)
                curveTo(9.1825f, 18.3215f, 9.4871f, 18.3912f, 9.7799f, 18.5615f)
                curveTo(10.0702f, 18.7304f, 10.2795f, 18.9559f, 10.4621f, 19.2063f)
                curveTo(10.6307f, 19.4378f, 10.804f, 19.7306f, 11.0004f, 20.0623f)
                lineTo(11.5587f, 21.0057f)
                curveTo(11.7515f, 21.3313f, 12.2485f, 21.3313f, 12.4412f, 21.0057f)
                lineTo(12.9996f, 20.0623f)
                curveTo(13.1959f, 19.7306f, 13.3692f, 19.4378f, 13.5379f, 19.2063f)
                curveTo(13.7204f, 18.9559f, 13.9298f, 18.7304f, 14.2201f, 18.5615f)
                curveTo(14.5129f, 18.3912f, 14.8175f, 18.3215f, 15.129f, 18.287f)
                curveTo(15.4189f, 18.2549f, 15.7676f, 18.249f, 16.1656f, 18.2421f)
                lineTo(16.1975f, 18.2416f)
                curveTo(17.4529f, 18.2199f, 18.1108f, 18.1401f, 18.6264f, 17.9265f)
                curveTo(19.6678f, 17.4951f, 20.4951f, 16.6678f, 20.9265f, 15.6264f)
                curveTo(21.0726f, 15.2736f, 21.1592f, 14.8438f, 21.2042f, 14.1847f)
                curveTo(21.2496f, 13.5189f, 21.25f, 12.6751f, 21.25f, 11.5f)
                verticalLineTo(10.5f)
                curveTo(21.25f, 8.8488f, 21.2492f, 7.663f, 21.1613f, 6.7381f)
                curveTo(21.0744f, 5.8243f, 20.9078f, 5.2429f, 20.6237f, 4.7794f)
                curveTo(20.2733f, 4.2075f, 19.7925f, 3.7267f, 19.2206f, 3.3763f)
                curveTo(18.7571f, 3.0922f, 18.1757f, 2.9256f, 17.2619f, 2.8387f)
                curveTo(16.337f, 2.7508f, 15.1512f, 2.75f, 13.5f, 2.75f)
                horizontalLineTo(10.5f)
                curveTo(8.8488f, 2.75f, 7.663f, 2.7508f, 6.7381f, 2.8387f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1C274C)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(9.0f, 11.0f)
                curveTo(9.0f, 11.5523f, 8.5523f, 12.0f, 8.0f, 12.0f)
                curveTo(7.4477f, 12.0f, 7.0f, 11.5523f, 7.0f, 11.0f)
                curveTo(7.0f, 10.4477f, 7.4477f, 10.0f, 8.0f, 10.0f)
                curveTo(8.5523f, 10.0f, 9.0f, 10.4477f, 9.0f, 11.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1C274C)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(13.0f, 11.0f)
                curveTo(13.0f, 11.5523f, 12.5523f, 12.0f, 12.0f, 12.0f)
                curveTo(11.4477f, 12.0f, 11.0f, 11.5523f, 11.0f, 11.0f)
                curveTo(11.0f, 10.4477f, 11.4477f, 10.0f, 12.0f, 10.0f)
                curveTo(12.5523f, 10.0f, 13.0f, 10.4477f, 13.0f, 11.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1C274C)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(17.0f, 11.0f)
                curveTo(17.0f, 11.5523f, 16.5523f, 12.0f, 16.0f, 12.0f)
                curveTo(15.4477f, 12.0f, 15.0f, 11.5523f, 15.0f, 11.0f)
                curveTo(15.0f, 10.4477f, 15.4477f, 10.0f, 16.0f, 10.0f)
                curveTo(16.5523f, 10.0f, 17.0f, 10.4477f, 17.0f, 11.0f)
                close()
            }
        }
        .build()
        return _chat!!
    }

private var _chat: ImageVector? = null
