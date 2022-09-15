package pkg_homework3;

public class ArtistTest {
	public static void main(String[] args) {
		Artist Liudh = new Artist("刘德华", 62);
		Liudh.setFilm("彩云曲");
		Liudh.setVideo("神雕侠侣");
		Liudh.filmPerform();
		Liudh.videoPerform();
		Liudh.songsinging();

		// output
//		刘德华演过《彩云曲》
//		刘德华演过《神雕侠侣》
//		please set the song
//		忘情水
//		set successfully
//		the information: 
//			Artist [name = 刘德华, age = 62, film = 彩云曲, video = 神雕侠侣, song = 忘情水]
//		刘德华唱过《忘情水》
	}
}
