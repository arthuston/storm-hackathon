import java.lang.Math;

public class Areas {

    // http://en.wikipedia.org/wiki/List_of_United_States_cities_by_population
    private static final cities[] = {
        new LatLon("NewYork",40.6643,-73.9385),
        new LatLon("California",34.0194,-118.4108),
        new LatLon("Illinois",41.8376,-87.6818),
        new LatLon("Texas",29.7805,-95.3863),
        new LatLon("Pennsylvania",40.0094,-75.1333),
        new LatLon("Arizona",33.5722,-112.0880),
        new LatLon("Texas",29.4724,-98.5251),
        new LatLon("California",32.8153,-117.1350),
        new LatLon("Texas",32.7757,-96.7967),
        new LatLon("California",37.2969,-121.8193),
        new LatLon("Texas",30.3072,-97.7560),
        new LatLon("Florida",30.3370,-81.6613),
        new LatLon("Indiana",39.7767,-86.1459),
        new LatLon("California",37.7272,-123.0322),
        new LatLon("Ohio",39.9848,-82.9850),
        new LatLon("Texas",32.7795,-97.3463),
        new LatLon("NorthCarolina",35.2087,-80.8307),
        new LatLon("Michigan",42.3830,-83.1022),
        new LatLon("Texas",31.8484,-106.4270),
        new LatLon("Tennessee",35.1035,-89.9785),
        new LatLon("Massachusetts",42.3320,-71.0202),
        new LatLon("Washington",47.6205,-122.3509),
        new LatLon("Colorado",39.7618,-104.8806),
        new LatLon("Columbia",38.9041,-77.0171),
        new LatLon("Tennesee",36.1718,-86.7850),
        new LatLon("Maryland",39.3002,-76.6105),
        new LatLon("Kentucky",38.1781,-85.6667),
        new LatLon("Oregon",45.5370,-122.6500),
        new LatLon("Oklahoma",35.4671,-97.5137),
        new LatLon("Wisconsin",43.0633,-87.9667),
        new LatLon("Nevada",36.2277,-115.2640),
        new LatLon("NewMexico",35.1056,-106.6474),
        new LatLon("Arizona",32.1543,-110.8711),
        new LatLon("California",36.7827,-119.7945),
        new LatLon("California",38.5666,-121.4686),
        new LatLon("California",33.8091,-118.1553),
        new LatLon("Missouri",39.1252,-94.5511),
        new LatLon("Arizona",33.4019,-111.7174),
        new LatLon("Virginia",36.7793,-76.0240),
        new LatLon("Georgia",33.7629,-84.4227),
        new LatLon("Colorado",38.8673,-104.7607),
        new LatLon("NorthCarolina",35.8302,-78.6414),
        new LatLon("Nebraska",41.2647,-96.0419),
        new LatLon("Florida",25.7752,-80.2086),
        new LatLon("California",37.7699,-122.2256),
        new LatLon("Oklahoma",36.1279,-95.9023),
        new LatLon("Minnesota",44.9633,-93.2683),
        new LatLon("Ohio",41.4781,-81.6795),
        new LatLon("Kansas",37.6907,-97.3427),
        new LatLon("Texas",32.7007,-97.1247),
        new LatLon("Louisiana",30.0686,-89.9390),
        new LatLon("California",35.3212,-119.0183),
        new LatLon("Florida",27.9701,-82.4797),
        new LatLon("Hawai'i",21.3259,-157.8453),
        new LatLon("California",33.8555,-117.7601),
        new LatLon("Colorado",32.7007,-97.1247),
        new LatLon("California",33.7365,-117.8826),
        new LatLon("Missouri",38.6357,-90.2446),
        new LatLon("California",33.9381,-117.3932),
        new LatLon("Texas",27.7543,-97.1734),
        new LatLon("Pennsylvania",40.4398,-79.9766),
        new LatLon("Kentucky",38.0402,-84.4584),
        new LatLon("Alaska",61.1775,-149.2744),
        new LatLon("California",37.9763,-121.3133),
        new LatLon("Ohio",39.1399,-84.5064),
        new LatLon("Minnesota",44.9489,-93.1039),
        new LatLon("Ohio",41.6641,-83.5819),
        new LatLon("NewJersey",40.7242,-74.1726),
        new LatLon("NorthCarolina",36.0965,-79.8271),
        new LatLon("Texas",33.0508,-96.7479),
        new LatLon("Nevada",36.0122,-115.0375),
        new LatLon("Nebraska",40.8090,-96.6804),
        new LatLon("NewYork",42.8925,-78.8597),
        new LatLon("Indiana",41.0882,-85.1439),
        new LatLon("NewJersey",40.7114,-74.0648),
        new LatLon("California",32.6277,-117.0152),
        new LatLon("Florida",28.4159,-81.2988),
        new LatLon("Florida",27.7620,-82.6441),
        new LatLon("Virginia",36.9230,-76.2446),
        new LatLon("Arizona",33.2829,-111.8549),
        new LatLon("Texas",27.5477,-99.4869),
        new LatLon("Wisconsin",43.0878,-89.4301),
        new LatLon("NorthCarolina",35.9810,-78.9056),
        new LatLon("Texas",33.5665,-101.8867),
        new LatLon("NorthCarolina",36.1033,-80.2606),
        new LatLon("Texas",32.9098,-96.6304),
        new LatLon("Arizona",33.5331,-112.1899),
        new LatLon("Florida",25.8699,-80.3029),
        new LatLon("Nevada",39.4745,-119.7765),
        new LatLon("Louisiana",30.4485,-91.1259),
        new LatLon("California",33.6784,-117.7713),
        new LatLon("Virginia",36.6794,-76.3018),
        new LatLon("225,427",32.8577,-96.9700),
        new LatLon("Arizona",33.6687,-111.8237),
        new LatLon("Nevada",36.2830,-115.0893),
        new LatLon("California",37.4944,-121.9411),
        new LatLon("Arizona",33.3102,-111.7422),
        new LatLon("California",34.1393,-117.2953),
        new LatLon("Idaho",43.5985,-116.2311),
        new LatLon("Alabama",33.5274,-86.7990)
    };


    // latitude and longitude
    public class LatLon {
        public double lat, lon;
        public String city;
        public LatLon(String city, double lat, double lon) {
            this.city = city;
            this.lat = lat;
            this.lon = lon;
        }
    }

    // get area for lat lon
    public LatLon getArea(double lat, double lon) {

        // find closest city
        double minDistance = (double) Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i=0; i< cities.length; i++)
        {
            double tempDistance = distanceMiles( lat, lon, cities[i].lat, cities[i].lon );
            if( tempDistance < distance ) {
                distance = tempDistance;
                minIndex = i;
            }
        }   
        return cities[minIndex];
    }

    // get distance in miles
    private double distanceMiles(double lat1, double lon1, double lat2, double lon2) {
        return distance(lat1, lon1, lat2, lon2, "M");
    }

    // get distance in kilometers
    private double distanceKilometers(double lat1, double lon1, double lat2, double lon2) {
        return distance(lat1, lon1, lat2, lon2, "K");
    }

    // get distance specify units
    private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "K") {
            dist = dist * 1.609344;
        } else if (unit == "N") {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }


    var R = 6371; // km
    var dLat = (lat2-lat1).toRad();
    var dLon = (lon2-lon1).toRad();
    var lat1 = lat1.toRad();
    var lat2 = lat2.toRad();

    var a = Math.sin(dLat/2) * Math.sin(dLat/2) +
        Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); 
    var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
    var d = R * c;

}


