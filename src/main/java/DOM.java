import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class DOM {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new File("src/main/houses.xml"));

            NodeList houseList = doc.getElementsByTagName("house");

            for (int i = 0; i < houseList.getLength(); i++) {
                Element house = (Element) houseList.item(i);

                System.out.println("Address: " + house.getElementsByTagName("address").item(0).getTextContent());
                System.out.println("Builder: " + house.getElementsByTagName("builder").item(0).getTextContent());
                System.out.println("Price: " + house.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("Construction Date: " + house.getElementsByTagName("construction_date").item(0).getTextContent());
                System.out.println("----------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
