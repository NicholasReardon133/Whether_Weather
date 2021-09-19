import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ApiKey {
    String baseURL;
    String appID;
    String units;

    ApiKey(String baseURL, String appID, String units) {
        this.baseURL = baseURL;
        this.appID = appID;
        this.units = units;
    }

    public String GetData(final String city) {
        String query = "q=" + city + "&units=" + units;
        String httpsURL = baseURL + "?" + query + "&appid=" + appID;

        String data = "";

        try {
            URL myUrl = new URL(httpsURL);
            HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String inputLine;


            while ((inputLine = br.readLine()) != null) {
                //inputLine = br.readLine();
                data = inputLine;
                //System.out.println(inputLine);
            }

            br.close();
        }
        catch(Exception e) {
            System.out.println("Exception" + e.getMessage());
        }

        return data;
    }
}
