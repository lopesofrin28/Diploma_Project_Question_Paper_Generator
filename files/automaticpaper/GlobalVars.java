/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticpaper;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class GlobalVars {

    private static GlobalVars instance = null;
    private static Map<String, String> userMap = null;

    private GlobalVars() {
        // Exists only to defeat instantiation.
    }

    public static GlobalVars getInstance() {
        if (instance == null) {
            instance = new GlobalVars();
        }
        return instance;
    }

    public static Map<String, String> getGlobalMap() {
        if (userMap == null) {
            userMap = new HashMap<>();
        }
        return userMap;
    }

    public static void addValuesToGlobalMap(String key, String value) {
        if (userMap == null) {
            userMap = new HashMap<>();
        }
        if (key == null || value == null) {
            return;
        }
        userMap.put(key, value);
    }
}