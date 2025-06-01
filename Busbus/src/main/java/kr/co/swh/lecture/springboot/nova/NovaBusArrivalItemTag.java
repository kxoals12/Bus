package kr.co.swh.lecture.springboot.nova;

import javax.xml.bind.annotation.*;
import lombok.*;


@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter @ToString
public class NovaBusArrivalItemTag {

    @XmlElement(name = "plateNo1")
    private String plateNo1;
    
    @XmlElement(name = "plateNo2")
    private String plateNo2;
    
    @XmlElement(name = "predictTime1")
    private String predictTime1;
    
    @XmlElement(name = "predictTime2")
    private String predictTime2;
    
    @XmlElement(name = "locationNo1")
    private String locationNo1;
    
    @XmlElement(name = "locationNo2")
    private String locationNo2;
    
    @XmlElement(name = "routeDestName")
    private String routeDestName;

    
    public NovaBusArrivalItemTag() {}

    public String getrouteDestName() {
        return routeDestName;
    }

    public void setrouteDestName(String newRouteDestName) {
        this.routeDestName = newRouteDestName;
    }
    
    // Getter 및 Setter
    public String getplateNo1() {
        return plateNo1;
    }

    public void setplateNo1(String newPlateNo1) {
        this.plateNo1 = newPlateNo1;
    }
    
    public String getplateNo2() {
        return plateNo2;
    }

    public void setplateNo2(String newPlateNo2) {
        this.plateNo2 = newPlateNo2;
    }  
    
    public String getpredictTime1() {
        return predictTime1;
    }

    public void setpredictTime1(String newPredictTime1) {
        this.predictTime1 = newPredictTime1;
    }
    
    public String getpredictTime2() {
        return predictTime2;
    }

    public void setpredictTime2(String newPredictTime2) {
        this.predictTime2 = newPredictTime2;
    }
    
    public String getlocationNo1() {
        return locationNo1;
    }

    public void setlocationNo1(String newLocationNo1) {
        this.locationNo1 = newLocationNo1;
    }
    
    public String getlocationNo2() {
        return locationNo2;
    }

    public void setlocationNo2(String newLocationNo2) {
        this.locationNo2 = newLocationNo2;
    }
    
}