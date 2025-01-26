package kr.co.swh.lecture.springboot.next;

import javax.xml.bind.annotation.*;
import lombok.*;


@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter @ToString
public class NextBusRouteStationListTag {

    @XmlElement(name = "adminName")
    private String adminName;

    @XmlElement(name = "districtCd")
    private String districtCd;

    @XmlElement(name = "edStaId")
    private String edStaId;
    
    @XmlElement(name = "edStaNm")
    private String edStaNm;
    
    @XmlElement(name = "regionName")
    private String regionName;
    
    @XmlElement(name = "routeId")
    private String routeId;
    
    @XmlElement(name = "routeName")
    private String routeName;
    
    @XmlElement(name = "routeTypeCd")
    private String routeTypeCd;
    
    @XmlElement(name = "routeTypeName")
    private String routeTypeName;

    @XmlElement(name = "stStaId")
    private String stStaId;
    
    @XmlElement(name = "stStaNm")
    private String stStaNm;
    
    @XmlElement(name = "drtRouteYn")
    private String drtRouteYn;
    
    @XmlElement(name = "miriRoute")
    private String miriRoute;
    
    
    public NextBusRouteStationListTag() {}

    // Getter 및 Setter
    public String getadminName() {
        return adminName;
    }

    public void setadminName(String newAdminName) {
        this.adminName = newAdminName;
    }
    
    public String getdistrictCd() {
        return districtCd;
    }

    public void setdistrictCd(String newDistrictCd) {
        this.districtCd = newDistrictCd;
    }
    
    public String getedStaId() {
        return edStaId;
    }

    public void setedStaId(String newEdStaId) {
        this.edStaId = newEdStaId;
    }
    
    public String getedStaNm() {
        return edStaNm;
    }

    public void setedStaNm(String newEdStaNm) {
        this.edStaNm = newEdStaNm;
    }
    
    public String getrouteTypeCd() {
        return routeTypeCd;
    }

    public void setrouteTypeCd(String newRouteTypeCd) {
        this.routeTypeCd = newRouteTypeCd;
    }
    
    public String getregionName() {
        return regionName;
    }

    public void setregionName(String newRegionName) {
        this.regionName = newRegionName;
    }
    
    public String getrouteId() {
        return routeId;
    }

    public void setrouteId(String newRouteId) {
        this.routeId = newRouteId;
    }
    
    public String getrouteName() {
        return routeName;
    }

    public void setrouteName(String newRouteName) {
        this.routeName = newRouteName;
    }
    
    public String getrouteTypeName() {
        return routeTypeName;
    }

    public void setrouteTypeName(String newRouteTypeName) {
        this.routeTypeName = newRouteTypeName;
    }
    
    public String getstStaId() {
        return stStaId;
    }

    public void setstStaId(String newStStaId) {
        this.stStaId = newStStaId;
    }
    
    public String getstStaNm() {
        return stStaNm;
    }

    public void setstStaNm(String newStStaNm) {
        this.stStaNm = newStStaNm;
    }
    
    public String getdrtRouteYn() {
        return drtRouteYn;
    }

    public void setdrtRouteYn(String newDrtRouteYn) {
        this.drtRouteYn = newDrtRouteYn;
    }
    
    public String getmiriRoute() {
        return miriRoute;
    }

    public void setmiriRoute(String newMiriRoute) {
        this.miriRoute = newMiriRoute;
    }
    

    
}