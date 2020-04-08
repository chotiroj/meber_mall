package meber_mall.util;

import net.sf.json.JSONArray;

public class ToArray {
	public static Object[] toArray(JSONArray JA) {
		Object[]objects=new Object[JA.size()];
		for(int i=0;i<JA.size();i++) {
			objects[i]=JA.get(i);
		}
		return objects;
	}
}
