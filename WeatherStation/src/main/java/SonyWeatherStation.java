/**
 * Created by Elina on 15.02.2017.
 */
public class SonyWeatherStation extends WeatherStation {
    SonyWeatherStation(int temperature,int wind) {
        super(temperature, wind);
        windBehavior = new NormalWindBehavior();
    }

    public void getModel() {
        System.out.println("Самая надёжная станция от Sony!");
    }
}
