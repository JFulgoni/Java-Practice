package john_test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DNASequence {
	
	private String seq;
	
	public DNASequence(String seq){
		this.seq = seq;
	}
	
	public Set<String> findTenSequence(){
		Set<String> seqSet = new HashSet<String>();
		Set<String> results = new HashSet<String>();
		for(int i = 0; i + 10 < seq.length(); ++i){
			String key = seq.substring(i, i + 10);
			if(!seqSet.contains(key)){
				seqSet.add(key);
			}
			else{
				results.add(key);
			}
		}
		return results;
	}
	
	public static void main(String[] args){
		DNASequence s = new DNASequence("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		Set<String> results = s.findTenSequence();
		Iterator iter = results.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

}
