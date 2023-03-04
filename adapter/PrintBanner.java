package adapter;

public class PrintBanner extends Banner implements Print { // Adapter
    public PrintBanner(String string) {
        super(string);
    }
    public void printWeak() {
        showWithParen();
    }
    public void printStrong() {
        showWithAster();
    }
}
