package com.kwl2.poc.tika;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.ToXMLContentHandler;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.xml.sax.ContentHandler;

@SpringBootApplication
@Component
public class TikaPocApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(TikaPocApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		//BodyContentHandler handler = new BodyContentHandler(-1); //-1 to avoid char limit of 10000
		ContentHandler handler = new ToXMLContentHandler();
		
		FileInputStream fis = new FileInputStream(this.getClass().getClassLoader().getResource("shazam_top_100_world.html").getFile());
		ParseContext parseContext = new ParseContext();
		
		Metadata meta = new Metadata();
		
		Parser parser = new HtmlParser();
		parser.parse(fis, handler, meta, parseContext);
		
		Stream.of(meta.names()).forEach(m -> System.out.println(m + "=" + meta.get(m)));
		try (PrintWriter writer = new PrintWriter("C:\\Users\\KWL\\Desktop\\shazam_top_100_world_tika.html")){
			writer.println(handler.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
