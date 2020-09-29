import java.io.FileNotFoundException;

public class Run {
    public static void main(String[] args) throws FileNotFoundException {
        LoadData loadData = new LoadData();
        loadData.load((args[0]));
    }
}
