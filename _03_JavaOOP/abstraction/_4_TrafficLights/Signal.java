package abstraction._4_TrafficLights;

public class Signal {

    private TrafficLights light;

    public Signal(String light) {
	this.light = TrafficLights.valueOf(light);
    }

    public String getNextLight() {
	int index = this.light.ordinal();
	TrafficLights[] lights = TrafficLights.values();
	this.light = lights[(index + 1) % 3];

	return this.light.name();

    }
}
