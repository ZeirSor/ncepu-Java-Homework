package pkg_homework3;

public class SeasonTest {
	public static void main(String[] args) {

//		定义枚举类：季节，并编写方法输出月份，输出季节。 

		Season.SPRING.showSeasonInfo();
		Season.SUMMER.showSeasonInfo();
		Season.AUTUMN.showSeasonInfo();
		Season.WINTER.showSeasonInfo();

		// output
//		Season{seasonLast='3-5', seasonName='spring'}
//		Season{seasonLast='6-8', seasonName='summer'}
//		Season{seasonLast='9-11', seasonName='autumn'}
//		Season{seasonLast='12-2', seasonName='winter'}
	}
}
