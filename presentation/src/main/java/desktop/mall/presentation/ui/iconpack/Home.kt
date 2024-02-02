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

public val IconPack.Home: ImageVector
    get() {
        if (_home != null) {
            return _home!!
        }
        _home = Builder(name = "Home", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF080341)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(21.4498f, 10.275f)
                lineTo(11.9998f, 3.1875f)
                lineTo(2.5498f, 10.275f)
                lineTo(2.9998f, 11.625f)
                horizontalLineTo(3.7498f)
                verticalLineTo(20.25f)
                horizontalLineTo(20.2498f)
                verticalLineTo(11.625f)
                horizontalLineTo(20.9998f)
                lineTo(21.4498f, 10.275f)
                close()
                moveTo(5.2498f, 18.75f)
                verticalLineTo(10.125f)
                lineTo(11.9998f, 5.0625f)
                lineTo(18.7498f, 10.125f)
                verticalLineTo(18.75f)
                horizontalLineTo(14.9999f)
                verticalLineTo(14.3333f)
                lineTo(14.2499f, 13.5833f)
                horizontalLineTo(9.7499f)
                lineTo(8.9999f, 14.3333f)
                verticalLineTo(18.75f)
                horizontalLineTo(5.2498f)
                close()
                moveTo(10.4999f, 18.75f)
                horizontalLineTo(13.4999f)
                verticalLineTo(15.0833f)
                horizontalLineTo(10.4999f)
                verticalLineTo(18.75f)
                close()
            }
        }
        .build()
        return _home!!
    }

private var _home: ImageVector? = null
