import java.io.IOException;
import java.io.Serializable;
import java.util.*;


public class Rilevazione implements  Serializable
{
	Date DataOra = new Date();
	GeneralInfo GeneralInformation ;
	CPU ControlProcessingUnit;
	RAM RandomAccessMemory;
	HDD HardDrive;
	Apache apache;
        Kernel kernel;
        MySQL mysql;
        TOP top;
	public Rilevazione() throws IOException, InterruptedException
	{
		
		GeneralInformation=new GeneralInfo();
		ControlProcessingUnit=new CPU();
		RandomAccessMemory=new RAM();
		HardDrive=new HDD();
		apache=new Apache();
                kernel=new Kernel();
                mysql=new MySQL();
                top=new TOP();
		
	}
	public void printit()
	{
		System.out.println("--------------------------------GENERAL INFORMATION------------------------------------------");
		System.out.println("----BIOS");
		System.out.println(this.GeneralInformation.BIOS);
		
		System.out.println("----MotherBoard");
		System.out.println(this.GeneralInformation.Baseboard);
		System.out.println("----CPU");
		System.out.println(this.GeneralInformation.Processor);
		System.out.println("----Memory Comtroller");
		System.out.println(this.GeneralInformation.MemoryController);
		System.out.println("----System");
		System.out.println(this.GeneralInformation.Sistema);
		System.out.println("----Chassis");
		System.out.println(this.GeneralInformation.Chassis);
		
		System.out.println("--------------------------------CPU---------------------------------------------------------");
		System.out.println("----General");
		System.out.println(this.ControlProcessingUnit.GeneralInfo);
		System.out.println("----Temperature");
		System.out.println(this.ControlProcessingUnit.Temp);
		System.out.println("----Usage");
		System.out.println(this.ControlProcessingUnit.Usage);
		
		
		
		System.out.println("--------------------------------RAM----------------------------------------------------------");
		System.out.println("----General");
		System.out.println(this.RandomAccessMemory.GeneralInfo);
		System.out.println("----Free");
		System.out.println(this.RandomAccessMemory.Free);
		System.out.println("----Total");
		System.out.println(this.RandomAccessMemory.Total);
		
		System.out.println("----Swap Free");
		System.out.println(this.RandomAccessMemory.SwapFree);
		System.out.println("----Swap Total");
		System.out.println(this.RandomAccessMemory.SwapTotal);
		
		
		
		System.out.println("--------------------------------HDD----------------------------------------------------------");
		System.out.println("----General");
		System.out.println(this.HardDrive.GeneralInfo);
		
		System.out.println("----SMART SCAN");
		System.out.println(this.HardDrive.SMARTData);
                 System.out.println("--------------------------------Kernel----------------------------------------------------------");
		System.out.println("----LOG");
		System.out.println(this.kernel.KernelLog);
		System.out.println("--------------------------------Apache----------------------------------------------------------");
		System.out.println("----LOG");
	
                System.out.println("--------------------------------MYSQL----------------------------------------------------------");
		System.out.println("----LOG");
		System.out.println(this.mysql.MySqlLog);
                 System.out.println("--------------------------------TOP----------------------------------------------------------");
		System.out.println("----TOP");
		System.out.println(this.top.data);
               
	}
        
	
}
