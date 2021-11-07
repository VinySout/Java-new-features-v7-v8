package br.com.java78;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//runAsync();
		//supplyASync();
		//thenApply();
		thenAccept();
		System.out.println("Main thread");
	}

	private static void runAsync() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> async = CompletableFuture.runAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(4);
				System.out.println("Running in a separate thread than the main thread.");
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		});
		System.out.println("runAsync Blocking 1");
		async.get();
		System.out.println("runAsync Blocking 2");
	}

	private static void supplyASync() throws InterruptedException, ExecutionException {
		CompletableFuture<String> async = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Supply Async";
		});
		
		System.out.println("SupplyASync Blocking 1");
		String result = async.get();
		System.out.println(result);
		System.out.println("SupplyASync Blocking 2");
	}

	private static void thenApply() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			} 
			return "then Apply";
		});
		
		System.out.println("then apply middle block");
		CompletableFuture<String> finalFuture = future.thenApply(name -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e2) {
				throw new IllegalStateException(e2);
			}
			return name + " then Apply 2";
		});

		System.out.println("then apply before final block");
		System.out.println(finalFuture.get());
		System.out.println("then apply blocking");
		
	}

	private static void thenAccept() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Accept";
		}).thenAccept(result -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			System.out.println("Received the value " + result);
		});
		
		System.out.println("ThenAccept non-blocking");
		future.get();
	}

}
