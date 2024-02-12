import java.awt.*;

public abstract class Sprite implements Interactable {
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;

    protected float getLeft() {
        return x - halfWidth;
    }
    protected void setLeft(float left) {
        x = left + halfWidth;
    }
    protected float getRight() {
        return x + halfWidth;
    }
    protected void setRight(float right) {
        x = right - halfWidth;
    }
    protected float getTop() {
        return y - halfHeight;
    }
    protected void setTop(float top) {
        y = top + halfHeight;
    }
    protected float getBottom() {
        return y + halfHeight;
    }
    protected void setBottom(float bottom) {
        y = bottom - halfHeight;
    }

    protected float getWidth() {
        return 2f * halfWidth;
    }
    protected float getHeight() {
        return 2f * halfHeight;
    }

    public boolean inSprite(int x, int y) {
        return  x >= this.x - halfWidth
                && x <= this.x + halfWidth
                && y >= this.y - halfHeight
                && y <= this.y + halfHeight;
    }

    public void update(MainCanvas canvas, float deltaTime) {}
    public void render(MainCanvas canvas, Graphics g) {}

}
