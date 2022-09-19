package pkg_homework3;

public enum Season {
	
//	定义枚举类：季节，并编写方法输出月份，输出季节。 

	SPRING("3-5", "spring"), SUMMER("6-8", "summer"), AUTUMN("9-11", "autumn"), WINTER("12-2", "winter");

	private final String seasonLast;
	private final String seasonName;

	private Season(String seasonLast, String seasonName) {
		this.seasonLast = seasonLast;
		this.seasonName = seasonName;
	}

	public String getSeasonLast() {
		return seasonLast;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public void showSeasonInfo() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Season{" + "seasonLast='" + seasonLast + '\'' + ", seasonName='" + seasonName + '\'' + '}';
	}

}
