package kr.co.swh.lecture.springboot.nova;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "msgBody")
@XmlAccessorType(XmlAccessType.FIELD)
public class NovaArrival {
	@XmlElement(name = "busArrivalItem")
    private List<NovaBusArrivalItemTag> busArrivalItems;

    public List<NovaBusArrivalItemTag> getBusArrivalItemTag() {
        return busArrivalItems;
    }

    public void setPersons(List<NovaBusArrivalItemTag> busStationInfos) {
        this.busArrivalItems = busStationInfos;
    }

	
}
