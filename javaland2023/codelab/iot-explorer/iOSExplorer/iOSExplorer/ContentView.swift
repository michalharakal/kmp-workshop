import SwiftUI
import shared

struct ContentView: View {
    @StateObject var temperaturePublisher = TemperatureLivePublisher()

       var body: some View {
               TemperatureView(temperature: temperaturePublisher)
       }
}

struct TemperatureView: View {
    @ObservedObject var temperature: TemperatureLivePublisher
    var body: some View {
        VStack {
            Text(temperature.device.label)
            Text(temperature.device.temperature)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
