package kr.co.swh.lecture.springboot.detail;

import javax.xml.bind.annotation.*;
import lombok.*;


@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter @ToString
public class DetailBusRouteStationListTag {

    @XmlElement(name = "centerYn")
    private String centerYn;

    @XmlElement(name = "districtCd")
    private String districtCd;

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

    @XmlElement(name = "mapX")
    private String mapX;
    
    @XmlElement(name = "mapY")
    private String mapY;
    
    @XmlElement(name = "toiletStNm")
    private String toiletStNm;
    
    @XmlElement(name = "adminName")
    private String adminName;
    
    @XmlElement(name = "lastSepFlag")
    private String lastSepFlag;
    
    @XmlElement(name = "sepFlag")
    private String sepFlag;
    
    @XmlElement(name = "stationSeq")
    private String stationSeq;
    
    @XmlElement(name = "turnSeq")
    private String turnSeq;
    
    @XmlElement(name = "turnYn")
    private String turnYn;
    
    
    public DetailBusRouteStationListTag() {}

    // Getter 및 Setter
    public String getcenterYn() {
        return centerYn;
    }

    public void setadminName(String newCenterYn) {
        this.centerYn = newCenterYn;
    }
    
    public String getdistrictCd() {
        return districtCd;
    }

    public void setdistrictCd(String newdistrictCd) {
        this.districtCd = newdistrictCd;
    }
    
    public String getmobileNoSi() {
        return mobileNoSi;
    }

    public void setmobileNoSi(String newmobileNoSi) {
        this.mobileNoSi = newmobileNoSi;
    }
    
    public String getregionName() {
        return regionName;
    }

    public void setregionName(String newregionName) {
        this.regionName = newregionName;
    }
    
    public String getstationId() {
        return stationId;
    }

    public void setstationId(String newstationId) {
        this.stationId = newstationId;
    }
    
    public String getstationName() {
        return stationName;
    }

    public void setsetregionName(String newstationName) {
        this.stationName = newstationName;
    }
    
    public String gettoiletStYn() {
        return toiletStYn;
    }

    public void settoiletStYn(String newtoiletStYn) {
        this.toiletStYn = newtoiletStYn;
    }
    
    public String getx() {
        return x;
    }

    public void setx(String newx) {
        this.x = newx;
    }
    
    public String gety() {
        return y;
    }

    public void sety(String newy) {
        this.y = newy;
    }
    
    public String getmapX() {
        return mapX;
    }

    public void setmapX(String newmapX) {
        this.mapX = newmapX;
    }
    
    public String getmapY() {
        return mapY;
    }

    public void setmapY(String newmapY) {
        this.mapY = newmapY;
    }
    
    public String gettoiletStNm() {
        return toiletStNm;
    }

    public void settoiletStNm(String newtoiletStNm) {
        this.toiletStNm = newtoiletStNm;
    }
    
    public String getadminName() {
        return adminName;
    }

    public void setmiriRoute(String newadminName) {
        this.adminName = newadminName;
    }
    
    public String getlastSepFlag() {
        return lastSepFlag;
    }

    public void setlastSepFlag(String newlastSepFlag) {
        this.lastSepFlag = newlastSepFlag;
    }
    
    public String getsepFlag() {
        return sepFlag;
    }

    public void setnewsepFlag(String newsepFlag) {
        this.sepFlag = newsepFlag;
    }
    
    public String getstationSeq() {
        return stationSeq;
    }

    public void setstationSeq(String newstationSeq) {
        this.stationSeq = newstationSeq;
    }
    
    public String getturnSeq() {
        return turnSeq;
    }

    public void setturnSeq(String newturnSeq) {
        this.turnSeq = newturnSeq;
    }
    
    public String getturnYn() {
        return turnYn;
    }

    public void setturnYn(String newturnYn) {
        this.turnYn = newturnYn;
    }
    
}