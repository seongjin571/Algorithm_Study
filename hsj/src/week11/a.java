package week11;

import java.util.ArrayList;
import java.util.List;

class Point{
	int x;
	int y;
}
public class a {
	public static void main(String[]args) {
		List<Point> list = new ArrayList<>();
		Point p = null;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				p.x = i;
				p.y = j;
				list.add(p);
			}
		}
		for(Point p1 : list) {
			System.out.println(p1.x + "  " + p1.y);
		}
	}
}
