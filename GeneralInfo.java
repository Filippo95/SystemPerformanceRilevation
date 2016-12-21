import java.io.*;

public class GeneralInfo implements  Serializable
{
	String BIOS;
	String Sistema;
	String Baseboard;
	String Chassis;
	String Processor;
	String MemoryController;
        
        String Mac;
        String MotherBoardSerial;
        String ProcessorSerial;
	
	public GeneralInfo() throws IOException, InterruptedException
	{
		BIOS=this.getBIOS().replace("    ", "\n");
		Sistema=this.getSystem().replace("    ", "\n");
		Baseboard=this.getBaseboard().replace("    ", "\n");
		Chassis=this.getChassis().replace("    ", "\n");
		Processor=this.getProcessor().replace("    ", "\n");
		MemoryController=this.getMemoryController().replace("    ", "\n");
                Mac=this.getMac().replace("    ", "\n");
                MotherBoardSerial=getMotherBoardSerial().replace("    ", "\n");
                ProcessorSerial=getProcessorSerial().replace("    ", "\n");
	}
	
	
	public String getBIOS() throws IOException, InterruptedException
	{
			ExecuteShellComand cmd=new ExecuteShellComand();
			cmd.Command="dmidecode -t 0";
			cmd.execute();		
			return cmd.out;
	}
		
	public String getSystem() throws IOException, InterruptedException
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="dmidecode -t 1";
		cmd.execute();	
		return cmd.out;
		
	}
		
	public String getBaseboard() throws IOException, InterruptedException
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="dmidecode -t 2";
		cmd.execute();		
		return cmd.out;
	}
	
	public String getChassis() throws IOException, InterruptedException
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="dmidecode -t 3";
		cmd.execute();		
		return cmd.out;
	}

	public String getProcessor() throws IOException, InterruptedException
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="dmidecode -t 4";
		cmd.execute();	
		return cmd.out;
	}

	public String getMemoryController() throws IOException, InterruptedException
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="dmidecode -t 5";
		cmd.execute();	
		return cmd.out;
	}
        public String getMac() throws IOException
        {
            ExecuteShellComand cmd=new ExecuteShellComand();
	cmd.Command="ifconfig |grep \"HWaddr\"";
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
        public String getMotherBoardSerial() throws IOException
        {
            ExecuteShellComand cmd=new ExecuteShellComand();
	cmd.Command="dmidecode -t 2 |grep \"Serial Number:\"";;
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
        public String getProcessorSerial() throws IOException
        {
            ExecuteShellComand cmd=new ExecuteShellComand();
	cmd.Command="dmidecode -t 4 |grep \"ID:\"";
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
