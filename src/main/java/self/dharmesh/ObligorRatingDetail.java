package self.dharmesh;

public class ObligorRatingDetail {
    private int id;
    private int odId;
    private String issuerPaid; //IP
    private String rating; //R
    private String ratingActionDate; //RAD
    private String ratingActionClass; //RAC
    private String watchStatus; //WST
    private String ratingOutlook; //ROL
    private String otherAnnouncement; //OAN
    private String ratingType; //RT
    private String ratingSubtypeScheme; //RST
    private String ratingTypeTerm; //RTT

    public ObligorRatingDetail() {
    }

    public ObligorRatingDetail(String issuerPaid, String rating, String ratingActionDate, String ratingActionClass, String watchStatus, String ratingOutlook, String otherAnnouncement, String ratingType, String ratingSubtypeScheme, String ratingTypeTerm) {
        this.issuerPaid = issuerPaid;
        this.rating = rating;
        this.ratingActionDate = ratingActionDate;
        this.ratingActionClass = ratingActionClass;
        this.watchStatus = watchStatus;
        this.ratingOutlook = ratingOutlook;
        this.otherAnnouncement = otherAnnouncement;
        this.ratingType = ratingType;
        this.ratingSubtypeScheme = ratingSubtypeScheme;
        this.ratingTypeTerm = ratingTypeTerm;
    }

    public String getIssuerPaid() {
        return issuerPaid;
    }

    public void setIssuerPaid(String issuerPaid) {
        this.issuerPaid = issuerPaid;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRatingActionDate() {
        return ratingActionDate;
    }

    public void setRatingActionDate(String ratingActionDate) {
        this.ratingActionDate = ratingActionDate;
    }

    public String getRatingActionClass() {
        return ratingActionClass;
    }

    public void setRatingActionClass(String ratingActionClass) {
        this.ratingActionClass = ratingActionClass;
    }

    public String getWatchStatus() {
        return watchStatus;
    }

    public void setWatchStatus(String watchStatus) {
        this.watchStatus = watchStatus;
    }

    public String getRatingOutlook() {
        return ratingOutlook;
    }

    public void setRatingOutlook(String ratingOutlook) {
        this.ratingOutlook = ratingOutlook;
    }

    public String getOtherAnnouncement() {
        return otherAnnouncement;
    }

    public void setOtherAnnouncement(String otherAnnouncement) {
        this.otherAnnouncement = otherAnnouncement;
    }

    public String getRatingType() {
        return ratingType;
    }

    public void setRatingType(String ratingType) {
        this.ratingType = ratingType;
    }

    public String getRatingSubtypeScheme() {
        return ratingSubtypeScheme;
    }

    public void setRatingSubtypeScheme(String ratingSubtypeScheme) {
        this.ratingSubtypeScheme = ratingSubtypeScheme;
    }

    public String getRatingTypeTerm() {
        return ratingTypeTerm;
    }

    public void setRatingTypeTerm(String ratingTypeTerm) {
        this.ratingTypeTerm = ratingTypeTerm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOdId() {
        return odId;
    }

    public void setOdId(int odId) {
        this.odId = odId;
    }

    @Override
    public String toString() {
        return "ObligorRatingDetail{" +
                "issuerPaid='" + issuerPaid + '\'' +
                ", rating='" + rating + '\'' +
                ", ratingActionDate='" + ratingActionDate + '\'' +
                ", ratingActionClass='" + ratingActionClass + '\'' +
                ", watchStatus='" + watchStatus + '\'' +
                ", ratingOutlook='" + ratingOutlook + '\'' +
                ", otherAnnouncement='" + otherAnnouncement + '\'' +
                ", ratingType='" + ratingType + '\'' +
                ", ratingSubtypeScheme='" + ratingSubtypeScheme + '\'' +
                ", ratingTypeTerm='" + ratingTypeTerm + '\'' +
                '}';
    }
}
