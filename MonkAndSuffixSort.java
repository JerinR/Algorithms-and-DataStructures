//https://www.hackerearth.com/codemonk-sorting/algorithm/monk-and-suffix-sort/

class MonkAndSuffixSort {
    public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int k = s.nextInt();
		int len = str.length();
		ArrayList<String> suffix = new ArrayList();
		suffix.add(str);
		for(int i=0;i<len;i++){			
			str = str.substring(1);
			suffix.add(str);
		}
		Collections.sort(suffix, new Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				return arg0.compareTo(arg1);
			}
			
		});
		System.out.println(suffix.get(k));
	}

