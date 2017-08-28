import java.util.Iterator;
import java.util.Random;

public class RandomBag<Item> implements Iterable<Item> {
	int currentSize = 0;
	int currentPosition = 0;
	Item[] items;
	
	private int generateRandomIntBetweenArray(){
		 Random rand =new Random();
		int minimum = 0;
		int maximum = currentPosition-1;
	    int randomNum = rand.nextInt((maximum - minimum) + 1) + minimum;
	    return randomNum;
	}

	private class RandomBagIterator implements Iterator {
		private int currentIndex = 0;
		boolean isNumberHit[] = new boolean[currentPosition];
		int totalGenerated =0;
		@Override
		public boolean hasNext() {
	
			// TODO Auto-generated method stub
			if(totalGenerated<currentPosition){
				return true;
			}
			else{
				return false;
			}
		}

		
		private int searchForUnhittedInteger(){
		
			int returnIndex = 0;
			while((totalGenerated<=currentPosition) ){
				int generatedInteger = generateRandomIntBetweenArray();
				
				if(isNumberHit[generatedInteger]==false){
					totalGenerated++;
					returnIndex = generatedInteger;
					isNumberHit[generatedInteger]= true;
					break;
				}
				else{ // regenerate
					
				}
		}
			return returnIndex;
		}
		
		@Override
		public Object next() {
			// TODO Auto-generated method stub
			
			int ii = searchForUnhittedInteger();
			
			return items[ii];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	RandomBag(int size) {
		items = (Item[]) new Object[size];
	}

	void add(Item item) {
		
		items[currentPosition] = item;
		currentPosition++;
	}

	int size() {
		return this.currentPosition;
	}

	boolean isEmpty() {
		return (currentPosition != 0);
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub

		return new RandomBagIterator();
	}

}
