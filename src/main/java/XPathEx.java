import javax.xml.xpath.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class XPathEx {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("src/main/houses.xml"));

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            String expression = "/catalog/house[price > 1000]";
            NodeList expensiveHouses = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

            for (int i = 0; i < expensiveHouses.getLength(); i++) {
                Element house = (Element) expensiveHouses.item(i);
                System.out.println("Address: " + house.getElementsByTagName("address").item(0).getTextContent());
                System.out.println("Price: " + house.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("----------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
