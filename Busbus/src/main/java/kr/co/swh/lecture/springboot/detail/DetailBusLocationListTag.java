package kr.co.swh.lecture.springboot.detail;

import javax.xml.bind.annotation.*;
import lombok.*;


@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter 
public class DetailBusLocationListTag {

    @XmlElement(name = "vehId")
    private String vehId;

    @XmlElement(name = "stationSeq")
    private String stationSeq;

    @XmlElement(name = "suddenEntry")
    private String suddenEntry;
    
    
    
    public DetailBusLocationListTag() {}

    // Getter 및 Setter
    public String getvehId() {
        return vehId;
    }

    public void setvehId(String newVehId) {
        this.vehId = newVehId;
    }
    
    public String getstationSeq() {
        return stationSeq;
    }

    public void setstationSeq(String newstationSeq) {
        this.stationSeq = newstationSeq;
    }
    
    public String getsuddenEntry() {
        return suddenEntry;
    }

    public void setsuddenEntry(String newsuddenEntry) {
        this.suddenEntry = newsuddenEntry;
    }
    
    
}
