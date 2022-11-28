package solera.berny.dev.project.backend.utils;

import us.dustinj.timezonemap.TimeZoneMap;

public class TimeZoneMapTest {



    public static void main(String[] args) {
        TimeZoneMap map = TimeZoneMap.forEverywhere();

        String berlin = map.getOverlappingTimeZone(52.518424, 13.404776).getZoneId(); // Returns "Europe/Berlin"
        System.out.println(berlin);
    }

}
