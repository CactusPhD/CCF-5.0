package fixdabusdata;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FixDaBusData {

    public static void main(String[] args) {
        int counterN = 0;
        int counterW = 0;
        int counterS = 0;
        String listWBus, listSBus;
        BusRoute[] NightBuses = new BusRoute[348];
        BusRoute[] WeekBuses = new BusRoute[700];
        File dayBus = new File("dayBuses.json");

        try {
            PrintWriter output = new PrintWriter(dayBus);
            File WBus = new File("WeekDayBus.txt");
            File SBus = new File("SatBus.txt");
            File NBus = new File("NightRoutes.txt");
            Scanner inputW = new Scanner(WBus);
            Scanner inputS = new Scanner(SBus);
            Scanner inputN = new Scanner(NBus);

            output.print("{ \"type\": \"FeatureCollection\",    \"features\": [");
            while (inputW.hasNext()) {
                String x = inputW.nextLine();
                String[] list = x.split(",");
                //connor did this
                /*String s0 = list[0];
              String s1 = list[1];
              String s2 = list[2];
              String s3 = list[3];
              String StopNW = list[5];
              int BusNumW = Integer.parseInt(s0);
              int StopNumW = Integer.parseInt(s1);
              double xCor = Double.parseDouble(s2);
              double yCor = Double.parseDouble(s3);
              BusRoute DaBus = new BusRoute(BusNumW , StopNumW , xCor , yCor, StopNW);
              System.out.println("StopNW = "+ DaBus.getStopName());
              counterW++;
              System.out.println(counterW);*/

                output.print("{\n"
                        + "    \"attributes\": {\n"
                        + "      \"RouteNumber\": " + list[0] + ",\n"
                        + "      \"StopNumber\": " + list[1] + ",\n"
                        + "      \"StopName\": \""+list[5]+"\"},"
                        + "    \"geometry\": {\n"
                        + "      \"x\": " + list[2] + ",\n"
                        + "      \"y\": " + list[3] + "\n"
                        + "    }\n"
                        + "  },");
            }
            output.print("]}");
//
            /*while (inputS.hasNext()) {
                String s = inputS.nextLine();
                System.out.println(s);
                String[] list = s.split(",");
                String s0 = list[0];
                String s1 = list[1];
                String s2 = list[2];
                String s3 = list[3];
                String StopNS = list[5];
                int BusNumS = Integer.parseInt(s0);
                int StopNumS = Integer.parseInt(s1);
                double xCor = Double.parseDouble(s2);
                double yCor = Double.parseDouble(s3);
                BusRoute DaBus = new BusRoute(BusNumS, StopNumS, xCor, yCor, StopNS);
                System.out.println("StopNS = " + DaBus.getStopName());
                counterS++;
                System.out.println(counterS);
            }

            while (inputN.hasNext()) {
                String s = inputN.nextLine();
                String[] list = s.split(",");
                String s0 = list[0];
                String s1 = list[1];
                String s2 = list[2];
                String s3 = list[3];
                String StopNN = list[5];
                int BusNumN = Integer.parseInt(s0);
                int StopNumN = Integer.parseInt(s1);
                double xCor = Double.parseDouble(s2);
                double yCor = Double.parseDouble(s3);
                BusRoute DaBus = new BusRoute(BusNumN, StopNumN, xCor, yCor, StopNN);
                NightBuses[counterN] = DaBus;
                counterN++;
            }
*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("night bus num = " + NightBuses[340].getBusNum());
    }

}
