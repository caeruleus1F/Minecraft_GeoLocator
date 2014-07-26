package com.gbates31.minecraft_geolocator;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.bukkit.Bukkit;
import org.w3c.dom.*;

public class EndpointInterfacer implements Runnable {
	String address, playerName;
	
	public EndpointInterfacer (String iAddress, String iName) {
		address = iAddress;
		playerName = iName;
	}

	@Override
	public void run() {

		// insert code for retrieving location from IP
		InputStream is;
        Document xmlDoc = null;
        String city = null, regionName = null, countryCode = null;
        StringBuilder fullLocation = new StringBuilder ();
        NodeList response;
        
		synchronized (this) {
			try {
                DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                URL url = new URL ("http://www.freegeoip.net/xml/" + address);
                is = url.openStream();
                xmlDoc = dBuilder.parse(is);

                response = xmlDoc.getDocumentElement().getChildNodes();

                city = response.item(11).getTextContent();
                regionName = response.item(9).getTextContent();
                countryCode = response.item(5).getTextContent();

                fullLocation.append(city).append(", ").append(regionName).append(", ").append(countryCode);
                    
				Bukkit.getLogger().info(playerName + ": " + fullLocation.toString());
			} catch (Exception e) {
				Bukkit.getLogger().info("Exception caught when trying to parse data of " + playerName);
			} // end of try/catch
		} // end of synchronized
	}// end of run
}