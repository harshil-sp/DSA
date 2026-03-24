package Graphs.Painter;

import javax.swing.*;
import java.awt.*;

public class PaintBoard extends JFrame {

    private Painter painter;

    public PaintBoard(Painter painter, String boardTitle) {
        this.painter = painter;
        this.setLayout(new BorderLayout());
        this.setSize(painter.sheetWidth, painter.sheetHeight);
        this.setTitle(boardTitle);
        this.add("Center", painter);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void showBoard() {
        this.setVisible(true);
//        this.painter.paintGraph();
    }
}
