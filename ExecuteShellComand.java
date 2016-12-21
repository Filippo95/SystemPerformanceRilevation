
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExecuteShellComand 
{
	String Command;
	String out;
	String error;
	
	
	public void  execute() throws IOException {
		String Stringa;

		Process cmdProc = Runtime.getRuntime().exec(this.Command);

		BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(cmdProc.getInputStream()));
		String line;
		while ((line = stdoutReader.readLine()) != null) 
		{
		   // process procs standard output here
			Stringa=line+"\n";
			
			this.out+=Stringa;
		}

		BufferedReader stderrReader = new BufferedReader(
		         new InputStreamReader(cmdProc.getErrorStream()));
		while ((line = stderrReader.readLine()) != null) {
		   this.error+=line;
		}
		
		
		
	}
	public void executor()throws IOException, InterruptedException
	{
		// you need a shell to execute a command pipeline
	    List<String> commands = new ArrayList<String>();
	    commands.add("/bin/sh");
	    commands.add("-c");
	    commands.add(this.Command);

	    SystemCommandExecutor commandExecutor = new SystemCommandExecutor(commands);
	    
	    int result = commandExecutor.executeCommand();
	    
	    StringBuilder stdout = commandExecutor.getStandardOutputFromCommand();
	    StringBuilder stderr = commandExecutor.getStandardErrorFromCommand();

	    this.out=stdout.toString();

	    
	    this.error=stderr.toString();
	}

}