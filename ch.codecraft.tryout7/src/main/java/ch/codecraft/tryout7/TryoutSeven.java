package ch.codecraft.tryout7;

import java.util.HashMap;
import java.util.Map;

/**
 * Setting up Oracle Java 7 and Eclipse Indigo on Linux.
 * 
 * @author chris
 */
public class TryoutSeven {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put(args[0], args[1]);
		switch (map.get("key")) {
		case "value":
			System.out.println("Hello, Java 7");
			break;

		default:
			throw new RuntimeException();
		}
	}

}
