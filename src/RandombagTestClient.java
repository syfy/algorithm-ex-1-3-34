
public class RandombagTestClient {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			RandomBag<Integer> bags = new RandomBag<Integer>(11);
			bags.add(3);
			bags.add(2);
			bags.add(1);
			bags.add(0);
			
			for(Integer t:bags){
				System.out.print(t+" "+"\n");
			}
	}

}
