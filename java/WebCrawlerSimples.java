	/*************************************************************************
 *  Compilation:  javac WebCrawler.java
 *  Execution:    java WebCrawler url
 *  
 *  Downloads the web page and prints out all urls on the web page.
 *  Gives an idea of how Google's spider crawls the web. Instead of
 *  looking for hyperlinks, we just look for patterns of the form:
 *  http:// followed by an alternating sequence of alphanumeric
 *  characters and dots, ending with a sequence of alphanumeric 
 *  characters.
 *
 *  % java WebCrawler http://www.slashdot.org
 *  http://www.slashdot.org
 *  http://www.osdn.com
 *  http://sf.net
 *  http://thinkgeek.com
 *  ...
 *
 *
 *  Instead of setting the system property in the code, you could do it
 *  from the commandline
 *  % java -Dsun.net.client.defaultConnectTimeout=250 WebCrawler http://www.cs.princeton.edu
 
 *
 *************************************************************************/

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.net.*;
import java.io.*;

public class WebCrawlerSimples { 
	
    public static void main(String[] args) throws MalformedURLException, IOException { 
		
        // timeout connection after 500 miliseconds
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout",    "10000");
		
        // initial web page
        String s = "http://www.uff.br";
		
        // list of web pages to be examined
        Queue<String> q = new LinkedList<String>();
        q.add(s);
		
        String v = q.remove();
        URL url = new URL(v);
		
		URLConnection conexao = url.openConnection();
		InputStream stream = conexao.getInputStream();
		BufferedReader in = 
			new BufferedReader(
				new InputStreamReader(stream));
		
		String input = "";
		String inputLine;
		while ((inputLine = in.readLine()) != null) 
			input = input + inputLine;
		in.close();
		
		/*************************************************************
		*  Find links of the form: http://xxx.yyy.zzz
		*  \\w+ for one or more alpha-numeric characters
		*  \\. for dot
		*  could take first two statements out of loop
		*************************************************************/
    	String  regexp  = "http://(\\w+\\.)*(\\w+)";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(input);
			
        // find and print all matches
        while (matcher.find()) {
            String w = matcher.group();
            q.add(w);
        }
		
		for (String sUrl : q) {
			System.out.println(sUrl);
		}
	}
}
