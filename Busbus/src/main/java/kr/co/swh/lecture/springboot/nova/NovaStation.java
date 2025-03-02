package kr.co.swh.lecture.springboot.nova;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "msgBody")
@XmlAccessorType(XmlAccessType.FIELD)
public class NovaStation {
	@XmlElement(name = "busStationInfo")
    private List<NovaBusStationInfoTag> busStationInfos;

    public List<NovaBusStationInfoTag> getBusStationInfoTag() {
        return busStationInfos;
    }

    public void setPersons(List<NovaBusStationInfoTag> busStationInfos) {
        this.busStationInfos = busStationInfos;
    }

	
}
