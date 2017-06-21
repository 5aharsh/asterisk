package Default;

public class Log{
	private int id;
    private String time;
    private String activity;
    
    public Log(int id, String time, String activity){
        this.id = id;
        this.time = time;
        this.activity = activity;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getTime(){
        return this.time;
    }
    
    public String getActivity(){
        return this.activity;
    }
}
