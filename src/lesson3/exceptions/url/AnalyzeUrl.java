package lesson3.exceptions.url;

/**
 * Created by VMurashkin on 25.05.2015.
 * Analyze URL
 */
public class AnalyzeUrl {


    public void analyze(String str) throws UrlException {
        if (!str.contains("&")) throw new UrlException("There is no '&' in Url");
        String[] url = str.split("&");

        for (String s : url) {
            if (!s.contains("=")) throw new UrlException("There is no '=' in Url");
            String[] out = s.split("=");
            System.out.println("Param = " + out[0] + " : Value = " + out[1]);
        }
    }

    public static void main(String[] args) {
        String url1 = "param1=value1&param2=value2&param3=value3";
        String url2 = "param1&param2=value2&param3=value3";
        String url3 = "param1=value1param2=value2param3=value3";


        AnalyzeUrl au = new AnalyzeUrl();
        System.out.println("Parsing url1");
        try {
            au.analyze(url1);
        } catch (UrlException e) {
            e.printStackTrace();
        }
        System.out.println("Parsing url2");
        try {
            au.analyze(url2);
        } catch (UrlException e) {
            e.printStackTrace();
        }
        System.out.println("Parsing url3");
        try {
            au.analyze(url3);
        } catch (UrlException e) {
            e.printStackTrace();
        }


    }

}
