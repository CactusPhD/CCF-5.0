
package fixdabusdata;

public class BusRoute {
    
    private int BusNum;
    private double x,y;
    private String StopName;
    private String RTime;
    private int StopNum;
    
    public BusRoute(){
    
    }
    
    public BusRoute(int BN,int StopNum, Double x, Double y, String SN){
        this.BusNum = BN;
        this.x = x;
        this.y = y;
        this.StopName = SN;
        this.RTime = null;
        this.StopNum = StopNum;
    }
    
    public int getBusNum(){
        return this.BusNum;
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
    
    public String getStopName(){
        return this.StopName;
    }
    
    public String getRouteTime(){
        return this.RTime;
    }
    
    public int getStopNum(){
        return this.StopNum;
    }
    
    public void setRouteTime(String s){
        this.RTime = s;
    }
}
