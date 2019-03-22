package com.yacineGh;

public class LignePol {
	private Point[] sommets;
	private int nbSommets;

	public LignePol(int n) {
		nbSommets = n;
		sommets = new Point[n];
	}
	
	
	public LignePol(Point[] points) {
		this(points.length);
		for(int pos = 0; pos < nbSommets; pos++)
			setPoint(pos, points[pos]);
	}

	public Point getSommet(int pos) {
		return sommets[pos];
	}

	public void setPoint(int pos, Point point) {
		sommets[pos] = point;
	}
	
	public void homotetie(double k) {
		for(int pos = 0; pos < nbSommets; pos++) {
			Point point = sommets[pos];
			
			if (point == null)
				continue;
			
			point.homotetie(k);
		}
		
	}
	
	@Override
	public String toString() {
		String res = "";
		
		for(int pos = 0; pos < nbSommets; pos++) {
			Point point = sommets[pos];
			res += "[" + pos + ":";
			if (point == null)
				res += "null";
			else
				res += point;
			res += "]";
		}
		
		return res;
	
	}
	
	public void tracer() {
		for(int pos = 0; pos < nbSommets - 1; pos++) {
			Point a = sommets[pos];
			Point b = sommets[pos + 1];
			tracer(a,b);
		}
	}
	
	public void tracer(Point a, Point b) {
		System.out.println("Tracer de ");
		
		if (a == null)
			System.out.print("null");
		else
			System.out.print(a);
		
		System.out.print(" à ");
		
		if (b == null)
			System.out.print("null");
		else
			System.out.print(b);
		
		System.out.println();
	}
}
