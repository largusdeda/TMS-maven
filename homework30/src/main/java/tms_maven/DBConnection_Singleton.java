package tms_maven;

public class DBConnection_Singleton {
    private static volatile DBConnection_Singleton instance;

    private DBConnection_Singleton() {}

    public static DBConnection_Singleton getInstance() {
        if (instance== null) {
            synchronized (DBConnection_Singleton.class) {
                if (instance == null) {
                    instance = new DBConnection_Singleton();
                }
            }
        }

        return instance;
    }
}
