

public class Authentication {
    private String u_name;
    private String u_email;
    private String number;
    private String u_pass;
    private String confirm_pass;
    Authentication(){
        u_name=" ";
        u_email=" ";
        number=" ";
        u_pass=" ";
        confirm_pass=" ";
    }
    
    public void login(String u_n,String pass){
        u_name=u_n;
        u_pass=pass;
        
        
    }
    public void register(String u_nam,String eml,String num,String pass,String conf_pass){
        u_name=u_nam;
        u_email=eml;
        number=num;
        u_pass=pass;
        confirm_pass=conf_pass;
        
        
      
    }
    
}
