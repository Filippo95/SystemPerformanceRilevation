
import java.io.IOException;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author filippo
 */
public class TOP implements  Serializable{
    String  data;
    public TOP() throws IOException
    {
        data=getData();
    }
    private String getData() throws IOException  
	{
		ExecuteShellComand cmd=new ExecuteShellComand();
		cmd.Command="top -n 1";
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
