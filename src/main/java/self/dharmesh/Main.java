package self.dharmesh;

import java.io.File;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Main {

    private static String getTagValue(String tag, Element element) {
        if (element.getElementsByTagName(tag).getLength() > 0) {
            Node n1 = element.getElementsByTagName(tag).item(0);
            if (n1 == null) {
                return null;
            } else {
                NodeList nodeList = n1.getChildNodes();
                Node node = (Node) nodeList.item(0);
                if (node == null) {
                    System.out.println("Node is null for tag:" + tag);
                    return null;
                } else {
                    return node.getNodeValue();
                }
            }
        } else {
            return null;
        }
    }

    private static ObligorRatingDetail getOrd(Node node) {
        boolean badFlag = false;
        ObligorRatingDetail ord = new ObligorRatingDetail();
        if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("ORD")) {
            Element e = (Element) node;
            if (getTagValue("IP", e) != null)
                ord.setIssuerPaid(getTagValue("IP", e));
            else {
                ord.setIssuerPaid("N/A");
                badFlag = true;
            }
            if (getTagValue("R", e) != null)
                ord.setRating(getTagValue("R", e));
            else {
                ord.setRating("N/A");
                badFlag = true;
            }
            if (getTagValue("RAD", e) != null)
                ord.setRatingActionDate(getTagValue("RAD", e));
            else {
                ord.setRatingActionDate("N/A");
                badFlag = true;
            }
            if (getTagValue("RAC", e) != null)
                ord.setRatingActionClass(getTagValue("RAC", e));
            else {
                ord.setRatingActionClass("N/A");
                badFlag = true;
            }
            if (getTagValue("RT", e) != null)
                ord.setRatingType(getTagValue("RT", e));
            else {
                ord.setRatingType("N/A");
                badFlag = true;
            }
            if (getTagValue("OAN", e) != null)
                ord.setOtherAnnouncement(getTagValue("OAN", e));
            else {
                ord.setOtherAnnouncement("N/A");
                badFlag = true;
            }
        }
        if (badFlag == true)
            System.out.println("BAD DATA EVENT");
        return ord;
    }

    private static List<ObligorDetail> getOd(Node node) {
        List<ObligorDetail> obligorDetailRecords = new ArrayList<>();
        boolean badFlag = false;
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            ObligorDetail od = new ObligorDetail();
            if(getTagValue("OSC", element) != null)
                od.setObligorSecCategory(getTagValue("OSC", element));
            else {
                od.setObligorSecCategory("N/A");
                badFlag = true;
            }
            if(getTagValue("OBNAME", element) != null)
                od.setObligorName(getTagValue("OBNAME", element));
            else {
                od.setObligorName("N/A");
                badFlag = true;
            }
            if(getTagValue("OI", element) != null)
                od.setObligorIdentifer(getTagValue("OI", element));
            else {
                od.setObligorIdentifer("N/A");
                badFlag = true;
            }
            if(getTagValue("OIS", element) != null)
                od.setObligorIdentifierScheme(getTagValue("OIS", element));
            else {
                od.setObligorIdentifierScheme("N/A");
                badFlag = true;
            }
            NodeList x = node.getChildNodes();
            List<ObligorRatingDetail> obligorRatingDetailRecords = new ArrayList<>();
//            System.out.println("x=" + x.getLength());

            for (int i = 0; i < x.getLength(); i++) {
                Node n = x.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equals("ORD")) {
                    ObligorRatingDetail ord = getOrd(n);
                    obligorRatingDetailRecords.add(ord);
                }
            }
            od.setObligorRatingDetailList(obligorRatingDetailRecords);
            obligorDetailRecords.add(od);
            if (badFlag == true)
                System.out.println("BAD DATA EVENT");
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

    private static List<File> getAllFiles(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .collect(Collectors.toList());
    }
    private static List<RecordOfCreditRatingAction> method2(File xmlFile) {
        //File xmlFile = new File("/Users/dharmesh/IdeaProjects/rdc/src/main/resources/DEMOTECH-NAME-360-INSURANCE-COMPANY-2022-08-24.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        List<RecordOfCreditRatingAction> recList = new ArrayList<>();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("ROCRA");
            // now XML is loaded as Document in memory, lets convert it to Object List

            for (int i = 0; i < nodeList.getLength(); i++) {
                recList.add(getRocra(nodeList.item(i)));
            }
            // lets print User list information
//            for (RecordOfCreditRatingAction rec : recList) {
//                System.out.println(rec.toString());
//            }
            return recList;
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
            System.out.println("COULD NOT PROCESS FILE: " + xmlFile.getName());
            return null;
        }

    }

    private static void saveToDb(Connection conn, List<RecordOfCreditRatingAction> records) {
//        Connection c = null;
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
//            Class.forName("org.postgresql.Driver");
//            c = DriverManager
//                    .getConnection("jdbc:postgresql://localhost:5432/dharmesh", "dharmesh", "daudje27");
//            System.out.println("guess i am connected.");
            int count = 0;

            PreparedStatement statement = conn.prepareStatement(sql_rocra, Statement.RETURN_GENERATED_KEYS);
            for (RecordOfCreditRatingAction rocra_rec : records) {
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
                        PreparedStatement ps1 = conn.prepareStatement(sql_od, Statement.RETURN_GENERATED_KEYS);
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
                                PreparedStatement ps2 = conn.prepareStatement(sql_ord, Statement.RETURN_GENERATED_KEYS);
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

    private static void processDemotechFile(Connection c){
        List<File> inputFiles = getAllFiles("/Users/dharmesh/projects/releases/insdata/src/main/resources/datafiles/demotech");

        int nbrFiles = inputFiles.size();

        for (File f : inputFiles) {
            //System.out.println("Processing file: " + f.getName());
            List<RecordOfCreditRatingAction> recs = method2(f);
            saveToDb(c, recs);
            //System.out.println("NUMBER OF FILES LEFT: " + --nbrFiles);
        }

    }


    public static void main(String[] args) {
//        method1();
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dharmesh", "dharmesh", "daudje27");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        processDemotechFile(c);

        processSPFiles(c);
    }
}
