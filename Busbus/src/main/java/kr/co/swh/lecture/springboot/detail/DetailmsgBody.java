package kr.co.swh.lecture.springboot.detail;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlRootElement(name="msgBody")
@XmlAccessorType(XmlAccessType.FIELD)
public class DetailmsgBody {
	
	@XmlElement(name = "busRouteStationList")
    private List<DetailBusRouteStationListTag> busRouteStationLists;

    public List<DetailBusRouteStationListTag> getBusRouteStationListTag() {
        return busRouteStationLists;
    }

    public void setBusRouteStationListTag(List<DetailBusRouteStationListTag> busRouteStationLists) {
        this.busRouteStationLists = busRouteStationLists;
    }

	@XmlElement(name = "busLocationList")
    private List<DetailBusLocationListTag> busLocationLists;
	
	public List<DetailBusLocationListTag> getBusLocationListTag() {
        return busLocationLists;
    }
	
	public void setBusLocationListTag(List<DetailBusLocationListTag> busLocationLists) {
        this.busLocationLists = busLocationLists;
    }
    
}