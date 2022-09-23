package self.dharmesh;

import java.util.List;

public class ObligorDetail {
    private int id;
    private int rocraId;
    private String obligorSecCategory; //OSC
    private String obligorIndustryGroup; //OIG
    private String obligorName; //OBNAME
    private String legalEntityIdentifier; //LEI
    private String centralIndexKey; //CIK
    private String obligorIdentifer; //OI
    private String obligorIdentifierScheme; //OIS
    private String obligorIdentiferOtherScheme; //OIOS
    private List<ObligorRatingDetail> obligorRatingDetailList;

    public ObligorDetail() {
    }

    public ObligorDetail(int id, String obligorSecCategory, String obligorIndustryGroup, String obligorName,
                         String legalEntityIdentifier, String centralIndexKey, String obligorIdentifer,
                         String obligorIdentifierScheme, String obligorIdentiferOtherScheme) {
        this.id = id;
        this.obligorSecCategory = obligorSecCategory;
        this.obligorIndustryGroup = obligorIndustryGroup;
        this.obligorName = obligorName;
        this.legalEntityIdentifier = legalEntityIdentifier;
        this.centralIndexKey = centralIndexKey;
        this.obligorIdentifer = obligorIdentifer;
        this.obligorIdentifierScheme = obligorIdentifierScheme;
        this.obligorIdentiferOtherScheme = obligorIdentiferOtherScheme;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRocraId() {
        return rocraId;
    }

    public void setRocraId(int rocraId) {
        this.rocraId = rocraId;
    }

    public String getObligorSecCategory() {
        return obligorSecCategory;
    }

    public void setObligorSecCategory(String obligorSecCategory) {
        this.obligorSecCategory = obligorSecCategory;
    }

    public String getObligorIndustryGroup() {
        return obligorIndustryGroup;
    }

    public void setObligorIndustryGroup(String obligorIndustryGroup) {
        this.obligorIndustryGroup = obligorIndustryGroup;
    }

    public String getObligorName() {
        return obligorName;
    }

    public void setObligorName(String obligorName) {
        this.obligorName = obligorName;
    }

    public String getLegalEntityIdentifier() {
        return legalEntityIdentifier;
    }

    public void setLegalEntityIdentifier(String legalEntityIdentifier) {
        this.legalEntityIdentifier = legalEntityIdentifier;
    }

    public String getCentralIndexKey() {
        return centralIndexKey;
    }

    public void setCentralIndexKey(String centralIndexKey) {
        this.centralIndexKey = centralIndexKey;
    }

    public String getObligorIdentifer() {
        return obligorIdentifer;
    }

    public void setObligorIdentifer(String obligorIdentifer) {
        this.obligorIdentifer = obligorIdentifer;
    }

    public String getObligorIdentifierScheme() {
        return obligorIdentifierScheme;
    }

    public void setObligorIdentifierScheme(String obligorIdentifierScheme) {
        this.obligorIdentifierScheme = obligorIdentifierScheme;
    }

    public String getObligorIdentiferOtherScheme() {
        return obligorIdentiferOtherScheme;
    }

    public void setObligorIdentiferOtherScheme(String obligorIdentiferOtherScheme) {
        this.obligorIdentiferOtherScheme = obligorIdentiferOtherScheme;
    }

    public List<ObligorRatingDetail> getObligorRatingDetailList() {
        return obligorRatingDetailList;
    }

    public void setObligorRatingDetailList(List<ObligorRatingDetail> obligorRatingDetailList) {
        this.obligorRatingDetailList = obligorRatingDetailList;
    }

    @Override
    public String toString() {
        return "ObligorDetail{" +
                "id=" + id +
                ", obligorSecCategory='" + obligorSecCategory + '\'' +
                ", obligorIndustryGroup='" + obligorIndustryGroup + '\'' +
                ", obligorName='" + obligorName + '\'' +
                ", legalEntityIdentifier='" + legalEntityIdentifier + '\'' +
                ", centralIndexKey='" + centralIndexKey + '\'' +
                ", obligorIdentifer='" + obligorIdentifer + '\'' +
                ", obligorIdentifierScheme='" + obligorIdentifierScheme + '\'' +
                ", obligorIdentiferOtherScheme='" + obligorIdentiferOtherScheme + '\'' +
                ", obligorRatingDetailList=" + obligorRatingDetailList +
                '}';
    }
}
