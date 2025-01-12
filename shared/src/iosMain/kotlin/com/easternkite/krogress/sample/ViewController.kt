package com.easternkite.krogress.sample

import androidx.compose.ui.window.ComposeUIViewController
import com.easternkite.krogress.shared.App

fun SampleViewController() =
    ComposeUIViewController {
        println("Hello, world")
        App()
        println("Hello, world2")
    }