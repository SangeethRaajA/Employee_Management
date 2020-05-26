import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	private String pass;
	
	protected String generateHash(String pass) throws NoSuchAlgorithmException
	{
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.reset();
		byte[] hash = digest.digest(pass.getBytes());
		return bytesToString(hash);
	
	
	}

	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	private static String bytesToString(byte[] bytes) {
		char[] hexChar = new char[bytes.length*2]; 
		for(int j=0; j<bytes.length; j++)
		{
			int v = bytes[j] & 0xFF;
			hexChar[j*2] =hexArray[v >>> 4];
			hexChar[j*2+1] = hexArray[v &  0x0F];
			
		}
		
		
		return new String(hexChar);
	}
	
}
