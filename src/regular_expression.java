import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class regular_expression {
    public String getURLContent(String urlStr){
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                String temp = "";
                while((temp = reader.readLine())!=null){
                    sb.append(temp+'\n');
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        regular_expression test = new regular_expression();
        String result = test.getURLContent("http://jwzx.cqupt.edu.cn/data/json_StudentSearch.php?searchKey=04011708");
        System.out.println(result);

    }
}
