import java.net.*;
import java.io.*;

public class importAPI{
    URL url;
    HttpURLConnection connection;
     BufferedReader reader;
    public importAPI(String x){

        try{

            this.url=new URL(x);
            this.connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
             reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        }catch(IOException e ){
            System.out.println("IOException LOL");
        }


    }
}
