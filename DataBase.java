import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet; 
import java.sql.ResultSet;

public class DataBase
{
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    public DataBase(String host,String DataBaseName,String connectionUser,String connectionPassword ) 
        {
		
		try 
                {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
                        System.out.println("Driver Loaded");
			
                        String connectionUrl = "jdbc:mysql://"+host+":3306/"+DataBaseName;
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                        System.out.println("Connected!");
                } 
                catch (Exception e)
                {
			e.printStackTrace();
		} 
                
	}
    public void SelectQuery(String Query) throws SQLException
    {
        stmt = conn.createStatement();
	rs = stmt.executeQuery(Query);
	while (rs.next()) 
        {
            String id = rs.getString("id");
        }
    }
    public void InsertRilevation(Rilevazione rl,int DeviceID) throws SQLException
    {
         System.out.println("Insert Rilevation");
        
        String Query="INSERT INTO `Rilevation`"
                + "( `IDDevice`,               `ApacheLog`,         `ApacheError`,             `CpuGeneralInfo`,                           `CpuTemp`,                          `CpuUsage`,              `GeneralInfoBIOS`,             `GeneralInfoSistema`,               `GeneralInfoBaseboard`,         `GeneralInfoChassis`,                `GeneralInfoProcessor`,            `GeneralInfoMemoryController`,              `HDDGeneralInfo`,           `HDDSmartData`,             `KernerlLog`,           `MySQLLog`,         `RAMGeneralInfo`,                       `RAMSwapTotal`,                         `RAMSwapFree`,                      `RAMTotal`,                 `RAMFree`,                        `Top`) "
         + "VALUES ('"+DeviceID+"','"+rl.apache.ApacheLogs+"','"+rl.apache.ApacheError+"','"+rl.ControlProcessingUnit.GeneralInfo+"','"+rl.ControlProcessingUnit.Temp+"','"+rl.ControlProcessingUnit.Usage+"','"+rl.GeneralInformation.BIOS+"','"+rl.GeneralInformation.Sistema+"','"+rl.GeneralInformation.Baseboard+"','"+rl.GeneralInformation.Chassis+"','"+rl.GeneralInformation.Processor+"','"+rl.GeneralInformation.MemoryController+"','"+rl.HardDrive.GeneralInfo+"','"+"','"+"','"+rl.mysql.MySqlLog+"','"+rl.RandomAccessMemory.GeneralInfo+"','"+rl.RandomAccessMemory.SwapTotal+"','"+rl.RandomAccessMemory.SwapFree+"','"+rl.RandomAccessMemory.Total+"','"+rl.RandomAccessMemory.Free+"','"+rl.top.data+"')";
	Query=Query.replace("\n", "-space-").replace("\t", "-tab-");
         stmt = conn.createStatement();
        stmt.executeUpdate(Query);
    }
    public int isDeviceInDatabase(Rilevazione rl) throws SQLException
    {
         System.out.println("Il device è nel database?");
        rl.GeneralInformation.Mac= rl.GeneralInformation.Mac.replace("Link encap:Ethernet"," ");
        rl.GeneralInformation.Mac= rl.GeneralInformation.Mac.replace("\n"," ");
         rl.GeneralInformation.MotherBoardSerial= rl.GeneralInformation.MotherBoardSerial.replace("\n"," ");
         rl.GeneralInformation.ProcessorSerial= rl.GeneralInformation.ProcessorSerial.replace("\n"," ");
         
        String Query="SELECT * FROM `Devices` WHERE MAC='"+rl.GeneralInformation.Mac+"'"+
                        "AND MotherboardSerial='"+rl.GeneralInformation.MotherBoardSerial +"'"+
                        "AND ProcessorSerial='"+rl.GeneralInformation.ProcessorSerial+"'";
  
        stmt = conn.createStatement();
	rs = stmt.executeQuery(Query);
	if(rs.next()) 
        {
            System.out.println("Il device è presente nel database e ha id: "+ rs.getInt("ID"));
            return rs.getInt("ID");
            
        }
        else
        {
            System.out.println("Il device non è presente nel database");
            return 0;
        }
        
        
        
    }
    public int InsertDevice(Rilevazione rl) throws SQLException
    {
         System.out.println("Insert Device");
        int auto_id=0;
        String Query="INSERT INTO `Devices`( `MAC`,                                      `MotherboardSerial`,                   `ProcessorSerial`) "
                + "              VALUES ('"+rl.GeneralInformation.Mac+"','"+rl.GeneralInformation.MotherBoardSerial+"','"+rl.GeneralInformation.ProcessorSerial+"')";
        System.out.println(Query);
        stmt = conn.prepareStatement(Query, Statement.RETURN_GENERATED_KEYS);
        stmt.execute(Query, auto_id);
       return auto_id;
    }
}
    

    

