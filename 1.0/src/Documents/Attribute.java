package Documents;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Attribute {
    public static void main(String[] args) {
        JSONObject a = new JSONObject();
        a.put("Name","ID");
        a.put("Type", "INT");
        a.put("KEY","Primary");
        a.put("Required", new Boolean(true));
        JSONObject b = new JSONObject();
        b.put("Name","Name");
        b.put("Type", "STR");
        b.put("KEY","FOREIGN");
        b.put("Required", new Boolean(false));

        JSONArray list = new JSONArray();
        list.add(a);
        list.add(b);
        //list.add(c);

        JSONObject array = new JSONObject();
        array.put("StoreA",list);
        System.out.println(array.toJSONString());


    }
}
