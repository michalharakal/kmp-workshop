import SwiftUI
import shared

struct ContentView: View {
    @StateObject var temperaturePublisher = TemperatureLivePublisher()

       var body: some View {
           VStack {
               TemperatureView(temperature: temperaturePublisher)
                   .navigationTitle("Autobahnen")
           }
       }
}

struct TemperatureView: View {
    @ObservedObject var temperature: TemperatureLivePublisher
    var body: some View {
                Text(temperature.device.label)
                Text(temperature.device.temperature)
        }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
