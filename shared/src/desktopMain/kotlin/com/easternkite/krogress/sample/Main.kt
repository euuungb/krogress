package com.easternkite.krogress.sample

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.easternkite.krogress.shared.App

fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Krogress"
        ) {
            App()
        }
    }
}