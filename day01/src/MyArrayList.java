public class MyArrayList {
    private Cow[] elems;
	private int size;

	public MyArrayList() {
		elems = new Cow[10];
		size = 0;
	}

	public MyArrayList(int capacity) {
		elems = new Cow[capacity];
		size = 0;
	}

	public void add(Cow c) {
		elems[size] = c;
		size = size + 1;
	}

	public int size() {
		return size;
	}

	public Cow get(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return elems[index];
	}

	public Cow remove(int index) {
		Cow c = get(index);

		if(size < elems.length/4){
			int newSize = Math.max(elems.length/2, 10);
			Cow [] temp = new Cow[newSize];
			System.arraycopy(elems, 0, temp, 0,  size);
			elems = temp;
		}

		System.arraycopy(elems,index+1, elems, index, size-index-1);
		size = size - 1;
		return c;
	}

	public void add(int index, Cow c) {
		get(index);

		if(size == elems.length){
			Cow [] temp = new Cow[elems.length*2];
			System.arraycopy(elems, 0, temp, 0,  size);
			elems = temp;
		}

		System.arraycopy(elems, index, elems, index+1, size-index);
		elems[index] = c;
		size = size + 1;
	}
}
