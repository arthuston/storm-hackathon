public class Areas {

  // latitude and longitude
  public class LatLon {
    public float lat, lon;
	public LatLon(float lat, float lon) {
	  this.lat = lat;
	  this.lon = lon;
	}
  }
  
  // get area for lat lon
  public LatLon getArea(float lat, float lon) {
    // !FIX
	return new LatLon(lat, lon);
  }

}
  
  