package kr.co.swh.lecture.springboot.next;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlRootElement(name = "msgBody")
@XmlAccessorType(XmlAccessType.FIELD)
public class NextRouteList {
	@XmlElementWrapper(name="routeList")
    @XmlElement(name = "busRouteList")
    private List<NextBusRouteStationListTag> busRouteLists;

    public List<NextBusRouteStationListTag> getBusRouteListTag() {
        return busRouteLists;
    }

    public void setPersons(List<NextBusRouteStationListTag> busRouteLists) {
        this.busRouteLists = busRouteLists;
    }

	
}