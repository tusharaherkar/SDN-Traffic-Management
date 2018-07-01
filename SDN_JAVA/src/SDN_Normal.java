import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;


public class SDN_Normal {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String user = "admin";
		String password = "admin";
		String baseURL = "http://127.0.0.1:8181/restconf/operational/opendaylight-inventory:nodes/";
		String QueueURL = "http://localhost:8181/restconf/config/network-topology:network-topology/topology/ovsdb:1/node/ovsdb:HOST1/ovsdb:queues/QUEUE-1/";
		String QOSURL = "http://localhost:8181/restconf/config/network-topology:network-topology/topology/ovsdb:1/node/ovsdb:HOST1/ovsdb:qos-entries/QOS-1/";
		JSONParser parser = new JSONParser();

Authenticator.setDefault(new Authenticator() {
	
	        protected PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication(
	   "admin", "admin".toCharArray());
	        }
	});
        StringBuffer result = new StringBuffer();
        try {

            
            //baseURL = baseURL + "";

            // Create URL = base URL + container
            URL url = new URL(QueueURL);

            // Create authentication string and encode it to Base64
            String authStr = user + ":" + password;
            String encodedAuthStr = Base64.encodeBase64String(authStr.getBytes());

            // Create Http connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set connection properties
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Basic" + encodedAuthStr);
            connection.setRequestProperty("Accept", "application/json");
		
            // Get the response from connection's inputStream
            InputStream content = (InputStream) connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(content));
            String line = "";
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            System.out.println("\n"+result.toString());
           //JSONObject nodes = new JSONObject(result.toString());
           
           org.json.simple.JSONObject jsonqueue = (org.json.simple.JSONObject) parser.parse(new FileReader("/home/tushar/workspace/SDN_Normal/src/Queue_final.json"));

            
           url = new URL(QueueURL+jsonqueue);
           
           // Create Http connection
           connection = (HttpURLConnection) url.openConnection();

           // Set connection properties
           connection.setRequestMethod("PUT");
           connection.setRequestProperty("Authorization", "Basic" + encodedAuthStr);
           connection.setRequestProperty("Content-Type", "application/json");
           connection.setRequestProperty("Accept", "application/json");
           connection.setUseCaches(false);
           connection.setDoInput(true);
           connection.setDoOutput(true);
           
          // OutputStream os = (OutputStream) connection.getOutputStream();
          // System.out.println("\n\n\nhere:"+os.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

	        
	    }
}


