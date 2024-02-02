package desktop.mall.presentation.ui.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import desktop.mall.presentation.ui.IconPack

public val IconPack.Basket: ImageVector
    get() {
        if (_basket != null) {
            return _basket!!
        }
        _basket = Builder(name = "Basket", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 512.0f, viewportHeight = 512.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveToRelative(500.0f, 472.5f)
                lineToRelative(-59.7f, -351.0f)
                curveToRelative(-1.7f, -9.7f, -10.1f, -16.9f, -20.0f, -16.9f)
                horizontalLineToRelative(-68.9f)
                curveToRelative(-19.1f, -44.5f, -51.3f, -91.6f, -95.5f, -91.6f)
                curveToRelative(-44.2f, 0.0f, -76.4f, 47.0f, -95.6f, 91.6f)
                horizontalLineToRelative(-68.9f)
                curveToRelative(-9.9f, 0.0f, -18.3f, 7.1f, -20.0f, 16.9f)
                lineToRelative(-60.1f, 353.8f)
                curveToRelative(-2.4f, 11.0f, 3.1f, 23.6f, 20.0f, 23.6f)
                horizontalLineToRelative(449.3f)
                curveToRelative(0.1f, 0.0f, 0.1f, 0.0f, 0.2f, 0.0f)
                curveToRelative(11.1f, 0.1f, 22.9f, -12.6f, 19.2f, -26.4f)
                close()
                moveTo(255.9f, 53.5f)
                curveToRelative(18.8f, 0.0f, 37.1f, 23.9f, 51.0f, 51.1f)
                horizontalLineToRelative(-102.0f)
                curveToRelative(13.9f, -27.2f, 32.2f, -51.1f, 51.0f, -51.1f)
                close()
                moveTo(55.2f, 458.5f)
                lineToRelative(53.3f, -313.3f)
                horizontalLineToRelative(37.4f)
                curveToRelative(-4.2f, 14.9f, -6.3f, 26.9f, -6.3f, 33.1f)
                curveToRelative(0.0f, 11.2f, 9.1f, 20.2f, 20.2f, 20.2f)
                curveToRelative(11.2f, 0.0f, 20.2f, -9.1f, 20.2f, -20.2f)
                curveToRelative(0.0f, -6.2f, 2.8f, -18.5f, 7.7f, -33.1f)
                horizontalLineToRelative(136.1f)
                curveToRelative(4.9f, 14.6f, 7.7f, 26.9f, 7.7f, 33.1f)
                curveToRelative(0.0f, 11.2f, 9.1f, 20.2f, 20.2f, 20.2f)
                curveToRelative(11.2f, 0.0f, 20.2f, -9.1f, 20.2f, -20.2f)
                curveToRelative(0.0f, -6.2f, -2.1f, -18.2f, -6.3f, -33.1f)
                horizontalLineToRelative(37.4f)
                lineToRelative(53.3f, 313.3f)
                horizontalLineToRelative(-401.1f)
                close()
            }
        }
        .build()
        return _basket!!
    }

private var _basket: ImageVector? = null
