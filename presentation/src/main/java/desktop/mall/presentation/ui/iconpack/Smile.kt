package desktop.mall.presentation.ui.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
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

public val IconPack.Smile: ImageVector
    get() {
        if (_smile != null) {
            return _smile!!
        }
        _smile = Builder(name = "Smile", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 1024.0f, viewportHeight = 1024.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(324.8f, 440.0f)
                curveToRelative(34.4f, 0.0f, 62.4f, -28.0f, 62.4f, -62.4f)
                reflectiveCurveToRelative(-28.0f, -62.4f, -62.4f, -62.4f)
                reflectiveCurveToRelative(-62.4f, 28.0f, -62.4f, 62.4f)
                reflectiveCurveToRelative(28.0f, 62.4f, 62.4f, 62.4f)
                close()
                moveTo(699.2f, 440.0f)
                curveToRelative(34.4f, 0.0f, 62.4f, -28.0f, 62.4f, -62.4f)
                reflectiveCurveToRelative(-28.0f, -62.4f, -62.4f, -62.4f)
                reflectiveCurveToRelative(-62.4f, 28.0f, -62.4f, 62.4f)
                reflectiveCurveToRelative(28.0f, 62.4f, 62.4f, 62.4f)
                close()
                moveTo(340.0f, 709.6f)
                curveTo(384.0f, 744.0f, 440.8f, 764.8f, 512.0f, 764.8f)
                reflectiveCurveToRelative(128.0f, -20.8f, 172.0f, -55.2f)
                curveToRelative(26.4f, -21.6f, 42.4f, -42.4f, 50.4f, -58.4f)
                curveToRelative(6.4f, -12.0f, 0.8f, -27.2f, -11.2f, -33.6f)
                reflectiveCurveToRelative(-27.2f, -0.8f, -33.6f, 11.2f)
                curveToRelative(-0.8f, 1.6f, -3.2f, 6.4f, -8.0f, 12.0f)
                curveToRelative(-7.2f, 10.4f, -17.6f, 20.0f, -28.8f, 29.6f)
                curveToRelative(-34.4f, 28.0f, -80.8f, 44.8f, -140.8f, 44.8f)
                reflectiveCurveToRelative(-105.6f, -16.8f, -140.8f, -44.8f)
                curveToRelative(-12.0f, -9.6f, -21.6f, -20.0f, -28.8f, -29.6f)
                curveToRelative(-4.0f, -5.6f, -7.2f, -9.6f, -8.0f, -12.0f)
                curveToRelative(-6.4f, -12.0f, -20.8f, -17.6f, -33.6f, -11.2f)
                reflectiveCurveToRelative(-17.6f, 20.8f, -11.2f, 33.6f)
                curveToRelative(8.0f, 16.0f, 24.0f, 36.8f, 50.4f, 58.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(512.0f, 1010.4f)
                curveToRelative(-276.8f, 0.0f, -502.4f, -225.6f, -502.4f, -502.4f)
                reflectiveCurveTo(235.2f, 5.6f, 512.0f, 5.6f)
                reflectiveCurveToRelative(502.4f, 225.6f, 502.4f, 502.4f)
                reflectiveCurveToRelative(-225.6f, 502.4f, -502.4f, 502.4f)
                close()
                moveTo(512.0f, 53.6f)
                curveTo(261.6f, 53.6f, 57.6f, 257.6f, 57.6f, 508.0f)
                reflectiveCurveToRelative(204.0f, 454.4f, 454.4f, 454.4f)
                reflectiveCurveToRelative(454.4f, -204.0f, 454.4f, -454.4f)
                reflectiveCurveTo(762.4f, 53.6f, 512.0f, 53.6f)
                close()
            }
        }
        .build()
        return _smile!!
    }

private var _smile: ImageVector? = null
