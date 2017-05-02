package Default;

public class Users{
	private int Id;
    private String web;
    private String user;
    private String pass;
    
    public Users(int id,String website,String username,String password){
        this.Id = id;
        this.web = website;
        this.user = username;
        this.pass = password;
    }
    
    public int getId(){
        return this.Id;
    }
    
    public String getWeb(){
        return this.web;
    }
    
    public String getUser(){
        return this.user;
    }
    
    public String getPass(){
        return this.pass;
    } 
}
