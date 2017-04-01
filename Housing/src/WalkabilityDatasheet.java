/**
 * Created by Keegan on 3/31/2017.
 */

import org.json.*;
public class WalkabilityDatasheet {
    JSONObject object = new JSONObject("jobsPerHouseHold.json");
    String name = (String) object.get("name");
}
