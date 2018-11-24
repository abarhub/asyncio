package testasyncio;

import java.nio.charset.StandardCharsets;

public class Tools {


	public static String construitString(int tailleMessage) {
		StringBuilder stringBuilder = new StringBuilder(tailleMessage);

		for(int i=0;i<tailleMessage;i++){
			stringBuilder.append('x');
		}

		final String contenu=stringBuilder.toString();
		stringBuilder=null;
		return contenu;
	}

	public static byte[] construitByteArray(int tailleMessage) {
		String s=construitString(tailleMessage);
		return s.getBytes(StandardCharsets.UTF_8);
	}
}
