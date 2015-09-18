package infamous.team;

public class Config
{
    public static boolean TEST = true;
    public static String fileDirectory = Config.TEST ? "/Users/Home/Desktop" : System.getenv("persistdir");
}
