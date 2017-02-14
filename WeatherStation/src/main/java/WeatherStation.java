/**
 * Created by Elina on 14.02.2017.
 */
public abstract class WeatherStation {

    private String model;
    private int temperature;
    private int wind;
    WindBehavior windBehavior;

    WeatherStation(int temperature, int wind){
        this.temperature = temperature;
        this.wind = wind;
    }

    public abstract void getModel();

    public void getTemperature() {
        System.out.println("текущая температура: " + temperature);
    }

    public void getWind(){
        windBehavior.getWind(wind);
    }

    public void setWindBehavior(WindBehavior windBehavior)
    {this.windBehavior = windBehavior;}

}
