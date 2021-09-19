import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Scanner;
public class API {

    Scanner scan = new Scanner(System.in);


      final String url = "https://api.openweathermap.org/data/2.5/weather";
      final String appID = "fb7544dc585471603c86e9a91210b0f6";
      final String units = "imperial";
      ApiKey key = new ApiKey(url, appID, units);

        /*
      System.out.println("Which city are you from?");
      String city = scan.nextLine();
      //ApiKey key = new ApiKey(url, appID, units);
      String jsonString1= key.GetData(city);
      JSONObject jsonParsor1 = new JSONObject(jsonString1);
      Double temp1 = jsonParsor1.getJSONObject("main").getDouble("temp");
      System.out.println(temp1);


      System.out.println("Where are you now?");
      city = scan.nextLine();
      String jsonString2 = key.GetData(city);
      JSONObject jsonParsor2 = new JSONObject(jsonString2);
      Double temp2 = jsonParsor2.getJSONObject("main").getDouble("temp");
      System.out.println(temp2);


      String jsonString3 = key.GetData(city);
      JSONObject jsonParsor3 = new JSONObject(jsonString3);
      int humidity = jsonParsor3.getJSONObject("main").getInt("humidity");
      System.out.println(humidity);

     String jsonString4 = key.GetData(city);
      JSONObject jsonParsor4 = new JSONObject(jsonString4);
      double windSpeed = jsonParsor4.getJSONObject("wind").getDouble("speed");
      System.out.println(windSpeed);
      */
    public double getTemp(String city) {
        //ApiKey key = new ApiKey(url, appID, units);
        String jsonString1 = key.GetData(city);
        System.out.println(jsonString1);
        JSONObject jsonParsor1 = new JSONObject(jsonString1);
        Double temp1 = jsonParsor1.getJSONObject("main").getDouble("temp");
        return temp1;
    }
    /*public double getTempC(String city) {
        String jsonString2 = key.GetData(city);
        JSONObject jsonParsor2 = new JSONObject(jsonString2);
        Double temp2 = jsonParsor2.getJSONObject("main").getDouble("temp");
        return temp2;
    }*/
    public double getWind(String city) {
        String jsonString4 = key.GetData(city);
        JSONObject jsonParsor4 = new JSONObject(jsonString4);
        double windSpeed = jsonParsor4.getJSONObject("wind").getDouble("speed");
        return windSpeed;
    }
    public double getHumidity(String city) {
        String jsonString4 = key.GetData(city);
        JSONObject jsonParsor4 = new JSONObject(jsonString4);
        double windSpeed = jsonParsor4.getJSONObject("main").getDouble("humidity");
        return windSpeed;
    }
}

