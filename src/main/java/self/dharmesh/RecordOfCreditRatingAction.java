package self.dharmesh;

import java.sql.Date;
import java.util.List;

public class RecordOfCreditRatingAction {
    private int id;
    private String ratingAgencyName; //RAN
    private String fileCreationDate; //FCD
    private List<ObligorDetail> obligorDetailList;
    private List<IssuerDetail> issuerDetailList;

    public RecordOfCreditRatingAction() {
    }

    public RecordOfCreditRatingAction(int id, String ratingAgencyName, String fileCreationDate, List<ObligorDetail> obligorDetailList, List<IssuerDetail> issuerDetailList) {
        this.ratingAgencyName = ratingAgencyName;
        this.fileCreationDate = fileCreationDate;
        this.obligorDetailList = obligorDetailList;
        this.issuerDetailList = issuerDetailList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRatingAgencyName() {
        return ratingAgencyName;
    }

    public void setRatingAgencyName(String ratingAgencyName) {
        this.ratingAgencyName = ratingAgencyName;
    }

    public String getFileCreationDate() {
        return fileCreationDate;
    }

    public void setFileCreationDate(String fileCreationDate) {
        this.fileCreationDate = fileCreationDate;
    }

    public List<ObligorDetail> getObligorDetailList() {
        return obligorDetailList;
    }

    public void setObligorDetailList(List<ObligorDetail> obligorDetailList) {
        this.obligorDetailList = obligorDetailList;
    }

    public List<IssuerDetail> getIssuerDetailList() {
        return issuerDetailList;
    }

    public void setIssuerDetailList(List<IssuerDetail> issuerDetailList) {
        this.issuerDetailList = issuerDetailList;
    }

    @Override
    public String toString() {
        return "RecordOfCreditRatingAction{" +
                "id=" + id +
                ", ratingAgencyName='" + ratingAgencyName + '\'' +
                ", fileCreationDate='" + fileCreationDate + '\'' +
                ", obligorDetailList=" + obligorDetailList +
                ", issuerDetailList=" + issuerDetailList +
                '}';
    }

}
