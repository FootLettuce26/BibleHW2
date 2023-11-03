package bibleHomework2;

import java.util.ArrayList; //ArrayLists can be adjusted in size 
import java.util.Iterator;

public class Driver {

	public static void main(String[] args) {
		ArrayList<HumanGroup> disciples = new ArrayList<HumanGroup>();
		HumanGroup firstDisciples = new HumanGroup();
		firstDisciples.Age = 30;
		firstDisciples.Population = 13;
		firstDisciples.IsDisciple = true;
		disciples.add(firstDisciples);
		
		ArrayList<HumanGroup> nonBelievers = new ArrayList<HumanGroup>();
		HumanGroup otherHuman = new HumanGroup();
		otherHuman.Age = 18;
		otherHuman.Population = 7700000000L - 13;
		nonBelievers.add(otherHuman);
		
		ArrayList<HumanGroup> apprentices = new ArrayList<HumanGroup>();
		
		long totalPopulation = getPopulation(disciples, nonBelievers, apprentices);
		long christianPopulation = getPopulation(disciples);
		
		
		while(christianPopulation < totalPopulation) {
			//adding disciples to start if there are any
			
			
			//taking care of kiling population
			//checking who is going to die, remove them first
			//also add the aging function in here, age increase by 1
			Iterator<HumanGroup> discipleIt = disciples.iterator();
			while(discipleIt.hasNext()) { //hasNext checks to see if there is another element in the list
				HumanGroup curr = discipleIt.next(); //setting curr to next element
				if(curr.Age >= Human.MaxAge) {
					disciples.remove(curr);
				}else if(curr.Age < Human.MaxAge) {
					curr.Aging();
				}
			}
			Iterator<HumanGroup> apprenticeIt = apprentices.iterator();
			while(apprenticeIt.hasNext()) {
				HumanGroup curr2 = apprenticeIt.next();
				if(curr2.Age >= Human.MaxAge) {
					apprentices.remove(curr2);
				}else if(curr2.Age < Human.MaxAge) {
					curr2.Aging();
				}
			}
			Iterator<HumanGroup> nonBelieverIt = nonBelievers.iterator();
			while(nonBelieverIt.hasNext()) {
				HumanGroup curr3 = nonBelieverIt.next();
				if(curr3.Age >= Human.MaxAge) {
					nonBelievers.remove(curr3);
				}else if(curr3.Age < Human.MaxAge) {
					curr3.Aging();
				}
			}
			
			//checking to see if there is a new baby
			long totalPeople = 0;
			HumanGroup baby = new HumanGroup();
			
			baby.Population = totalPeople;
			nonBelievers.add(baby);
			
			//check if nonBeliever can be apprentice, check number of disciples
			//check number of qualified non-believers(age)
			//loop through all nonbelievers, and convert all groups until totalQualifiedDisciple 
			long totalQualifiedDisciple = 0;
			Iterator<HumanGroup> nonBelieverIterator = nonBelievers.iterator();
			while(nonBelieverIterator.hasNext()) {
				HumanGroup curr = nonBelieverIterator.next();
				if(curr.Age == Human.AgeAsApprentice) {
					apprentices.add(curr);
					totalQualifiedDisciple++;
				}
			}
			
			//check if apprentice graduate from apprenticeship
			//change the isDisciple property, isApprentice property
			Iterator<HumanGroup> graduateIt = apprentices.iterator();
			while(graduateIt.hasNext()) {
				HumanGroup curr = graduateIt.next();
				if(curr.Age == Human.AgeToBeDisciple) {
					curr.SetIsDisciple();
					
				}

			}
		}
		
	}
	
	public static long getPopulation(ArrayList<HumanGroup> dis, ArrayList<HumanGroup> non, ArrayList<HumanGroup> app) {
		long total = 0;
		
		for(HumanGroup h: dis) {
			total += h.Population;
		}
		for(HumanGroup h: non) {
			total += h.Population;
		}
		for(HumanGroup h: app) {
			total += h.Population;
		}
		return total;
	}
	
	public static long getPopulation(ArrayList<HumanGroup> dis) {
		long total = 0;
		for(HumanGroup h: dis) {
			total += h.Population;
		}
		return total;
	}
	
	

}
