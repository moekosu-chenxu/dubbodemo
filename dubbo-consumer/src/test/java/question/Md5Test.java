package question;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Md5Test{

    public static void main(String[] args){
        String md5 = "abce$OO7+-*22L";
        Map<String, String> params = new TreeMap<String, String>();
        params.put("activityId", "ACT20180321149365042");
        params.put("dateTime", "20180326185118");
        params.put("method", "queryGiveChanceResult");
        params.put("msisdn", "15004910019");
        params.put("portalType", "WAP");
        params.put("portalID", "88888");
        params.put("signType", "MD5");
        params.put("transactionID", "20180326185118000001");
        params.put("transId", "4");
        System.out.println(transMap2String(params, md5));
    }

    private static String transMap2String(Map<String, String> params, String MD5Key)
    {
        Entry entry;
        StringBuilder sb = new StringBuilder();
        Iterator it = params.entrySet().iterator();
        while(it.hasNext()){
            entry = (Entry) it.next();
            if(entry.getValue() != null){
                sb.append(entry.getKey().toString()).append("=")
                        .append(entry.getValue().toString())
                        .append(it.hasNext()? "&" : "");
            }
        }
        return md5(sb.append(MD5Key).toString());
    }

    private static String md5(String str)
    {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(str.getBytes("UTF-8"));
            return toHex(bytes);
        }
        catch(Exception e){
            System.out.println("加密出错");
        }
        return "";
    }

    private static String toHex(byte[] bytes)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            if (Integer.toHexString(0xFF & bytes[i]).length() == 1){
                sb.append("0").append(Integer.toHexString(0xFF & bytes[i]));
            }else{
                sb.append(Integer.toHexString(0xFF & bytes[i]));
            }
        }
        return sb.toString().toUpperCase();
    }

}