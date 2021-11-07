package br.com.javaNewFeature.watch;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServiceInJava7 {

	public static void main(String[] args) throws IOException, InterruptedException {
		directoryWatchService();
	}

	private static void directoryWatchService() throws IOException, InterruptedException {
		WatchService watchService = FileSystems.getDefault().newWatchService();
		Path path = Paths.get("C:\\teste");
		
		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
				StandardWatchEventKinds.ENTRY_DELETE);
		boolean poll = true;
		WatchKey key = watchService.take();
		while (poll) {
			for (WatchEvent<?> event : key.pollEvents()) {
				System.out.println("Event kind: " + event.kind() + " - For the file: " + event.context());
			}
			poll = key.reset();
		}
	}

}
