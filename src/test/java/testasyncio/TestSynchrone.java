package testasyncio;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestSynchrone {

	@Test
	public void testSync1() throws IOException {

		final int COMPTEUR = 5000;
		final long date = System.currentTimeMillis();

		final int TAILLE_MESSAGE = 500*1024;

		final byte[] buf = Tools.construitByteArray(TAILLE_MESSAGE);

		final long debut = System.currentTimeMillis();

		try {
			for (int i = 0; i < COMPTEUR; i++) {
				String nomFichier = "fichier_" + date + "_" + i + ".txt";
				Path p = Paths.get(Constant.REP_SYNCHRONE, nomFichier);

				Files.write(p, buf);
			}
		} catch (IOException e) {
			System.err.println("Erreur");
			e.printStackTrace();
			throw e;
		}

		final long fin = System.currentTimeMillis();

		final long duree = fin - debut;

		System.out.printf("Test synchrone: nb op=%d,taille fichier=%d, duree=%d ms, moyenne=%d ms",
				COMPTEUR, TAILLE_MESSAGE, duree, duree / COMPTEUR);
	}

}
