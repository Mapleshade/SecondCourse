/**
 * Created by Elina on 15.02.2017.
 */
public class Main {



    public static void main(String[] args) {

        int temperature = 10;
        int wind = 2;

        System.out.println("Станция Apple:");
        AppleWeatherStation apple = new AppleWeatherStation(temperature,wind);
        apple.getModel();
        apple.getTemperature();
        apple.getWind();
        System.out.println();

        System.out.println("Станция Sony:");
        SonyWeatherStation sony = new SonyWeatherStation(temperature,wind);
        sony.getModel();
        sony.getTemperature();
        sony.getWind();
        System.out.println();

        System.out.println("Станция LG:");
        LGWeatherStation lg = new LGWeatherStation(temperature,wind);
        lg.getModel();
        lg.getTemperature();
        lg.getWind();
        System.out.println();

        System.out.println("Станция Samsung:");
        SamsungWeatherStation samsung = new SamsungWeatherStation(temperature,wind);
        samsung.getModel();
        samsung.getTemperature();
        samsung.getWind();
    }
}
