package util;//import com.twodonik.webapp.sql.SqlHelper;
//import com.twodonik.webapp.storage.SqlStorage;
//import com.twodonik.webapp.storage.Storage;

import sql.Requests;
import sql.SqlHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    protected static final String PROPS = "/stoma.properties";
    private static final Config INSTANCE = new Config();

    private Properties prop = new Properties();
//    private File storageDir;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private Requests requests;


    public static Config get() {
        return INSTANCE;
    }

    private Config() {
        try (InputStream is = Config.class.getResourceAsStream(PROPS)) {
            prop.load(is);
//            storageDir = new File(prop.getProperty("storage.dir"));
            dbUrl = prop.getProperty("db.url");
            dbUser = prop.getProperty("db.user");
            dbPassword = prop.getProperty("db.password");
            requests = new Requests(new SqlHelper(dbUrl, dbUser, dbPassword));
        } catch (IOException e) {
            throw new IllegalStateException("invalid config file " + PROPS);
        }
    }

    public Requests getRequests() {
        return requests;
    }

//    public File getStorageDir() {
//        return storageDir;
//    }
    public String getDbUrl() {
        return dbUrl;
    }
    public String getDbUser() {
        return dbUser;
    }
    public String dbPassword() {
        return dbPassword;
    }
}
