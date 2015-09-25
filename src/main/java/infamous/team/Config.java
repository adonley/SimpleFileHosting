package infamous.team;

import java.io.File;

public class Config
{
    // Change this when deploying to production
    public static boolean TEST = true;
    public static String fileDirectory = Config.TEST
            ? System.getProperty("user.home") + File.separator + "Desktop"
            : System.getenv("persistdir");

    // TODO: Use hibernate and move these to the config file.
    public static final String dburl = "jdbc:mysql://localhost:3306/teaminf";
    public static final String dbclass = "com.mysql.jdbc.Driver";
    public static final String username = "";
    public static final String password = "";
}
