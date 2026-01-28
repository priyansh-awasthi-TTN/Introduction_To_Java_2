public class SingletonPattern{

    static class AppConfig {

        private static AppConfig instance;
        private String appName;

        private AppConfig() {
            appName = "My Application";
        }

        public static AppConfig getInstance() {

            if (instance == null) {        
                instance = new AppConfig();
            }

            return instance;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }
    }
    public static void main(String[] args) {

        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        config1.setAppName("Production App");

        System.out.println(config1.getAppName());
        System.out.println(config2.getAppName());

        System.out.println(config1 == config2);
    }
}
