package Graphs.Painter.Drawable;

import java.awt.*;

public class PointerEdge extends LineEdge {

    private static final int TOWARDS_NODE_B = 2;
    private static final int TOWARDS_NODE_A = 1;
    private static int POINTS_TOWARDS = TOWARDS_NODE_B;

    public PointerEdge(CircleNode a, CircleNode b) {
        super(a, b);
        POINTS_TOWARDS = TOWARDS_NODE_B;
    }

    public PointerEdge(CircleNode a, CircleNode b, int pointing_position) {
        super(a, b);
        POINTS_TOWARDS = pointing_position;
    }

    @Override
    public void paintLine(Graphics g) {
        g.setColor(Color.black);

        g.drawLine(nodeA.x+(nodeA.radius/2), nodeA.y+(nodeA.radius/2), nodeB.x+(nodeB.radius/2), nodeB.y+(nodeB.radius/2));
        g.fillOval(nodeB.x+(nodeB.radius/2)-5, nodeB.y+(nodeB.radius/2)-5, 10, 10);
    }
}
