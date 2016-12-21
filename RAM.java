import java.io.*;
public class RAM implements  Serializable
{
	String GeneralInfo;
	String SwapTotal;
	String SwapFree;
	String Total;
	String Free;
	
	public RAM() throws IOException, InterruptedException
	{
		GeneralInfo=this.getGeneralInfo();
		SwapTotal=this.getSwapTotal();
		SwapFree=this.getSwapFree();
		Total=this.getTotal();
		Free=this.getFree();
		
	}

	private String getFree() throws IOException, InterruptedException 
	{
            ExecuteShellComand cmd=new ExecuteShellComand();
	cmd.Command="less /proc/meminfo |grep \"MemFree\"";
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

	private String getTotal() throws IOException , InterruptedException 
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="less /proc/meminfo |grep \"MemTotal\"";
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

	private String getSwapFree() throws IOException , InterruptedException 
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="less /proc/meminfo |grep \"SwapFree\"";
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

	private String getSwapTotal() throws IOException, InterruptedException 
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="less /proc/meminfo |grep \"SwapTotal\"";
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

	private String getGeneralInfo() throws IOException, InterruptedException 
	{
		
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="dmidecode -t 6";
		cmd.executor();		
		return cmd.out;
		
		
	}
}
