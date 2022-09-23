package self.dharmesh;

import java.util.List;

public class InstrumentDetail {
    private int id;
    private RatedObjectType objectType; //OBT
    private String instrumentName; //INSTNAME
    private String cusip; //CUSIP
    private String instrumentIdentifier; //INI
    private InstrumentIdentifierScheme instrumentIdentifierScheme; // INIS
    private String instrumentIdentifierOtherScheme; // INIOS
    private String instrumentRateTypeDescription; // IRTD
    private String couponRate; //CR
    private String maturityDate; //MD
    private double parValue; //PV
    private String instrumentIssuanceDate; //ISUD
    private String ratingOrganizationDebtCategory; //RODC
    private List<InstrumentRatingDetail> instrumentRatingDetailList;

    public InstrumentDetail() {
    }

    public InstrumentDetail(RatedObjectType objectType, String instrumentName, String cusip, String instrumentIdentifier,
                            InstrumentIdentifierScheme instrumentIdentifierScheme, String instrumentIdentifierOtherScheme,
                            String instrumentRateTypeDescription, String couponRate, String maturityDate,
                            double parValue, String instrumentIssuanceDate, String ratingOrganizationDebtCategory) {
        this.objectType = objectType;
        this.instrumentName = instrumentName;
        this.cusip = cusip;
        this.instrumentIdentifier = instrumentIdentifier;
        this.instrumentIdentifierScheme = instrumentIdentifierScheme;
        this.instrumentIdentifierOtherScheme = instrumentIdentifierOtherScheme;
        this.instrumentRateTypeDescription = instrumentRateTypeDescription;
        this.couponRate = couponRate;
        this.maturityDate = maturityDate;
        this.parValue = parValue;
        this.instrumentIssuanceDate = instrumentIssuanceDate;
        this.ratingOrganizationDebtCategory = ratingOrganizationDebtCategory;
    }

    public List<InstrumentRatingDetail> getInstrumentRatingDetailList() {
        return instrumentRatingDetailList;
    }

    public void setInstrumentRatingDetailList(List<InstrumentRatingDetail> instrumentRatingDetailList) {
        this.instrumentRatingDetailList = instrumentRatingDetailList;
    }

    public RatedObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(RatedObjectType objectType) {
        this.objectType = objectType;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getInstrumentIdentifier() {
        return instrumentIdentifier;
    }

    public void setInstrumentIdentifier(String instrumentIdentifier) {
        this.instrumentIdentifier = instrumentIdentifier;
    }

    public InstrumentIdentifierScheme getInstrumentIdentifierScheme() {
        return instrumentIdentifierScheme;
    }

    public void setInstrumentIdentifierScheme(InstrumentIdentifierScheme instrumentIdentifierScheme) {
        this.instrumentIdentifierScheme = instrumentIdentifierScheme;
    }

    public String getInstrumentIdentifierOtherScheme() {
        return instrumentIdentifierOtherScheme;
    }

    public void setInstrumentIdentifierOtherScheme(String instrumentIdentifierOtherScheme) {
        this.instrumentIdentifierOtherScheme = instrumentIdentifierOtherScheme;
    }

    public String getInstrumentRateTypeDescription() {
        return instrumentRateTypeDescription;
    }

    public void setInstrumentRateTypeDescription(String instrumentRateTypeDescription) {
        this.instrumentRateTypeDescription = instrumentRateTypeDescription;
    }

    public String getCouponRate() {
        return couponRate;
    }

    public void setCouponRate(String couponRate) {
        this.couponRate = couponRate;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    public double getParValue() {
        return parValue;
    }

    public void setParValue(double parValue) {
        this.parValue = parValue;
    }

    public String getInstrumentIssuanceDate() {
        return instrumentIssuanceDate;
    }

    public void setInstrumentIssuanceDate(String instrumentIssuanceDate) {
        this.instrumentIssuanceDate = instrumentIssuanceDate;
    }

    public String getRatingOrganizationDebtCategory() {
        return ratingOrganizationDebtCategory;
    }

    public void setRatingOrganizationDebtCategory(String ratingOrganizationDebtCategory) {
        this.ratingOrganizationDebtCategory = ratingOrganizationDebtCategory;
    }
}
