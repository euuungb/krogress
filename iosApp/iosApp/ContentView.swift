//
//  ContentView.swift
//  iosApp
//
//  Created by 이동연 on 1/12/25.
//

import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> some UIViewController {
        ViewControllerKt.SampleViewController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
            .edgesIgnoringSafeArea(.all)
            .ignoresSafeArea(.keyboard)
    }
}

#Preview {
    ContentView()
}
