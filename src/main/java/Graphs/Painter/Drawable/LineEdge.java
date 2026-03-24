package Graphs.Painter.Drawable;

import java.awt.*;

public class LineEdge {
    public CircleNode nodeA,nodeB;

    public LineEdge(CircleNode a, CircleNode b) {
        this.nodeA = a;
        this.nodeB = b;
    }

    public void paintLine(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(nodeA.x+(nodeA.radius/2), nodeA.y+(nodeA.radius/2), nodeB.x+(nodeB.radius/2), nodeB.y+(nodeB.radius/2));
    }
}
