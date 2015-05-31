package tmp.test;

public class MyClass {

	private static class Progress implements IProgress {
		long n = 0;
		
		@Override
		public void update(double p) {
			final long rounded = Math.round(p);
			long add = rounded - n;
			n = rounded;
			
			while (add-- > 0)
				System.out.print('.');
		}
	}
	
	public static void main(String[] args) {
		Copy c = new Copy("c:\\1.txt", "c:\\2.txt", new Progress());
		c.start();
	}
}