/**
 * Created by Elina on 15.02.2017.
 */
public class LGWeatherStation extends WeatherStation {
    LGWeatherStation(int temperature, int wind) {
        super(temperature, wind);
        windBehavior = new NoSupportWindBehavior();
    }

    public void getModel() {
        System.out.println("Самая красивая станция от LG!");
    }
}
