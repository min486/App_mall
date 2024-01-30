package desktop.mall.presentation.utils

import java.text.NumberFormat

object NumberUtils {
    // ex) 20000 -> 20,000
    fun numberFormatPrice(price: Int?): String {
        return NumberFormat.getNumberInstance().format(price ?: 0)
    }
}