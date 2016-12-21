import java.io.*;
public class HDD implements  Serializable
{
	String GeneralInfo;
	String SMARTData;
	public HDD() throws IOException
	{
		GeneralInfo=this.getGeneralInfo();
		SMARTData=this.getSMARTData();
	}
	private String getSMARTData() throws IOException  
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="smartctl -a /dev/sda";
		cmd.execute();		
		return cmd.out;
	}
	private String getGeneralInfo() throws IOException 
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="df";
		cmd.execute();		
		return cmd.out;
	}

}
