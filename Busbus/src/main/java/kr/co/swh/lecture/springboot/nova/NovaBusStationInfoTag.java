package kr.co.swh.lecture.springboot.nova;

import javax.xml.bind.annotation.*;
import lombok.*;


@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter @ToString
public class NovaBusStationInfoTag {

    @XmlElement(name = "centerYn")
    private String centerYn;

    @XmlElement(name = "districtCd")
    private String districtCd;

    @XmlElement(name = "drtStYn")
    private String drtStYn;
    
    @XmlElement(name = "mobileNoSi")
    private String mobileNoSi;
    
    @XmlElement(name = "regionName")
    private String regionName;
    
    @XmlElement(name = "stationId")
    private String stationId;
    
    @XmlElement(name = "stationName")
    private String stationName;
    
    @XmlElement(name = "toiletStYn")
    private String toiletStYn;
    
    @XmlElement(name = "x")
    private String x;
    
    @XmlElement(name = "y")
    private String y;
    
    @XmlElement(name = "routeName")
    private String routeName;
    
    
    public NovaBusStationInfoTag() {}

    // Getter 및 Setter
    public String getcenterYn() {
        return centerYn;
    }

    public void setcenterYn(String newCenterYn) {
        this.centerYn = newCenterYn;
    }
    
    public String getdistrictCd() {
        return districtCd;
    }

    public void setdistrictCd(String newDistrictCd) {
        this.districtCd = newDistrictCd;
    }
    
    public String getdrtStYn() {
        return drtStYn;
    }

    public void setdrtStYn(String newDrtStYn) {
        this.drtStYn = newDrtStYn;
    }
    
    public String getmobileNoSi() {
        return mobileNoSi;
    }

    public void setmobileNoSi(String newMobileNoSi) {
        this.mobileNoSi = newMobileNoSi;
    }
    
    public String getregionName() {
        return regionName;
    }

    public void setregionName(String newRegionName) {
        this.regionName = newRegionName;
    }

    public String getstationName() {
        return stationName;
    }

    public void setstationName(String newStationName) {
        this.stationName = newStationName;
    }

    public String getstationId() {
        return stationId;
    }
    
    public void setstationId(String newStationId) {
        this.stationId = newStationId;
    }

    public String gettoiletStYn() {
        return toiletStYn;
    }

    public void settoiletStYn(String newToiletStYn) {
        this.toiletStYn = newToiletStYn;
    }
    
    public String getrouteName() {
        return routeName;
    }

    public void setrouteName(String newRouteName) {
        this.routeName = newRouteName;
    }
    
    public String getx() {
        return x;
    }

    public void setx(String newX) {
        this.x = newX;
    }
    
    public String gety() {
        return y;
    }

    public void setye(String newY) {
        this.y = newY;
    }   
}