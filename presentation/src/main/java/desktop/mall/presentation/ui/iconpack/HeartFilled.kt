package desktop.mall.presentation.ui.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import desktop.mall.presentation.ui.IconPack

public val IconPack.HeartFilled: ImageVector
    get() {
        if (_heartFilled != null) {
            return _heartFilled!!
        }
        _heartFilled = Builder(name = "HeartFilled", defaultWidth = 800.0.dp, defaultHeight =
                800.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.7692f, 6.7048f)
                curveTo(9.5385f, 2.019f, 4.0f, 3.9025f, 4.0f, 8.6826f)
                curveTo(4.0f, 13.4627f, 13.2308f, 20.0f, 13.2308f, 20.0f)
                curveTo(13.2308f, 20.0f, 22.0f, 13.2003f, 22.0f, 8.6826f)
                curveTo(22.0f, 4.1648f, 16.9231f, 2.019f, 13.6923f, 6.7048f)
                lineTo(13.2308f, 7.0791f)
                lineTo(12.7692f, 6.7048f)
                close()
            }
        }
        .build()
        return _heartFilled!!
    }

private var _heartFilled: ImageVector? = null
