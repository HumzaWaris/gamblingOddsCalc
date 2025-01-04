
import java.io.*;
import java.net.*;
import java.util.*;

public class bettingOnTeam {

    public bettingOnTeam(){

    }

    public static String findingGame(String team){
        String game=null;
        try{

            importAPI nfl1= new importAPI("https://api.the-odds-api.com/v4/sports/americanfootball_nfl/odds?regions=us&oddsFormat=american&apiKey=af02481c6a2332a6829d81d8509c6a65");
            String line=nfl1.reader.readLine();
            String[] APISplit=line.split("]}]}]}");
            ArrayList<String> Relevant= new ArrayList<>();



            for(int i=0;i<APISplit.length;i++){
                if(APISplit[i].contains(team)){
                    Relevant.add(APISplit[i]);
                }
            }

            if(Relevant.isEmpty()){

                System.out.println("Sorry you suck this game isnt real");
            }else{
                game=Relevant.get(0);
                System.out.println("Wow good boy you found a game");
            }
            nfl1.reader.close();


        }catch(IOException e){
            System.out.println("Unknown Network Error");
        }
        return game;
    }

    public static String[][] neat(String data, String team){
        String[] filter1=data.split("\"title");
        String[] newer= new String[filter1.length-1];
        String[][] export= new String[newer.length][2];
        for(int i=1;i<filter1.length;i++){
            newer[i-1]=filter1[i];

        }
        for(int i=0;i<newer.length;i++){
            String x=newer[i];
            String name=x.substring(3,x.indexOf("last_update")-3);
            String outcomes=x.substring(x.indexOf("outcomes")+10);
            if(outcomes.contains("key")){
                outcomes=outcomes.substring(0,outcomes.indexOf("key")-7);
            }
            outcomes=outcomes.substring(outcomes.indexOf(team));
            outcomes=outcomes.substring(outcomes.indexOf(":")+1,outcomes.indexOf("}"));
            export[i][0]=name;
            export[i][1]=outcomes;

        }
        return export;


    }

}
