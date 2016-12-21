
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;


public class Kernel implements  Serializable
{
String KernelLog; 

public Kernel() throws IOException
{
    KernelLog=getit();
}        

public String getit() throws IOException
{
    ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="dmesg";
		cmd.execute();		
		return cmd.out;
    
    
}
}

