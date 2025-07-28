import com.lx.fish.Fish;
import com.lx.fish.Shark;
import com.lx.sea.Sea;

public class Test1 {

	public static void main(String[] args) {
		Sea sea1 = new Sea();
		
		Fish fish1 = new Fish("물고기1");
		Fish fish2 = new Fish("물고기1");
		Fish fish3 = new Fish("물고기1");
		
		Shark shark1 = new Shark("상ㅅ어");
		
		System.out.println("물고기는 몇 마리? :" + Sea.count);

	}

}