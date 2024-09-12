package snaps;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.time.LocalDateTime;
public class Snap {
    public static void main(String[] args) {
        try {
            Robot bot = new Robot();
             String format="png";
             String name = "IM["+LocalDateTime.now()+"]."+format;
            if (!Files.exists(Paths.get(System.getProperty("user.home")+"/screen-cat/"))) {
                Files.createDirectories(Paths.get(System.getProperty("user.home")+"/screen-cat/"));
            }
             String path=System.getProperty("user.home")+"/screen-cat/img/";
            if(!Files.exists(Paths.get(path))){
                Files.createDirectories(Paths.get(path));
            }
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            System.out.println(Toolkit.getDefaultToolkit());
            BufferedImage screenFullImage = bot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(path+name));
        } catch (AWTException | IOException  e) {
            System.out.println(e);
        }
    }
}
