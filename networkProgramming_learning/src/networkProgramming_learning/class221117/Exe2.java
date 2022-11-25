package networkProgramming_learning.class221117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Exe2 {
	public static void main(String[] args) {

		InputStream is = null;
		BufferedReader br = null;

		try {
			URL url = new URL("https://www.ncepu.edu.cn");
			is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is, "utf8"));

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
