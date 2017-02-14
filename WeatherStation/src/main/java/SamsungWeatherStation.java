/**
 * Created by Elina on 15.02.2017.
 */
public class SamsungWeatherStation extends WeatherStation {
    SamsungWeatherStation(int temperature, int wind) {
        super(temperature, wind);
        windBehavior = new NoSupportWindBehavior();
    }

    public void getModel() {
        System.out.println("Самая доступная станция от Samsung!");
    }
}
