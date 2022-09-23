package self.dharmesh;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class Main2 {

    private static void method2() {
        File xmlFile = new File("/Users/dharmesh/IdeaProjects/rdc/src/main/resources/DEMOTECH-NAME-360-INSURANCE-COMPANY-2022-08-24.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("ROCRA");
            // now XML is loaded as Document in memory, lets convert it to Object List
            List < RecordOfCreditRatingAction > recList = new ArrayList <> ();

            for (int i = 0; i < nodeList.getLength(); i++) {
                recList.add(getRocra(nodeList.item(i)));
            }
            // lets print User list information
            for (RecordOfCreditRatingAction rec: recList) {
                System.out.println(rec.toString());
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    private static RecordOfCreditRatingAction getRocra(Node node) {
        // XMLReaderDOM domReader = new XMLReaderDOM();
        RecordOfCreditRatingAction rocra = new RecordOfCreditRatingAction();

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            rocra.setFileCreationDate(getTagValue("FCD", element));
            rocra.setRatingAgencyName(getTagValue("RAN", element));
            NodeList x = node.getChildNodes();
            List<ObligorDetail> r = new ArrayList<>();

            for (int i = 0; i < x.getLength(); i++) {
                Node n = x.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equals("OD")) {
                    ObligorDetail od = new ObligorDetail();
                    Element e = (Element) n;
                    od.setObligorSecCategory(getTagValue("OSC", e));
                    od.setObligorName(getTagValue("OBNAME", e));
                    od.setObligorIdentifer(getTagValue("OI", e));
                    od.setObligorIdentifierScheme(getTagValue("OIS", e));
                    List<ObligorRatingDetail> r1 = new ArrayList<>();
                    NodeList y = n.getChildNodes();
                    for (int j = 0; j < y.getLength(); j++) {
                        Node n1 = y.item(j);
                        System.out.println("Node Name:" + n1.getNodeName() + "    Node Type:" + n1.getNodeType());
                        if (n1.getNodeType() == Node.ELEMENT_NODE && n1.getNodeName().equals("ORD")) {
                            ObligorRatingDetail ord = new ObligorRatingDetail();
                            Element e1 = (Element) n1;
                            ord.setIssuerPaid(getTagValue("IP", e1));
                            ord.setRating(getTagValue("R", e1));
                            ord.setRatingActionDate(getTagValue("RAD", e1));
                            ord.setRatingActionClass(getTagValue("RAC", e1));
                            ord.setRatingType(getTagValue("RT", e1));
                            r1.add(ord);
                        }
                    }
                    od.setObligorRatingDetailList(r1);
                    r.add(od);
                }
            }
            rocra.setObligorDetailList(r);
        }
        return rocra;
    }

    public static void main(String[] args) {

//        method1();
        method2();
        System.out.println("Hello world!");
    }
}