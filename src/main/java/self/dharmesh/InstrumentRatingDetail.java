package self.dharmesh;


public class InstrumentRatingDetail {
    private int id;
    private String issuerPaid; //IP
    private String rating; //R
    private String ratingActionDate; //RAD
    private RatingActionClassification ratingActionCategory; //RAC
    private String watchStatus; //WST
    private String ratingOutlook; //ROL
    private String otherAnnoucement; //OAN
    private String ratingType; //RT
    private String ratingSubtype; //RST
    private String ratingTypeTerm; //RTT

    public InstrumentRatingDetail() {
    }

    public InstrumentRatingDetail(int id, String issuerPaid, String rating, String ratingActionDate, RatingActionClassification ratingActionCategory, String watchStatus, String ratingOutlook, String otherAnnoucement, String ratingType, String ratingSubtype, String ratingTypeTerm) {
        this.id = id;
        this.issuerPaid = issuerPaid;
        this.rating = rating;
        this.ratingActionDate = ratingActionDate;
        this.ratingActionCategory = ratingActionCategory;
        this.watchStatus = watchStatus;
        this.ratingOutlook = ratingOutlook;
        this.otherAnnoucement = otherAnnoucement;
        this.ratingType = ratingType;
        this.ratingSubtype = ratingSubtype;
        this.ratingTypeTerm = ratingTypeTerm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public RatingActionClassification getRatingActionCategory() {
        return ratingActionCategory;
    }

    public void setRatingActionCategory(RatingActionClassification ratingActionCategory) {
        this.ratingActionCategory = ratingActionCategory;
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

    public String getOtherAnnoucement() {
        return otherAnnoucement;
    }

    public void setOtherAnnoucement(String otherAnnoucement) {
        this.otherAnnoucement = otherAnnoucement;
    }

    public String getRatingType() {
        return ratingType;
    }

    public void setRatingType(String ratingType) {
        this.ratingType = ratingType;
    }

    public String getRatingSubtype() {
        return ratingSubtype;
    }

    public void setRatingSubtype(String ratingSubtype) {
        this.ratingSubtype = ratingSubtype;
    }

    public String getRatingTypeTerm() {
        return ratingTypeTerm;
    }

    public void setRatingTypeTerm(String ratingTypeTerm) {
        this.ratingTypeTerm = ratingTypeTerm;
    }
}
