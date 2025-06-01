package kr.co.swh.lecture.springboot.nova;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.dom.DOMSource;




public class NovaArrivalUnmarshalFromDOMSource {
    public static ArrayList<HashMap<String, String>> unmar(DOMSource domSource) throws JAXBException {
        // JAXBContext 생성: 변환할 클래스(RouteList.class)를 지정
        JAXBContext context = JAXBContext.newInstance(NovaArrival.class);

        // Unmarshaller 생성
        Unmarshaller unmarshaller = context.createUnmarshaller();
		
        // DOMSource를 이용하여 RouteList 객체로 변환
        NovaArrival novaArrival = (NovaArrival) unmarshaller.unmarshal(domSource);

        // 변환된 객체에서 BusRouteListTag 정보 추출
        List<NovaBusArrivalItemTag> busArrivalInfo = novaArrival.getBusArrivalItemTag();
        
        System.out.println(busArrivalInfo);

        ArrayList<HashMap<String, String>> tagList = new ArrayList<>();

        for (NovaBusArrivalItemTag bus : busArrivalInfo) {
            HashMap<String, String> tagMap = new HashMap<>();
            tagMap.put("plateNo1", bus.getplateNo1());
            tagMap.put("plateNo2", bus.getplateNo2());
            tagMap.put("predictTime1", bus.getpredictTime1());
            tagMap.put("predictTime2", bus.getpredictTime2());
            tagMap.put("locationNo1", bus.getlocationNo1());
            tagMap.put("locationNo2", bus.getlocationNo2());
            tagMap.put("routeDestName", bus.getrouteDestName());
            
            

            tagList.add(tagMap);
        }

        System.out.println("----------------------");
        System.out.println(tagList);

        return tagList;
    }
}