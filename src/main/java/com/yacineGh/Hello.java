package com.yacineGh;


public class Hello {

	public static void main(String[] args) {
		Point a = new Point(3, 8);

		System.out.println(a);

		a.homotetie(3);

		System.out.println(a);

		LignePol lignePol = new LignePol(3);

		System.out.println(lignePol);

		lignePol.setPoint(0, new Point(1, 1));
		lignePol.setPoint(1, new Point(3, 8));
		lignePol.setPoint(2, new Point(0, 4));

		System.out.println(lignePol);

		Point points[] = new Point[] { new Point(1, 1), new Point(1, 1),
				new Point(1, 1) };

		LignePol lignePol2 = new LignePol(points);
		
		System.out.println(lignePol2);
		
		lignePol2.homotetie(3);
	
		System.out.println(lignePol2);
		
	}
}
