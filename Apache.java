
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Apache implements  Serializable
{
	String ApacheLogs;
	
        String ApacheError;
        public Apache() throws IOException
        {
              ApacheLogs=this.getApacheLogs();
              
              ApacheError=this.getApacheError();
            
        }
        public static String getApacheError() throws IOException
        {
            File f2= new File("/var/log/apache2/error.log");
                if(f2.exists() && !f2.isDirectory()) 
                { 
                  return getit("cat /var/log/apache2/error.log");
                }
                else 
                {
                     return"Non esiste file di log ";
                }
        }
        public static String getApacheLogs() throws IOException
        {
            File f = new File("/var/log/apache2/access.log");
                if(f.exists() && !f.isDirectory()) 
                { 
                  return getit("cat /var/log/apache2/access.log");
                }
                else 
                {
                    return "Non esiste file di log ";
                }
        }
        
    public static String getit(String comd) throws IOException
    {
        ExecuteShellComand cmd=new ExecuteShellComand();
                    cmd.Command=comd;
                    cmd.execute();		
                    return cmd.out;


    }
}
