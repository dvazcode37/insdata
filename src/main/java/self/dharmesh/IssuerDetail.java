package self.dharmesh;

public class IssuerDetail {
    private String secCategory; //SSC
    private String issuerIndustryGroup; //IG
    private String issuerName; //ISSNAME
    private String legalEntityIdentifier; //LEI
    private String centralIndexKey; //CIK
    private String issuerIdentifier; //ISI
    private String issuerIdentifierScheme; //ISIS
    private String issuerIdentifierOtherScheme; //ISIOS

    public IssuerDetail() {
    }

    public IssuerDetail(String secCategory, String issuerIndustryGroup, String issuerName, String legalEntityIdentifier, String centralIndexKey, String issuerIdentifier, String issuerIdentifierScheme, String issuerIdentifierOtherScheme) {
        this.secCategory = secCategory;
        this.issuerIndustryGroup = issuerIndustryGroup;
        this.issuerName = issuerName;
        this.legalEntityIdentifier = legalEntityIdentifier;
        this.centralIndexKey = centralIndexKey;
        this.issuerIdentifier = issuerIdentifier;
        this.issuerIdentifierScheme = issuerIdentifierScheme;
        this.issuerIdentifierOtherScheme = issuerIdentifierOtherScheme;
    }

    public String getSecCategory() {
        return secCategory;
    }

    public void setSecCategory(String secCategory) {
        this.secCategory = secCategory;
    }

    public String getIssuerIndustryGroup() {
        return issuerIndustryGroup;
    }

    public void setIssuerIndustryGroup(String issuerIndustryGroup) {
        this.issuerIndustryGroup = issuerIndustryGroup;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
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

    public String getIssuerIdentifier() {
        return issuerIdentifier;
    }

    public void setIssuerIdentifier(String issuerIdentifier) {
        this.issuerIdentifier = issuerIdentifier;
    }

    public String getIssuerIdentifierScheme() {
        return issuerIdentifierScheme;
    }

    public void setIssuerIdentifierScheme(String issuerIdentifierScheme) {
        this.issuerIdentifierScheme = issuerIdentifierScheme;
    }

    public String getIssuerIdentifierOtherScheme() {
        return issuerIdentifierOtherScheme;
    }

    public void setIssuerIdentifierOtherScheme(String issuerIdentifierOtherScheme) {
        this.issuerIdentifierOtherScheme = issuerIdentifierOtherScheme;
    }
}
