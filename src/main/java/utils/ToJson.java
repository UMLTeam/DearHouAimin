package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.dguterd1;
import domain.dguterd2;
import domain.dguterd3;
import domain.dguterd4;
import org.json.JSONArray;


public class ToJson {
    public static String dguterd1OneToJosn(dguterd1 erd1) {
        // 声明一个Hash对象并添加数据
        Map<String, String> params = new HashMap<String, String>();
        params.put("dguterd1_id", "" + erd1.getDguterd1_id());
        params.put("dguterd1_title", erd1.getDguterd1_title());
        params.put("dguterd1_type", erd1.getDguterd1_type());
        params.put("dguterd1_date", erd1.getDguterd1_date().toString());
        params.put("dguterd1_origin", erd1.getDguterd1_origin());
        params.put("dguterd1_content", erd1.getDguterd1_content());
        params.put("dguterd1_state", "" + erd1.getDguterd1_state());
        // 声明JSONArray对象并输入JSON字符串
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(params);
        return jsonArray.toString();
    }

    public static String dguterd2OneToJosn(dguterd2 erd2) {
        // 声明一个Hash对象并添加数据
        Map<String, String> params = new HashMap<String, String>();
        params.put("dguterd1_id", "" + erd2.getDguterd2_id());
        params.put("dguterd1_title", erd2.getDguterd2_title());
        params.put("dguterd1_type", erd2.getDguterd2_type());
        params.put("dguterd1_date", erd2.getDguterd2_date().toString());
        params.put("dguterd1_content", erd2.getDguterd2_content());
        params.put("dguterd1_state", "" + erd2.getDguterd2_state());
        // 声明JSONArray对象并输入JSON字符串
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(params);
        return jsonArray.toString();
    }

    public static String dguterd3OneToJosn(dguterd3 erd3) {
        // 声明一个Hash对象并添加数据
        Map<String, String> params = new HashMap<String, String>();
        params.put("dguterd1_id", "" + erd3.getDguterd3_id());
        params.put("dguterd1_title", erd3.getDguterd3_title());
        params.put("dguterd1_type", erd3.getDguterd3_type());
        params.put("dguterd1_date", erd3.getDguterd3_date().toString());
        params.put("dguterd1_content", erd3.getDguterd3_content());
        params.put("dguterd1_state", "" + erd3.getDguterd3_state());
        // 声明JSONArray对象并输入JSON字符串
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(params);
        return jsonArray.toString();
    }

    public static String dguterd4OneToJosn(dguterd4 erd4) {
        // 声明一个Hash对象并添加数据
        Map<String, String> params = new HashMap<String, String>();
        params.put("dguterd1_id", "" + erd4.getDguterd4_id());
        params.put("dguterd1_title", erd4.getDguterd4_title());
        params.put("dguterd1_type", erd4.getDguterd4_type());
        params.put("dguterd1_date", erd4.getDguterd4_date().toString());
        params.put("dguterd1_content", erd4.getDguterd4_content());
        params.put("dguterd1_state", "" + erd4.getDguterd4_state());
        // 声明JSONArray对象并输入JSON字符串
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(params);
        return jsonArray.toString();
    }
//
//    public static String SimpleStudentToJson(SimpleStudent simpleStudent) {
//        // 声明一个Hash对象并添加数据
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("studentId", simpleStudent.getStudentId());
//        params.put("studentName", simpleStudent.getStudentName());
//        params.put("studentClass", simpleStudent.getStudentClass());
//        // 声明JSONArray对象并输入JSON字符串
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.put(params);
//        return jsonArray.toString();
//    }
    public static String dguterd1ToJosn(List<dguterd1> erd1List) {
        // 声明一个Hash对象并添加数据
        @SuppressWarnings("rawtypes")
        Map<String, List> params = new HashMap<String, List>();
        params.put("erd1List", erd1List);
        // 声明JSONArray对象并输入JSON字符串
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(params);
        return jsonArray.toString();
    }
    public static String dguterd2ToJosn(List<dguterd2> erd2List) {
        // 声明一个Hash对象并添加数据
        @SuppressWarnings("rawtypes")
        Map<String, List> params = new HashMap<String, List>();
        params.put("erd1List", erd2List);
        // 声明JSONArray对象并输入JSON字符串
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(params);
        return jsonArray.toString();
    }
    public static String dguterd3ToJosn(List<dguterd3> erd3List) {
        // 声明一个Hash对象并添加数据
        @SuppressWarnings("rawtypes")
        Map<String, List> params = new HashMap<String, List>();
        params.put("erd1List", erd3List);
        // 声明JSONArray对象并输入JSON字符串
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(params);
        return jsonArray.toString();
    }
    public static String dguterd4ToJosn(List<dguterd4> erd4List) {
        // 声明一个Hash对象并添加数据
        @SuppressWarnings("rawtypes")
        Map<String, List> params = new HashMap<String, List>();
        params.put("erd1List", erd4List);
        // 声明JSONArray对象并输入JSON字符串
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(params);
        return jsonArray.toString();
    }
}
