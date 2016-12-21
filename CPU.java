import java.io.*;

public class CPU implements  Serializable
{
	String GeneralInfo;
	String Temp;
	String Usage;
	public CPU() throws IOException
	{
		GeneralInfo=this.getGeneralInfo();
		Temp=this.getTemp();
		Usage=this.getUsage();
	}
	public String getUsage() throws IOException 
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="top -n 1 |grep \"%Cpu(s)\"";
		cmd.execute();		
		return cmd.out;
		
	}
	public String getGeneralInfo() throws IOException
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="lscpu";
		cmd.execute();		
		return cmd.out;
	}
	public String getTemp() throws IOException
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="sensors";
		try
		{
			    cmd.executor();
		}
		catch(InterruptedException e)
			{
			  System.out.println("Errore"+e.getMessage());
			}
		return cmd.out;
		
	}
}
