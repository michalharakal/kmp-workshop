//
//  TemperatureLivePublisher.swift
//  iOSExplorer
//
//  Created by Michal Harakal on 19.03.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

import SwiftUI
import Combine
import shared

class TemperatureLivePublisher: ObservableObject {
    @Published var device = DevicePresentationModel(label: "JavaLand", temperature: "3.33")
}

class TemperaturePreviewPublisher: TemperatureLivePublisher {
    override init() {
        super.init()
        
        device = DevicePresentationModel(label: "JavaLand", temperature: "3.33")
    }
}

class RoadsLivePublisher: TemperatureLivePublisher {
    override init() {
        super.init()
        let viewModel = DeviceViewModel.Companion.init().create()
        let roadsStateCommonFlow = viewModel.getCommonFlowFromIos()

        roadsStateCommonFlow.watch { deviceState in
            if let deviceState = deviceState {
                self.objectWillChange.send()
                self.device = deviceState
            }
        }
    }
}
