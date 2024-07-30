package structural;
interface Window {
    void render();
}

class SimpleWindow implements Window {
    public void render() {
        System.out.println("Rendering simple window");
    }
}

abstract class WindowDecorator implements Window {
    protected Window decoratedWindow;

    public WindowDecorator(Window decoratedWindow) {
        this.decoratedWindow = decoratedWindow;
    }

    public void render() {
        decoratedWindow.render();
    }
}

class BorderDecorator extends WindowDecorator {
    public BorderDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    public void render() {
        super.render();
        System.out.println("Adding border");
    }
}

class ScrollDecorator extends WindowDecorator {
    public ScrollDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    public void render() {
        super.render();
        System.out.println("Adding scroll");
    }
}

class ShadowDecorator extends WindowDecorator {
    public ShadowDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    public void render() {
        super.render();
        System.out.println("Adding shadow");
    }
}

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Window simpleWindow = new SimpleWindow();

        Window decoratedWindow = new BorderDecorator(new ScrollDecorator(new ShadowDecorator(simpleWindow)));
        decoratedWindow.render();
    }
}
