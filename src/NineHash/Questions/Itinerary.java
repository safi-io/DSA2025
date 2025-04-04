package NineHash.Questions;

import java.util.HashMap;

class Itinerary {

    private static String initialPoint(HashMap<String, String> flights) {

        String keyCity = null;

        for (String e : flights.keySet()) {
            if (!flights.containsValue(e)) {
                return e;
            }
        }
        return null;
    }

    private static String terminalPoint(HashMap<String, String> flights) {
        String keyCity = null;

        for (String e : flights.values()) {
            if (!flights.containsKey(e)) {
                return e;
            }
        }

        return null;
    }


    private static void findPath(String initialPoint, String terminalPoint, HashMap<String, String> flights) {

        if (initialPoint.equals(terminalPoint)) {
            System.out.println(terminalPoint);
            return;
        }
        System.out.println(initialPoint);
        findPath(flights.get(initialPoint), terminalPoint, flights);

    }

    public static void main(String[] args) {
        HashMap<String, String> flights = new HashMap<>();
//        flights.put("Chennai", "Bengaluru");
//        flights.put("Mumbai", "Delhi");
//        flights.put("Goa", "Chennai");
//        flights.put("Delhi", "Goa");

        flights.put("MUC", "LHR");
        flights.put("JFK", "MUC");
        flights.put("SFO", "SJC");
        flights.put("LHR", "SFO");

//        Will work on this later

//        flights.put("JFK", "SFO");
//        flights.put("JFK", "ATL");
//        flights.put("SFO", "ATL");
//        flights.put("ATL", "JFK");
//        flights.put("ATL", "SFO");

        String initialPoint = initialPoint(flights);
        String terminalPoint = terminalPoint(flights);

        findPath(initialPoint, terminalPoint, flights);

    }
}

// Mumbai->Delhi->Goa->Chennai->Bengaluru