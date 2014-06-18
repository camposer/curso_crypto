import java.io.FilePermission;
import java.net.SocketPermission;
import java.security.AccessController;


public class Cec {
	public static void main(String[] args) {
		
//		AccessController.checkPermission(new FilePermission("tmp/quijote.txt", "read"));
		SecurityManager sm = new SecurityManager();
		sm.checkRead("tmp/quijote.txt");
	}
}
