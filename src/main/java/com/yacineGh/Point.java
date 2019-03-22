package com.yacineGh;

public class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getR() {
		return Math.sqrt(getX() * getX() + getY() * getY());
	}

	public double getT() {
		return Math.atan2(getY(), getX());
	}
	
	void homotetie(double k) {
		x *= k;
		y *= k;
	}

	@Override
	public String toString() {
		return "(x:" + getX() + ", y:" + getY() + ", r:" + getR() + ", t:" + getT() + ")";
	}
}
