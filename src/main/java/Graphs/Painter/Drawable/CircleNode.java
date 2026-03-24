package Graphs.Painter.Drawable;

import java.awt.*;

public class CircleNode {
    private static final int DEFAULT_RADII = 30;
    public int x;
    public int  y;
    int radius;
    private String identifier;
    private static Color[] c = new Color[] {
            Color.RED,
            Color.blue,
            Color.cyan,
            Color.GRAY,
            Color.yellow,
            Color.pink,
            Color.MAGENTA
    };

    public CircleNode(int x, int y) {
        this(x,y,DEFAULT_RADII);
    }

    public CircleNode(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.radius = r;
    }

    public void paintNode(Graphics g) {
        g.setColor((c[(int)(Math.random()*c.length)]));
        g.fillOval(this.x, this.y, this.radius, this.radius);
        g.drawString(identifier,this.x,this.y);
    }

    public void paintNode(Graphics g, Color c) {
        g.setColor(c);
        g.fillOval(this.x, this.y, this.radius, this.radius);
        g.drawString(identifier,this.x,this.y);
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
