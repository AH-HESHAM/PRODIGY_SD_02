import GUI.AppWindow;
import GuessingGame.GuessingGameImp;

public class App {
    public static void main(String[] args) throws Exception {
        AppWindow appWindow = new AppWindow();
        appWindow.showWindow(new GuessingGameImp());
    }
}
