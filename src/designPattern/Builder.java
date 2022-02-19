package designPattern;

enum color {
    RED, BLACK, YELLOW
}

enum width {
    ZAI, MIDDLE, KUAN
}

enum height {
    AI, ZHONG, GAO
}

public class Builder {
    public color c;
    public width w;
    public height h;

    public Builder setColor(color c) {
        this.c = c;
        return this;
    }

    public Builder setWidth(width w) {
        this.w = w;
        return this;
    }

    public Builder setHeight(height h) {
        this.h = h;
        return this;
    }
}

class Door {
    public static void main(String[] args) {
        Builder b1 = new Builder().setColor(color.BLACK).setWidth(width.KUAN);
        System.out.println(b1);

        Builder b2 = new Builder().setHeight(height.GAO).setColor(color.RED).setWidth(width.ZAI);
        System.out.println(b2);
    }
}
