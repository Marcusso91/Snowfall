package javaapplication1;

import java.awt.*;

public class Ball {

    // FallingBall Size
    private int radius;
    // Center of Call
    private Point location;
    // Color of the ball
    private Color color;
    private int dx, dy;

    public Ball(Point p, int r) {
        this.location = p;
        this.color = Color.WHITE;
        this.radius = r;
    }

    public int getRadius() {
        return radius;
    }

    public Point getLocation() {
        return location;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void move() {
        location.translate(dx, dy);
    }

    public void setMotion(int dx, int dy) {

        this.dx = dx;
        this.dy = dy;
    }

    public void moveTo(int x, int y) {
        location.move(x, y);
    }
  //Drawing the ball
    public void paint(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillOval(location.x - radius, location.y - radius, 2 * radius, 2 * radius);
    }

}
