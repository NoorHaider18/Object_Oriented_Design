/**
 * A java program to demonstrate Dependency Inversion Principle.
 * Abstraction for weather service.
 *
 * @author Noor Haider Khan
 * @version 1.0
 * @since 2024-04-21
 */
interface WeatherService {
    /**
     * Fetches weather data for a given location.
     *
     * @param location The location for which weather data is to be fetched.
     * @return The weather data for the specified location.
     */
    String getWeather(String location);
}

/**
 * High-level module representing the weather application.
 */
class WeatherApp {
    private final WeatherService weatherService;

    /**
     * Constructs a WeatherApp with the specified weather service.
     *
     * @param weatherService The weather service to be used.
     */
    public WeatherApp(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Displays weather data for a given location.
     *
     * @param location The location for which weather data is to be displayed.
     */
    public void displayWeather(String location) {
        // Fetch weather data using the weather service
        String weatherData = weatherService.getWeather(location);
        System.out.println("Weather in " + location + ": " + weatherData);
    }
}

/**
 * Low-level module representing the weather service implementation using OpenWeatherMap API.
 */
class OpenWeatherMapService implements WeatherService {
    @Override
    public String getWeather(String location) {
        // Simulate fetching weather data from OpenWeatherMap API
        return "Sunny";
    }
}

/**
 * Low-level module representing the weather service implementation using AccuWeather API.
 */
class AccuWeatherService implements WeatherService {
    @Override
    public String getWeather(String location) {
        // Simulate fetching weather data from AccuWeather API
        return "Cloudy";
    }
}

/**
 * Demo class demonstrating the Dependency Inversion Principle.
 */
public class Dependency_Inversion_Principle {
    public static void main(String[] args) {
        // Using OpenWeatherMapService as the weather service
        WeatherService openWeatherMapService = new OpenWeatherMapService();
        WeatherApp weatherAppWithOpenWeatherMap = new WeatherApp(openWeatherMapService);
        weatherAppWithOpenWeatherMap.displayWeather("New York");

        // Using AccuWeatherService as the weather service
        WeatherService accuWeatherService = new AccuWeatherService();
        WeatherApp weatherAppWithAccuWeather = new WeatherApp(accuWeatherService);
        weatherAppWithAccuWeather.displayWeather("London");
    }
}
