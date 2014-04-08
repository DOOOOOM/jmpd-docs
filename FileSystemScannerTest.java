public class FileSystemScannerTest 
{
	public static void main (String[] args)
	{
		FileSystemScanner s = new FileSystemScanner();
		String[] paths = s.returnPathNames();
		for(String path : paths)
			System.out.println(path);
		System.out.print("Number of individual files found: " + paths.length);
	}
}
