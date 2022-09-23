package self.dharmesh;

import java.io.File;

import java.io.IOException;
import java.sql.*;
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


public class Main {

    private static List<RecordOfCreditRatingAction> method2() {
        File xmlFile = new File("/Users/dharmesh/IdeaProjects/rdc/src/main/resources/DEMOTECH-NAME-360-INSURANCE-COMPANY-2022-08-24.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        List<RecordOfCreditRatingAction> recList = new ArrayList<>();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("ROCRA");
            // now XML is loaded as Document in memory, lets convert it to Object List

            for (int i = 0; i < nodeList.getLength(); i++) {
                recList.add(getRocra(nodeList.item(i)));
            }
            // lets print User list information
            for (RecordOfCreditRatingAction rec : recList) {
                System.out.println(rec.toString());
            }
            return recList;
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
            return null;
        }

    }

    private static String getTagValue(String tag, Element element) {
        if (element.getElementsByTagName(tag).getLength() > 0) {
            Node n1 = element.getElementsByTagName(tag).item(0);
            if (n1 == null)
                return null;
            else {
                NodeList nodeList = n1.getChildNodes();
                Node node = (Node) nodeList.item(0);
                return node.getNodeValue();
            }
        } else
            return null;
    }

    private static ObligorRatingDetail getOrd(Node node) {
        ObligorRatingDetail ord = new ObligorRatingDetail();
        if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("ORD")) {
            Element e = (Element) node;
            if (getTagValue("IP", e) != null)
                ord.setIssuerPaid(getTagValue("IP", e));
            if (getTagValue("R", e) != null)
                ord.setRating(getTagValue("R", e));
            if (getTagValue("RAD", e) != null)
                ord.setRatingActionDate(getTagValue("RAD", e));
            if (getTagValue("RAC", e) != null)
                ord.setRatingActionClass(getTagValue("RAC", e));
            if (getTagValue("RT", e) != null)
                ord.setRatingType(getTagValue("RT", e));
            if (getTagValue("OAN", e) != null)
                ord.setOtherAnnouncement(getTagValue("OAN", e));
        }
        return ord;
    }

    private static List<ObligorDetail> getOd(Node node) {
        List<ObligorDetail> obligorDetailRecords = new ArrayList<>();

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            ObligorDetail od = new ObligorDetail();
            od.setObligorSecCategory(getTagValue("OSC", element));
            od.setObligorName(getTagValue("OBNAME", element));
            od.setObligorIdentifer(getTagValue("OI", element));
            od.setObligorIdentifierScheme(getTagValue("OIS", element));
            NodeList x = node.getChildNodes();
            List<ObligorRatingDetail> obligorRatingDetailRecords = new ArrayList<>();
            System.out.println("x=" + x.getLength());

            for (int i = 0; i < x.getLength(); i++) {
                Node n = x.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equals("ORD")) {
                    ObligorRatingDetail ord = getOrd(n);
                    obligorRatingDetailRecords.add(ord);
                }
            }
            od.setObligorRatingDetailList(obligorRatingDetailRecords);
            obligorDetailRecords.add(od);
        }
        return obligorDetailRecords;

    }

    private static RecordOfCreditRatingAction getRocra(Node node) {
        RecordOfCreditRatingAction rocra = new RecordOfCreditRatingAction();

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            rocra.setFileCreationDate(getTagValue("FCD", element));
            rocra.setRatingAgencyName(getTagValue("RAN", element));
            NodeList x = node.getChildNodes();
            List<ObligorDetail> obligorDetailRecords = new ArrayList<>();

            for (int i = 0; i < x.getLength(); i++) {
                Node n = x.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equals("OD")) {
                    obligorDetailRecords = getOd(n);
                    rocra.setObligorDetailList(obligorDetailRecords);
                }
            }
        }
        return rocra;
    }

    public static void main(String[] args) {
//        method1();
        List<RecordOfCreditRatingAction> recs = method2();
        Connection c = null;
        String sql_rocra = "INSERT INTO public.record_of_credit_rating_action\n" +
                "(rating_agency_name, file_creation_dt)\n" +
                "VALUES(?, ?);\n";
        String sql_od = "INSERT INTO public.obligor_detail\n" +
                "(sec_category, industry_group, obligor_name, legal_entity_identifier, central_index_key, obligor_identifier, obligor_identifier_scheme, obligor_identifier_other_scheme, rocra_id)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);\n";
        String sql_ord = "INSERT INTO public.obligor_rating_detail\n" +
                "(issuer_paid, rating, rating_action_date, rating_action_class, watch_status, rating_outlook, other_announcement, rating_type, rating_subtype_scheme, rating_type_term, od_id)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);\n";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/dharmesh", "dharmesh", "daudje27");
            System.out.println("guess i am connected.");
            int count = 0;

            PreparedStatement statement = c.prepareStatement(sql_rocra, Statement.RETURN_GENERATED_KEYS);
            for (RecordOfCreditRatingAction rocra_rec : recs) {
                statement.setString(1, rocra_rec.getRatingAgencyName());
                statement.setString(2, rocra_rec.getFileCreationDate());
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating ROCRA records failed, no rows affected.");
                }
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int rocraId = generatedKeys.getInt(1);
                    List<ObligorDetail> childRecs = rocra_rec.getObligorDetailList();
                    for (ObligorDetail crec : childRecs) {
                        crec.setRocraId(rocraId);
                        PreparedStatement ps1 = c.prepareStatement(sql_od, Statement.RETURN_GENERATED_KEYS);
                        ps1.setString(1, crec.getObligorSecCategory());
                        ps1.setString(2, crec.getObligorIndustryGroup());
                        ps1.setString(3, crec.getObligorName());
                        ps1.setString(4, crec.getLegalEntityIdentifier());
                        ps1.setString(5, crec.getCentralIndexKey());
                        ps1.setString(6, crec.getObligorIdentifer());
                        ps1.setString(7, crec.getObligorIdentifierScheme());
                        ps1.setString(8, crec.getObligorIdentiferOtherScheme());
                        ps1.setInt(9, crec.getRocraId());
                        int affectedRows2 = ps1.executeUpdate();

                        if (affectedRows2 == 0) {
                            throw new SQLException("Creating OD records failed, no rows affected.");
                        }
                        ResultSet generatedKeys2 = ps1.getGeneratedKeys();
                        if (generatedKeys2.next()) {
                            int odId = generatedKeys.getInt(1);
                            List<ObligorRatingDetail> ordRecs = crec.getObligorRatingDetailList();

                            for (ObligorRatingDetail ord : ordRecs) {
                                ord.setOdId(odId);
                                PreparedStatement ps2 = c.prepareStatement(sql_ord, Statement.RETURN_GENERATED_KEYS);
                                ps2.setString(1, ord.getIssuerPaid());
                                ps2.setString(2, ord.getRating());
                                ps2.setString(3, ord.getRatingActionDate());
                                ps2.setString(4, ord.getRatingActionClass());
                                ps2.setString(5, ord.getWatchStatus());
                                ps2.setString(6, ord.getRatingOutlook());
                                ps2.setString(7, ord.getOtherAnnouncement());
                                ps2.setString(8, ord.getRatingType());
                                ps2.setString(9, ord.getRatingSubtypeScheme());
                                ps2.setString(10, ord.getRatingTypeTerm());
                                ps2.setInt(11, ord.getOdId());
                                int affectedRows3 = ps2.executeUpdate();

                                if (affectedRows3 == 0) {
                                    throw new SQLException("Creating ORD records failed, no rows affected.");
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
