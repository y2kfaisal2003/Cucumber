package com.utilities;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileWatcher {
	private static final String folder = System.getProperty("user.dir") +"/resources/InputFolder";

	public static void watchOffers() {

		Path filePath = Paths.get(folder);

		WatchService watchService;
		try {
			watchService = FileSystems.getDefault().newWatchService();

			//listen for create ,delete and modify event kinds
			filePath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		//
		while (true) {
			WatchKey key;
			try {
				//return signaled key, meaning events occurred on the object
				key = watchService.take();
			} catch (InterruptedException ex) {
				return;
			}

			//retrieve all the accumulated events
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind<?> kind = event.kind();               
				
				System.out.println("kind "+ kind.name());
				Path path = (Path)event.context();
				System.out.println(path.toString());
				
				if(kind.equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
					readOffer(path.toString());
				}
			}             
			//resetting the key goes back ready state
			key.reset();
		}

	}

	public static void writeOffer(String fileName, String offer) {
		Path filePath = Paths.get(folder+fileName);		

		ByteBuffer bb = ByteBuffer.wrap(offer.getBytes());

		try (FileChannel fc = (FileChannel.open(filePath,StandardOpenOption.WRITE,
				StandardOpenOption.TRUNCATE_EXISTING))) {
			bb.rewind();
			fc.write(bb);
		} catch (IOException ex) {
			System.out.println("exception in writing to offers file: "+ex);
		}
	}
	
	public static void readOffer(String fileName) {
		Path filePath = Paths.get(folder+fileName);

		ByteBuffer bb = ByteBuffer.allocate(100);

		Charset cset =  Charset.forName("UTF-8");
		StringBuilder sb = new StringBuilder();
		String off;
		try (FileChannel fc = (FileChannel.open(filePath,
				StandardOpenOption.READ))) {

			while (fc.read(bb) > 0) {
				bb.rewind();
				off  = cset.decode(bb).toString();
				sb.append(off);
				System.out.print(off);
				bb.flip();
			}
		} catch (IOException ex) {
			System.out.println("exception in reading file: "+ex);
			ex.printStackTrace();
		}
	}
}
