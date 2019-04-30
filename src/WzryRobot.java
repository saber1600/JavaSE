import java.awt.*;
import java.awt.event.InputEvent;

/**
 *  模拟器
 *      分辨率要求：720*1280
 *      屏幕缩放比例：100%
 */
public class WzryRobot implements Runnable{
    private Robot robot;
    private static boolean PLAYING = false;
    private static final int TIME = 500;
    // 模拟器左上角位置
    private static final int GAME_DIG_LX = 320;
    private static final int GAME_DIG_LY = 183;
    // 模拟器右下角位置
    private static final int GAME_DIG_RX = 1598;
    private static final int GAME_DIG_RY = 900;
    // 游戏界面长度，宽度
    private static int GAME_LENGTH;
    private static int GAME_WIDTH;
    // 判断游戏是否开始的位置
    private static final int GAME_START_X = 969;
    private static final int GAME_START_Y = 478;
    // 轮盘开始位置
    private static final int MOVE_BEGIN_X = 491;
    private static final int MOVE_BEGIN_Y = 745;
    // 轮盘结束位置
    private static final int MOVE_END_X = 852;
    private static final int MOVE_END_Y = 797;
    // 攻击键位置
    private static final int ATTACK_X = 1479;
    private static final int ATTACK_Y = 794;
    // 装备位置
    private static final int EQUIPMENT_X = 456;
    private static final int EQUIPMENT_Y = 471;
    // 失败、胜利继续按钮位置
    private static final int CONTINUE_X = 1056;
    private static final int CONTINUE_Y = 892;
    // 取死亡颜色位置
    private static final int DEATH_X = 450;
    private static final int DEATH_Y = 467;
    // 死亡颜色（根据死亡时，上方红色的地方取色）
    private static final Color DEATH_COLOR = new Color(82, 32, 22);
    // 玩家进入后血条颜色
    private static final Color LIVE_COLOR = new Color(90, 207, 23);


    public WzryRobot() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        init();
    }

    // 游戏开始
    @Override
    public void run() {
        // 一局游戏预备+运行阶段
       // while (true) {
            // 如果游戏开始
            /*while (!isGameStart()) {
                System.out.println("ready!");
            }*/
            // 开始停5秒
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.mouseMove(0, 0);
            showPoint();
            robot.delay(500);
            robot.mouseMove(123, 123);
            showPoint();
           // robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            //robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            //int count = 0;
            // 移动+攻击+买装备
            //while (true) {
                /*move();
                buyEquipment();
               // for (int i = 0; i < 1; i++)
                    attack();
                System.out.println("运行第：" + count + " 次");
                *//*if (count++ > 100) {
                    break;
                }*/
           // }
        //}
    }

    // 失败、胜利继续按钮
    public void continueNextGame() {
        mouseMoveAndClick(CONTINUE_X, CONTINUE_Y);
    }

    // 判断是否死亡
    public boolean isLife() {
        if (robot.getPixelColor(DEATH_X, DEATH_Y).equals(DEATH_COLOR))
            return false;
        return true;
    }

    // 人物移动
    public void move() {
        // 鼠标移动到轮盘
        robot.mouseMove(MOVE_BEGIN_X, MOVE_BEGIN_Y);
        showPoint();
        robot.delay(TIME);
        // 点击
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(TIME);
        // 拉动(5秒，分别在战场正左，中，右)
        robot.mouseMove(MOVE_END_X, MOVE_END_Y);
        showPoint();
        robot.delay(5000);
        // 释放
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(TIME);
    }

    // 攻击
    public void attack() {
        mouseMoveAndClick(ATTACK_X, ATTACK_Y);
    }

    // 购买装备
    public void buyEquipment() {
        mouseMoveAndClick(EQUIPMENT_X, EQUIPMENT_Y);
    }

    // 判断游戏开始
    public boolean isGameStart() {
        if (robot.getPixelColor(GAME_START_X, GAME_START_Y).equals(LIVE_COLOR))
            return true;
        return false;
    }

    // 移动鼠标到指定位置并点击
    private void mouseMoveAndClick(int x, int y) {
        robot.mouseMove(x, y);
        showPoint();
        robot.delay(TIME);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(TIME);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(TIME);
    }


    // 辅助初始化
    private void init() {
        GAME_LENGTH = GAME_DIG_RX - GAME_DIG_LX;
        GAME_WIDTH = GAME_DIG_RY - GAME_DIG_LY;
    }

    public void showPoint() {
        System.out.println(MouseInfo.getPointerInfo().getLocation());
    }
}
