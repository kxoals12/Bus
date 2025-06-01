package kr.co.swh.lecture.springboot.nova;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.dom.DOMSource;




public class NovaStationUnmarshalFromDOMSource {
    public static ArrayList<HashMap<String, String>> unmar(DOMSource domSource) throws JAXBException {
        // JAXBContext 생성: 변환할 클래스(RouteList.class)를 지정
        JAXBContext context = JAXBContext.newInstance(NovaStation.class);

        // Unmarshaller 생성
        Unmarshaller unmarshaller = context.createUnmarshaller();
		
        // DOMSource를 이용하여 RouteList 객체로 변환
        NovaStation novaStation = (NovaStation) unmarshaller.unmarshal(domSource);

        // 변환된 객체에서 BusRouteListTag 정보 추출
        List<NovaBusStationInfoTag> busStationInfo = novaStation.getBusStationInfoTag();

        ArrayList<HashMap<String, String>> tagList = new ArrayList<>();

        for (NovaBusStationInfoTag bus : busStationInfo) {
            HashMap<String, String> tagMap = new HashMap<>();
            tagMap.put("centerYn", bus.getcenterYn());
            tagMap.put("districtCd", bus.getdistrictCd());
            tagMap.put("drtStYn", bus.getdrtStYn());
            tagMap.put("mobileNoSi", bus.getmobileNoSi());
            tagMap.put("regionName", bus.getregionName());
            tagMap.put("stationId", bus.getstationId());
            tagMap.put("stationName", bus.getstationName());
            tagMap.put("toiletStYn", bus.gettoiletStYn());
            tagMap.put("x", bus.getx());
            tagMap.put("y", bus.gety());
            tagMap.put("routeName", bus.getrouteName());
            tagList.add(tagMap);
        }

        System.out.println("----------------------");
        System.out.println(tagList);

        return tagList;
    }
}