import javax.swing.*;
import java.awt.*;

public class ProgressPanelBase extends JPanel {


    private int angle = 90;
    private JPanel infoPanel = new JPanel();
    private JPanel infoPanelBottom = new JPanel();

    private JLabel infoLabel  = new JLabel("", JLabel.CENTER);
    private JLabel infoLabelBottom  = new JLabel("", JLabel.CENTER);
    private Font font = new Font(null, Font.BOLD, 16);


    protected Double start = 90.0;
    protected int arcRadius = 250;
    protected int margin = 5;
    protected int infoPanelHeight = 30;


    public ProgressPanelBase() {
        super();

        this.setLayout(null);
        this.add(infoPanel);
        this.add(infoPanelBottom);

        infoPanel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        infoPanel.setLocation(margin, 0);
        infoPanel.setSize(arcRadius, infoPanelHeight);
        infoPanel.add(infoLabel);
        infoLabel.setFont(font);

        infoPanelBottom.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        infoPanelBottom.setLocation(margin, infoPanelHeight + arcRadius);
        infoPanelBottom.setSize(arcRadius, infoPanelHeight);
        infoPanelBottom.add(infoLabelBottom);
        infoLabelBottom.setFont(font);

    }

    public void setAngle(int aAngle) {
        this.angle = aAngle;
    }

    public int getAngle() {
        return angle;
    }

    public void setInfo(int aAngle, String aCaption, String aBottomCaption){
        infoLabel.setText(aCaption);
        infoLabelBottom.setText(aBottomCaption);
        angle = aAngle;
        this.revalidate();
        this.repaint();
    }

    protected void  onPaint(Graphics2D g){}

    protected void  onBeforePaint(Graphics2D g){}

    protected Color getMainProgressColor() {
        return new Color(0, 85, 0);
    }

    Color mainProgressColor;

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D gr2d = (Graphics2D) g;
        gr2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        BasicStroke p = new BasicStroke(5);
        gr2d.setStroke(p);

        mainProgressColor = getMainProgressColor();

        onBeforePaint(gr2d);

        gr2d.setColor(mainProgressColor);
        gr2d.fillArc(margin, infoPanelHeight, arcRadius, arcRadius, start.intValue(), -angle);

        gr2d.setColor(new Color(0, 60, 0));
        gr2d.drawOval(margin, infoPanelHeight, arcRadius, arcRadius);

        onPaint(gr2d);

    }

}
