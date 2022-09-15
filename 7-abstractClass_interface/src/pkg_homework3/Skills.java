package pkg_homework3;

import java.util.Scanner;

public interface Skills {
	public abstract void filmPerform();

	public abstract void videoPerform();

	public abstract void songsinging();
}

class Artist implements Skills {
	private String name;
	private int age;
	private String film;
	private String video;
	private String song;

	@Override
	public void filmPerform() {
		// TODO Auto-generated method stub
		if (this.film == null) {
			System.out.println("please set the film");
			String setPara = new Scanner(System.in).nextLine();
			this.setFilm(setPara);
			System.out.println("set successfully");
			System.out.println("the information: \n\t" + this.toString());
			filmPerform();
		} else {
			System.out.println(this.name + "演过《" + this.film + "》");
		}
	}

	@Override
	public void videoPerform() {
		// TODO Auto-generated method stub
		if (this.video == null) {
			System.out.println("please set the video");
			String setPara = new Scanner(System.in).nextLine();
			this.setVideo(setPara);
			System.out.println("set successfully");
			System.out.println("the information: \n\t" + this.toString());
			videoPerform();
		} else {
			System.out.println(this.name + "演过《" + this.video + "》");
		}
	}

	@Override
	public void songsinging() {
		// TODO Auto-generated method stub
		if (this.song == null) {
			System.out.println("please set the song");
			String setPara = new Scanner(System.in).nextLine();
			this.setSong(setPara);
			System.out.println("set successfully");
			System.out.println("the information: \n\t" + this.toString());
			songsinging();
		} else {
			System.out.println(this.name + "唱过《" + this.song + "》");
		}
	}

	@Override
	public String toString() {
		return "Artist [name = " + name + ", age = " + age + ", film = " + film + ", video = " + video + ", song = "
				+ song + "]";
	}

	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Artist(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

}
