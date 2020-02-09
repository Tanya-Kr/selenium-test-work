package weaveSocks.configuration;


public class Configuration {

    private static Configuration instance;
    private String schema = System.getProperty("schema", "http");
    private String host = System.getProperty("host", "167.172.110.35");
    private String port = System.getProperty("port", "80");
    private String apiPort = System.getProperty("port", "80");
    private String baseUrl;
    private String browser = System.getProperty("browser", "chrome");


    private Configuration() {
        init();
    }

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public String baseUrl() {
        return baseUrl;
    }

    public String getApiPort() {
        return apiPort;
    }

    private void init() {
        this.baseUrl = new UrlBuilder()
                .withSchema(schema)
                .withHost(host)
                .withPort(Integer.parseInt(port)).build();
    }

    public String getBrowser() {
        return browser;
    }
}
