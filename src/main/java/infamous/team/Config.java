package infamous.team;

public class Config
{
    public static boolean TEST = false;
    public static String fileDirectory = Config.TEST ? "/Users/andrew/Desktop" : System.getenv("persistdir");
}
