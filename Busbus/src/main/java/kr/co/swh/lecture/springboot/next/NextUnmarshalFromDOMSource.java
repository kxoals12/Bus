package kr.co.swh.lecture.springboot.next;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.dom.DOMSource;




public class NextUnmarshalFromDOMSource {
    public static ArrayList<HashMap<String, String>> unmar(DOMSource domSource) throws JAXBException {
        // JAXBContext 생성: 변환할 클래스(RouteList.class)를 지정
        JAXBContext context = JAXBContext.newInstance(NextRouteList.class);

        // Unmarshaller 생성
        Unmarshaller unmarshaller = context.createUnmarshaller();
		
        // DOMSource를 이용하여 RouteList 객체로 변환
        NextRouteList routeListTag = (NextRouteList) unmarshaller.unmarshal(domSource);

        // 변환된 객체에서 BusRouteListTag 정보 추출
        List<NextBusRouteStationListTag> busRouteList = routeListTag.getBusRouteListTag();

        ArrayList<HashMap<String, String>> tagList = new ArrayList<>();

        for (NextBusRouteStationListTag bus : busRouteList) {
            HashMap<String, String> tagMap = new HashMap<>();
            tagMap.put("adminName", bus.getadminName());
            tagMap.put("districtCd", bus.getdistrictCd());
            tagMap.put("edStaId", bus.getedStaId());
            tagMap.put("edStaNm", bus.getedStaNm());
            tagMap.put("regionName", bus.getregionName());
            tagMap.put("routeId", bus.getrouteId());
            tagMap.put("routeName", bus.getrouteName());
            tagMap.put("routeTypeCd", bus.getrouteTypeCd());
            tagMap.put("routeTypeName", bus.getrouteTypeName());
            tagMap.put("stStaId", bus.getstStaId());
            tagMap.put("stStaNm", bus.getstStaNm());
            tagMap.put("drtRouteYn", bus.getdrtRouteYn());
            tagMap.put("miriRoute", bus.getmiriRoute());

            tagList.add(tagMap);
        }

        System.out.println("----------------------");
        System.out.println(tagList);

        return tagList;
    }
}