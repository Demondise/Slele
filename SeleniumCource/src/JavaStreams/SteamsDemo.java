package JavaStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class SteamsDemo {

	public static void main(String[] args) {
		List<String> st = new ArrayList<String>();
		st.add("Shivam");
		st.add("Lava");
		st.add("Ashok");
		st.add("Sanvi");
		st.add("Rishab");
		int count = 0;
		for(String i : st){
			if(i.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
		
		streamFilter(st);
		streamMap(st);
		collect(st);
	}
	
	static void streamFilter(List<String> st) {
		//if there is no intermediate operation than there is no terminal operation as well
		//terminal op will run only if intermediate filter returns true
		
		int a = (int) st.stream().filter(s->s.startsWith("S")).count();
		System.out.println(a);
		int b = (int) st.stream().filter(s->{
			s.startsWith("S");
			return false;}).count();
		System.out.println(b);
		Stream.of("Shivam","Ashok","Rishab","Rajkumari","Gaurav","Amber","Alok").filter(s->s.startsWith("A")).forEach(s->System.out.println(s));
		}
	static void streamMap(List<String> st) {
		st.stream().filter(s->s.length()>4).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		st.stream().filter(s->s.length()>4).map(s->s.toUpperCase()).limit(1).forEach(s->System.out.println(s));
		st.stream().filter(s->s.length()>4).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		Stream<String> newStream = Stream.concat(Stream.of("Shivamshar","Loki","Dinn"), st.stream());
		//newStream.filter(s->s.contains("S")).forEach(s->System.out.println(s));
		boolean g = newStream.anyMatch(s->s.equalsIgnoreCase("Shivam"));
	}
	static void collect(List<String> st) {
		List<String> s = st.stream().filter(sn->sn.endsWith("a")).collect(Collectors.toList());
		System.out.println(s);
		List<Integer> a = Stream.of(1,3,2,4,5,6,9,8,3,4,5,6,7,8).distinct().sorted().collect(Collectors.toList());
		System.out.println(a);
	}
}


