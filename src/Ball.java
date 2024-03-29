import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Ball extends Sprite {
    private static Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;

    Ball() {
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float) (Math.random() * 200f);
        vY = 100f + (float) (Math.random() * 200f);
    }

    Ball(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }


    @Override
    public void render(MainCanvas canvas, Graphics g) {
//        g.setColor(color);
//        g.fillOval((int) getLeft(), (int) getTop(),
//                (int) getWidth(), (int) getHeight());
        try {
            BufferedImage image = ImageIO.read(new File("image.png"));
            g.drawImage(image, (int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight(), color, null);
        } catch (IOException e) {}
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }
    }
}
