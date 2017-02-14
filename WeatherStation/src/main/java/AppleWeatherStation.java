/**
 * Created by Elina on 15.02.2017.
 */
public class AppleWeatherStation extends WeatherStation {


    AppleWeatherStation(int temperature,int wind) {
        super(temperature, wind);
        windBehavior = new NormalWindBehavior();
    }

    public void getModel() {
        System.out.println("Самая модная станция от Apple!");
    }
}
