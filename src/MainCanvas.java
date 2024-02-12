import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainCanvas extends JPanel {
    private long lastFrameTime;
    private List<Interactable> interactables = new ArrayList<>();

    MainCanvas() {
        lastFrameTime = System.nanoTime();
        interactables.add(new Background());
        for (int i = 1; i < 10; i++) {
            interactables.add(new Ball());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();
        repaint();
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < interactables.size(); i++) {
            interactables.get(i).update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < interactables.size(); i++) {
            interactables.get(i).render(canvas, g);
        }
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }
    public int getTop() {
        return 0;
    }
    public int getBottom() {
        return getHeight() - 1;
    }

}
