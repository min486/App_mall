package desktop.mall.presentation.ui

import androidx.compose.ui.graphics.vector.ImageVector
import desktop.mall.presentation.ui.iconpack.Basket
import desktop.mall.presentation.ui.iconpack.Chat
import desktop.mall.presentation.ui.iconpack.Document
import desktop.mall.presentation.ui.iconpack.Event
import desktop.mall.presentation.ui.iconpack.Heart
import desktop.mall.presentation.ui.iconpack.HeartFilled
import desktop.mall.presentation.ui.iconpack.Home
import desktop.mall.presentation.ui.iconpack.Menu
import desktop.mall.presentation.ui.iconpack.Search
import desktop.mall.presentation.ui.iconpack.Smile
import kotlin.collections.List as ____KtList

public object IconPack

private var __AllIcons: ____KtList<ImageVector>? = null

public val IconPack.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Search, Home, Event, Document, HeartFilled, Smile, Chat, Menu, Basket, Heart)
    return __AllIcons!!
  }
