import java.awt.*;

public class TEST {
    public static void main(String[] args) {
        /*WzryRobot wr = new WzryRobot();
        Thread t = new Thread(wr);
        t.start();*/
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.mouseMove(0, 0);
        System.out.println(MouseInfo.getPointerInfo().getLocation());
        robot.delay(500);
        robot.mouseMove(159, 323);
        System.out.println(MouseInfo.getPointerInfo().getLocation());

    }
}
