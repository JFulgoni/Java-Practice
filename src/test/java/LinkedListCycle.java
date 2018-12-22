public class LinkedListCycle {
	
	public LinkedListCycle(){
		
	}
	
	// This is a version of the tortoise and the hare problem
	// We use one pointer that points to next, and one that points to next.next
	public boolean findCycle(ListNodeX head){
		ListNodeX tortoise;
		ListNodeX hare;
		if(head == null || head.next == null){
			return false;
		}
		tortoise = head;
		hare = head.next;
		while(hare.next != null && hare != null){
			tortoise = tortoise.next;
			hare = hare.next.next;
			if(tortoise == hare) break;
		}
		if(hare == null || hare.next == null){
			return false;
		}
		return true;
	}
	
	// if there's a cycle, return the node
	// else return null
	public ListNodeX detectCycle(ListNodeX head){
		ListNodeX tortoise;
		ListNodeX hare;
		if(head == null || head.next == null){
			return null;
		}
		tortoise = head;
		hare = head.next;
		while(hare.next != null && hare != null){
			tortoise = tortoise.next;
			hare = hare.next.next;
			if(tortoise == hare) break;
		}
		if(hare == null || hare.next == null){
			return null;
		}
		
		//this is the part that differs from the boolean method
		//returns the node where the cycle starts
		tortoise = head;
		while(tortoise != hare){
			tortoise = tortoise.next;
			hare = hare.next;
		}
		return tortoise;
	}
	
	// this code reverses a linked list from indexes m to n
	public ListNodeX reverseLinkedList(ListNodeX head, int m, int n){
		ListNodeX start = head;
		//find the first start position
		for(int i = 1; i < m; i++){
			start = start.next;
		}
		ListNodeX temp;
		ListNodeX end = start;
		ListNodeX current = start.next;
		for(int i = m; i < n; i++){
			temp = current.next;
			current.next = temp.next;
			temp.next = start.next;
			start.next = temp;
		}
		return head;
	}

}