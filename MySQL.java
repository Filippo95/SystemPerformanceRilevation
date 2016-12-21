
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQL implements  Serializable
{
    String MySqlLog;
    public MySQL() throws IOException
    {
        File f = new File("/var/log/mysql/mysql.log");
        if(f.exists() && !f.isDirectory()) 
        { 
          MySqlLog=getit("cat /var/log/mysql/mysql.log");
        }
        else 
        {
            MySqlLog="Non esiste file di log ";
        }
            
   }
    
    
    
    public String getit(String comd) throws IOException
{
    ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command=comd;
		cmd.execute();		
		return cmd.out;
    
    
}

}
